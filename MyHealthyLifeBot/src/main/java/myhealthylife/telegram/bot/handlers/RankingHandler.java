package myhealthylife.telegram.bot.handlers;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.utils.ServicesLocator;
import myhealtylife.optimalparamters.model.Rank;

public class RankingHandler {

	
public static String getUserRank(String personId) {
		Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resPerson.getStatus()!=Response.Status.OK.getStatusCode()){
			System.out.println(resPerson.getStatus());
			return "Information not available ";
		}
		Person p=resPerson.readEntity(Person.class);
		String username=p.getUsername();
		System.out.println("Your user: " + username);
		Response res= ServicesLocator.getCentric2Connection().path("ranking/bot/" + username).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()==Response.Status.OK.getStatusCode()) {
			
			Rank rankObj = res.readEntity(Rank.class);
			
			if(rankObj!=null) {
				
				String stringRanking = "";
				for(int i=0;i<rankObj.getCompactRanking().size();i++) {
					
					stringRanking += rankObj.getCompactRanking().get(i) + "\n";
					
				}
				
				return stringRanking;
				
			}
			else {
				return "Ranking empty";
			}
		}
		else{
			return "An unexpected error occured";
		}
	}
}
