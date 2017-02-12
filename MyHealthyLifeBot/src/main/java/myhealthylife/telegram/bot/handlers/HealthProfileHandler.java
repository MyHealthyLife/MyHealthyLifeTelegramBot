package myhealthylife.telegram.bot.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class HealthProfileHandler {

	public static String getCurrentHealth(String username){
		
		Person p=null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/"+username).request().accept(MediaType.APPLICATION_XML).get();
		
		if(res.getStatus() ==Response.Status.OK.getStatusCode())
		{
			p=res.readEntity(Person.class);
			return p.getFirstname();
		}
		else{
			return "Type /register to register into the system";
		}
	}
}
