package myhealthylife.telegram.bot.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.sentencegenerator.model.entities.Sentence;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class SentenceHandler {
	
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
	
	
	
	public static String getSentenceForMe(String username) {
		
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

}
