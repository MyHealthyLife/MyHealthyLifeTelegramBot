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
	
	
	/**
	 * Gets all the sentences present in the database
	 * @param username
	 * @return
	 */
	public static String getAllSentences(String username) {
		
		Sentence s = null;
		
		// Gets all the sentences
		Response res= ServicesLocator.getCentric1Connection().path("sentence").request().accept(MediaType.APPLICATION_JSON).get();
		
		// Checks the response code and prints the text
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(Sentence.class);
			return s.getText();
		}
		else{
			return "An unexpected error occured";
		}
	}
	
	
	/**
	 * Gets a random sentence from the whole set available
	 * @return
	 */
	public static String getRandomSentence() {
		
		Sentence s = null;
		
		// Gets a random sentence
		Response res= ServicesLocator.getCentric1Connection().path("sentence/random").request().accept(MediaType.APPLICATION_JSON).get();
		
		// Checks the response code and prints the text
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(Sentence.class);
			return s.getText();
		}
		else{
			return "An unexpected error occured";
		}
	}
	
	
	/**
	 * Gets a suggested sentence for the user
	 * @param personId
	 * @return
	 */
	public static String getSentenceForMe(String personId) {
		
		// Gets the details of a person
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		Person p=resPerson.readEntity(Person.class);
		String username=p.getUsername();
		
		Sentence s = null;
		
		// Gets the suggested sentence for the user
		Response res= ServicesLocator.getCentric1Connection().path("sentence/" + username).request().accept(MediaType.APPLICATION_JSON).get();
		
		// Checks the response code and prints the text
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(Sentence.class);
			return s.getText();
		}
		else{
			return "An unexpected error occured";
		}
	}
	
	
	/**
	 * Dedicates a sentence to another user
	 * @param fromUserId The identifier of the sender
	 * @param toUser The username of the user that recieves the sentence
	 * @param sentenceType The sentence type that must have the dedicated sentence
	 * @param sentenceMotive The sentence trend that must have the dedicated sentence
	 * @return
	 */
	public static String sendSentence(String fromUserId, String toUser, String sentenceType, String sentenceMotive) {
		
		// Gets the details of the person
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+fromUserId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		Person p=resPerson.readEntity(Person.class);
		String fromUser=p.getUsername();
		
		
		DedicatedSentence s = null;
		
		// Sends a request to dedicate a sentence
		Response res= ServicesLocator.getCentric2Connection().path("sentence/" + fromUser + "/" + toUser + "/" + sentenceType + "/" + sentenceMotive).request().accept(MediaType.APPLICATION_JSON).post(null);
		
		// Checks the response code
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			s=res.readEntity(DedicatedSentence.class);
			
			// Prints a log in the messages
			return "You dedicated '" + s.getSentenceText() + "' to " + toUser;
		}
		else{
			return "An unexpected error occured";
		}
	}
	

	/**
	 * Gets all the sentences other users dedicated to you
	 * @param personId
	 * @return
	 */
	public static String receiveSentences(String personId) {
		
		// Gets all the details of the person
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		Person p=resPerson.readEntity(Person.class);
		String username=p.getUsername();
		
		List<DedicatedSentence> dedicatedSListForUser = null;
		
		// Gets all the dedicated sentences for the current user
		Response res= ServicesLocator.getCentric2Connection().path("sentence/" + username).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		
		// Checks the response code
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			
			dedicatedSListForUser=res.readEntity(new GenericType<List<DedicatedSentence>>(){});
			
			// Composes the message with all the sentences in the list
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
