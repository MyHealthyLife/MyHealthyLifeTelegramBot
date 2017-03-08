package myhealthylife.telegram.bot.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class FoodHandler {

	public static String foodForMe(String personId){
		
		Person p=null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		Response foodsResponse=ServicesLocator.getCentric1Connection().path("/recipe/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(foodsResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}
		
		return foodsResponse.toString();
		
	}
}
