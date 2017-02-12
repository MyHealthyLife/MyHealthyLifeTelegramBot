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

	public static String getCurrentHealth(String username){
		
		Person p=null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/"+username).request().accept(MediaType.APPLICATION_JSON).get();
		
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
				result+=m.getMeasureType()+" "+m.getMeasureValue()+( m.getDateRegistered()!=null?" ["+m.getDateRegistered()+"]\n":"\n");
			}
			
			return result;
		}
		else{
			return "Type /register to register into the system";
		}
	}
	
	public static String getHealthHistory(String username){
		Response res=ServicesLocator.getCentric1Connection().path("measure/"+username+"/history").request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(res.getStatus());
			return "Information not available ";
		}
		
		MeasureHistory mh=res.readEntity(MeasureHistory.class);
		
		Iterator<Measure> iterator=mh.getMeasures().iterator();
		
		String result="measures: \n";
		
		
		while(iterator.hasNext()){
			Measure m=iterator.next();
			result+=m.getMeasureType()+" "+m.getMeasureValue()+( m.getDateRegistered()!=null?" ["+m.getDateRegistered()+"]\n":"\n");
		}
		
		return result;
	}
	
	public static String addMeasure(String username,String type,String value){
		Measure m=new Measure();
		m.setDateRegistered(new Date(System.currentTimeMillis()));
		m.setMeasureType(type);
		
		try{
			m.setMeasureValue(Double.parseDouble(value));
			
		}
		catch (Exception e) {
			return "use /addmeasure <type> <value>";
		}
		
		Response res=ServicesLocator.getCentric1Connection().path("measure/"+username).request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(m, MediaType.APPLICATION_JSON));
		
		if(res.getStatus()==Response.Status.OK.getStatusCode())
		{
			return "Measure saved";
		}
		
		return "Measure NOT saved";
	}
	
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
