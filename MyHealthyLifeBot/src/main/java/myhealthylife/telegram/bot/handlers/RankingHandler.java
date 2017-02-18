package myhealthylife.telegram.bot.handlers;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.telegram.bot.utils.ServicesLocator;
import myhealtylife.optimalparamters.model.Rank;

public class RankingHandler {

	
public static String getUserRank(String username) {
		
		Response res= ServicesLocator.getCentric2Connection().path("ranking/" + username).request().accept(MediaType.APPLICATION_JSON).get();
		
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
