package myhealthylife.telegram.bot.handlers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.sentencegenerator.model.entities.Sentence;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class UserDataHandler {

	public static DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	
	public static String registerNewUser(String username, String password, String name, String surname, String sex, String birthdate) {
		
		Person p = new Person();
		p.setUsername(username);
		p.setTelegramUsername(username);
		p.setPassword(password);
		p.setFirstname(name);
		try {
			p.setBirthdate(format.parse(birthdate));
		} catch (ParseException e) {
			p.setBirthdate(null);
		}
		p.setSex(sex);
		
		Response res= ServicesLocator.getCentric1Connection().path("user/register").request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(p, MediaType.APPLICATION_JSON));
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			p=res.readEntity(Person.class);
			return p.getUsername() + " user created";
		}
		else{
			return "An unexpected error occured";
		}
	}
	
	
	public static Person getPerson(String username) {
		
		Person p = null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/" + username).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			p=res.readEntity(Person.class);
			return p;
		}
		else{
			return null;
		}
		
	}
	
	public static String updateName(String username, String name) {
		
		Person p = UserDataHandler.getPerson(username);
		
		if(p!=null) {
		
			p.setFirstname(name);
			
			Response res= ServicesLocator.getCentric1Connection().path("user/data/" + username).request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(p, MediaType.APPLICATION_JSON));
			
			if(res.getStatus()==Response.Status.OK.getStatusCode()) {
				p=res.readEntity(Person.class);
				return p.getUsername() + " user updated: \nFirstname: " + p.getFirstname() + "\nLastname: " + p.getLastname() + "\nSex: " + p.getSex() + "\nBirthdate: " + p.getBirthdate();
			}
			else{
				return "An unexpected error occured";
			}	
		}
		
		else{
			return "Cannot get the person";
		}
	}
	
	
	
	
	
}
