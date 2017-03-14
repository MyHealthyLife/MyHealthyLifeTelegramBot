package myhealthylife.telegram.bot.handlers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.dataservice.model.util.Utilities;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class UserDataHandler {

	public static DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	
	
	public static String registerNewUser(Integer telegramID,String serviceUsername){
		Response resp=ServicesLocator.getCentric1Connection().path("/user/data/"+serviceUsername).request().accept(MediaType.APPLICATION_JSON).get();
		
		/*check if centric01 returns an "ok"*/
		if(resp.getStatus()!=Response.Status.OK.getStatusCode()){
			return "Username not found, register first on the webapp";
		}
		
		Person p=resp.readEntity(Person.class);
		p.setTelegramID(""+telegramID);
		
		Response updateRes=ServicesLocator.getCentric1Connection().path("/user/data/"+serviceUsername).request().put(Entity.entity(p, MediaType.APPLICATION_JSON));
		
		if(updateRes.getStatus()!=Response.Status.OK.getStatusCode()){
			return "Unable to register";
		}
		
		return "Succesfully registered to the system";
	}
	
	@Deprecated
	public static String registerNewUser(String username, String password, String name, String surname, String sex, String birthdate) {
		
		Person p = new Person();
		p.setUsername(username);
		p.setTelegramUsername(username);
		p.setPassword(password);
		p.setFirstname(name);
		try {
			p.setBirthdate(birthdate);
		} catch (Exception e) {
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
	
	
	public static Person getPerson(String personId) {
		
		Person p = null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/" + personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			p=res.readEntity(Person.class);
			return p;
		}
		else{
			return null;
		}
		
	}
	
	public static String updateName(String personId, String name) {
		
		Person p = UserDataHandler.getPerson(personId);
		
		String username=p.getUsername();
		
		if(p!=null) {
		
			p.setFirstname(name);
			
			Response res= ServicesLocator.getCentric1Connection().path("user/data/" + username).request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(p, MediaType.APPLICATION_JSON));
			
			if(res.getStatus()==Response.Status.OK.getStatusCode()) {
				p=res.readEntity(Person.class);
				return p.getUsername() + " user updated: \nFirstname: " + p.getFirstname() + "\nLastname: " + p.getLastname() + "\nSex: " + p.getSex() + "\nBirthdate: " + Utilities.getReadableDate(p.getBirthdate());
			}
			else{
				return "An unexpected error occured";
			}	
		}
		
		else{
			return "Cannot get the person";
		}
	}
	
	
	
	public static String updateSurnameName(String personId, String surname) {
		
		Person p = UserDataHandler.getPerson(personId);
		String username=p.getUsername();
		
		if(p!=null) {
		
			p.setLastname(surname);
			
			Response res= ServicesLocator.getCentric1Connection().path("user/data/" + username).request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(p, MediaType.APPLICATION_JSON));
			
			if(res.getStatus()==Response.Status.OK.getStatusCode()) {
				p=res.readEntity(Person.class);
				return p.getUsername() + " user updated: \nFirstname: " + p.getFirstname() + "\nLastname: " + p.getLastname() + "\nSex: " + p.getSex() + "\nBirthdate: " + Utilities.getReadableDate(p.getBirthdate());
			}
			else{
				return "An unexpected error occured";
			}	
		}
		
		else{
			return "Cannot get the person";
		}
	}
	
	
	
	public static String updateBirthdate(String personId, String birthdate) {
		
		Person p = UserDataHandler.getPerson(personId);
		
		String username=p.getUsername();
		
		if(p!=null) {

			try {
				p.setBirthdate(birthdate);
			} catch (Exception e) {
				// do nothing
			}
			Response res= ServicesLocator.getCentric1Connection().path("user/data/" + username).request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(p, MediaType.APPLICATION_JSON));
			
			if(res.getStatus()==Response.Status.OK.getStatusCode()) {
				p=res.readEntity(Person.class);
				return p.getUsername() + " user updated: \nFirstname: " + p.getFirstname() + "\nLastname: " + p.getLastname() + "\nSex: " + p.getSex() + "\nBirthdate: " + Utilities.getReadableDate(p.getBirthdate());
			}
			else{
				return "An unexpected error occured";
			}	
		}
		
		else{
			return "Cannot get the person";
		}
	}
	
	
	
	
	public static String deleteUserInformation(String personId_t, String confirmation) {
		
	
		Person p = UserDataHandler.getPerson(personId_t);
		
		String username=p.getUsername();
		
		if(p!=null) {
	
			Response res= ServicesLocator.getCentric1Connection().path("user/data/" + username).request().accept(MediaType.APPLICATION_JSON).delete();
			
			if(res.getStatus()==Response.Status.OK.getStatusCode()) {
				Long personId=res.readEntity(Long.class);
				
				if(personId==p.getIdPerson()) {
					return p.getUsername() + " user has been deleted";
				}
				else{
					return "An unexpected error occured";
				}
			}
			else{
				return "An unexpected error occured";
			}	
		}
		
		else{
			return "This user does not exist";
		}
	}
	
	
}
