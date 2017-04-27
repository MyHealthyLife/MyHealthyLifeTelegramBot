package myhealthylife.telegram.bot.handlers;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.centric1.model.Goal;
import myhealthylife.centric1.model.GoalList;
import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class GoalHandler {
	
	/**
	 * Prepare a message which contains the goals of the user
	 * @param personId
	 * @return
	 */
	public static String myGoals(String personId){
		//retrieve the person information
		Response res= ServicesLocator.getCentric1Connection().path("/user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		//check if the account exists
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "Your account doea not exists, register first\n use /register <your MyHealthyLifeUsername>";
		}
		 
		
		Person p=res.readEntity(Person.class);
		
		Response goalResp=ServicesLocator.getCentric1Connection().path("/user/goals/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(goalResp.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during the information retrival";
		}
		
		//retrieve the goals
		List<Goal> goals=goalResp.readEntity(GoalList.class).getGoals();
		
		if(goals.size()==0){
			return "Sorry, no goals sor you :'(";
		}
		
		Iterator<Goal> it=goals.iterator();
		
		String message="";
		
		//formatting the message		
		while(it.hasNext()){
			Goal g=it.next();
			
			message+="*"+g.getGoalName().toUpperCase()+"*\n";
			message+="\tgoal: "+g.getValueToReach()+"\n";
			message+="\tyour value: "+g.getActualValue()+"\n";
			
			if(g.getDifference()==0){
				message+="\t*Good work!!!*";
			}
			else if(g.getDifference()<0){
				message+="\t*loos "+(-1*g.getDifference())+"*";
			}
			else{
				message+="\t*gain "+g.getDifference()+"*";
			}
			
			message+="\n\n";
		}
		
		return message;
	}

}
