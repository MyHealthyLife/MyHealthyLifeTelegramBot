package myhealthylife.telegram.bot.handlers;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.telegram.bot.utils.ServicesLocator;

public class RankingHandler {

	
public static String getUserRank(String username) {
		
	
		Response res= ServicesLocator.getCentric2Connection().path("ranking/pbitta1").request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			Map<String, Double> usersAndPointsSorted = res.readEntity(Map.class);
			return usersAndPointsSorted.toString();
		}
		else{
			return "An unexpected error occured";
		}
	}
}
