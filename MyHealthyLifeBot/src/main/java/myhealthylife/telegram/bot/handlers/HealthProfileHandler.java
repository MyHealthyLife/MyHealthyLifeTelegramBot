package myhealthylife.telegram.bot.handlers;

import java.util.Iterator;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.MeasureHistory;
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
}
