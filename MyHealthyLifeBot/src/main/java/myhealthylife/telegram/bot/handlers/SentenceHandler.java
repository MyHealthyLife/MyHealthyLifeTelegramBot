package myhealthylife.telegram.bot.handlers;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.sentencegenerator.model.entities.DedicatedSentence;
import myhealthylife.sentencegenerator.model.entities.Sentence;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class SentenceHandler {
	
	
	
	public static String getAllSentences(String username) {
		
		Sentence s = null;
		
		Response res= ServicesLocator.getCentric1Connection().path("sentence").request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(Sentence.class);
			return s.getText();
		}
		else{
			return "An unexpected error occured";
		}
	}
	
	public static String getRandomSentence() {
		
		Sentence s = null;
		
		Response res= ServicesLocator.getCentric1Connection().path("sentence/random").request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(Sentence.class);
			return s.getText();
		}
		else{
			return "An unexpected error occured";
		}
	}
	
	
	
	public static String getSentenceForMe(String personId) {
		
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		Person p=resPerson.readEntity(Person.class);
		String username=p.getUsername();
		
		Sentence s = null;
		
		Response res= ServicesLocator.getCentric1Connection().path("sentence/" + username).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(Sentence.class);
			return s.getText();
		}
		else{
			return "An unexpected error occured";
		}
	}
	
	
	
	public static String sendSentence(String fromUserId, String toUser, String sentenceType, String sentenceMotive) {
		
		
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+fromUserId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		Person p=resPerson.readEntity(Person.class);
		String fromUser=p.getUsername();
		
		
		DedicatedSentence s = null;
		
		Response res= ServicesLocator.getCentric2Connection().path("sentence/" + fromUser + "/" + toUser + "/" + sentenceType + "/" + sentenceMotive).request().accept(MediaType.APPLICATION_JSON).post(null);
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(DedicatedSentence.class);
			return "You dedicated '" + s.getSentenceText() + "' to " + toUser;
		}
		else{
			return "An unexpected error occured";
		}
	}
	


	public static String receiveSentences(String personId) {
		
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		Person p=resPerson.readEntity(Person.class);
		String username=p.getUsername();
		
		List<DedicatedSentence> dedicatedSListForUser = null;
		
		Response res= ServicesLocator.getCentric2Connection().path("sentence/" + username).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			
			dedicatedSListForUser=res.readEntity(new GenericType<List<DedicatedSentence>>(){});
			
			String messageToReturn = "";
			for(int i=0;i<dedicatedSListForUser.size();i++) {
				
				DedicatedSentence singleSentence = dedicatedSListForUser.get(i);
				
				messageToReturn += "[" + singleSentence.getInsertionTime() + "] " + "From " + singleSentence.getUsernameOne() + ": " + singleSentence.getSentenceText() + "\n";
				
			}
			
			return messageToReturn;
		}
		else if(res.getStatus()==Response.Status.NO_CONTENT.getStatusCode()) {
			return "No sentences found for you";
		}
		else{
			return "An unexpected error occured";
		}
	}

}
