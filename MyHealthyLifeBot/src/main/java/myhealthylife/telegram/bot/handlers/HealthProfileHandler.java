package myhealthylife.telegram.bot.handlers;

import java.util.Date;
import java.util.Iterator;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.MeasureHistory;
import myhealthylife.dataservice.model.MeasureTypeList;
import myhealthylife.dataservice.model.entities.Measure;
import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class HealthProfileHandler {

	/**
	 * retrieve the current health profile of the person and print it in a formatted way
	 * @param personId
	 * @return
	 */
	public static String getCurrentHealth(String personId){
		
		Person p=null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode())
		{
			p=res.readEntity(Person.class);
			
			if(p.getHealthProfile()==null)
				return "the health profile is not available";
			
			if(p.getHealthProfile().getCurrentHealth()==null)
				return "the health profile is not available";
			
			if(p.getHealthProfile().getCurrentHealth().getMeasure().size()==0)
				return "the health profile is not available";
			
			String result="measures: \n";
			
			Iterator<Measure> it=p.getHealthProfile().getCurrentHealth().getMeasure().iterator();
			
			while(it.hasNext()){
				Measure m=it.next();
				result+=m.getMeasureType()+" "+m.getMeasureValue();
				if( m.getDateRegistered()!=null)
					result+=" ["+m.getDateRegistered()+"]\n";
				else
					result+="\n";
			}
			
			return result;
		}
		else{
			return "Type /register to register into the system";
		}
	}
	
	/**
	 * retrieve the measure history of the person and print it in a formatted way
	 * @param personId
	 * @return
	 */
	public static String getHealthHistory(String personId){
		
		
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		//handle errors
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		
		Person p=resPerson.readEntity(Person.class);
		
		
		Response res=ServicesLocator.getCentric1Connection().path("measure/"+p.getUsername()+"/history").request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(res.getStatus());
			return "Information not available ";
		}
		
		MeasureHistory mh=res.readEntity(MeasureHistory.class);
		
		Iterator<Measure> iterator=mh.getMeasures().iterator();
		
		String result="measures: \n";
		
		
		while(iterator.hasNext()){
			Measure m=iterator.next();
			result+=m.getMeasureType()+" "+m.getMeasureValue();
			if( m.getDateRegistered()!=null)
				result+=" ["+m.getDateRegistered()+"]\n";
			else
				result+="\n";
		}
		
		return result;
	}
	
	/**
	 * save a new measure for a person
	 * @param personId the id of the person
	 * @param type the type of the measure (weight, height, etc...)
	 * @param value the value of the measure
	 * @return
	 */
	public static String addMeasure(String personId,String type,String value){
		
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		//check if the account exists
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		
		Person p=resPerson.readEntity(Person.class);
		String username=p.getUsername();
		
		
		//create the measure object
		Measure m=new Measure();
		m.setDateRegistered(new Date(System.currentTimeMillis()));
		m.setMeasureType(type);
		
		try{
			m.setMeasureValue(Double.parseDouble(value));
			
		}
		catch (Exception e) {
			return "use /addmeasure <type> <value>";
		}
		
		//save the measure
		Response res=ServicesLocator.getCentric1Connection().path("measure/"+username).request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(m, MediaType.APPLICATION_JSON));
		
		if(res.getStatus()==Response.Status.OK.getStatusCode())
		{
			return "Measure saved";
		}
		
		return "Measure NOT saved";
	}
	
	/**
	 * return a message which contains all the measure type available in the system
	 * @return
	 */
	public static String getMeasureTypes(){
		Response res=ServicesLocator.getCentric1Connection().path("measuretypes").request().accept(MediaType.APPLICATION_JSON).get();
		if(res.getStatus()!=Response.Status.OK.getStatusCode())
			return "Error";
		
		MeasureTypeList list=res.readEntity(MeasureTypeList.class);
		
		Iterator<String> it=list.getMeasureType().iterator();
		
		String result="type of measure available:\n\n";
		
		while(it.hasNext()){
			result+=it.next()+"\n";
		}
		
		return result;
	}
}
