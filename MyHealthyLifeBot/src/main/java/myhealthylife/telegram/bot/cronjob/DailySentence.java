package myhealthylife.telegram.bot.cronjob;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.telegram.telegrambots.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.updateshandlers.SentCallback;

import myhealthylife.dataservice.model.People;
import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.MyHealthyLifeBot;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class DailySentence extends TimerTask {
	
	private MyHealthyLifeBot myHealthyLifeBot;
	public static ArrayList<Long> chatIds=new ArrayList<>();
	
	public DailySentence(MyHealthyLifeBot myHealthyLifeBot) {
		super();
		this.myHealthyLifeBot=myHealthyLifeBot;
	}

	@Override
	public void run() {
		
		System.out.println("[TIMER TASK] sending...");
		
		Response resp=ServicesLocator.getCentric1Connection().path("/people").request().accept(MediaType.APPLICATION_JSON).get();
		
		if(resp.getStatus()!=Response.Status.OK.getStatusCode()){
			return;
		}
		
		/*People people=resp.readEntity(People.class);
		
		Iterator<Person> it=people.getPerson().iterator();
		
		while(it.hasNext()){
			Person p=it.next();
			
			SendMessage message= new SendMessage();
			
		}*/
		
		Iterator<Long> it=chatIds.iterator();
		
		while(it.hasNext()){
			Long l=it.next();
			
			SendMessage message=new SendMessage();
			message.setChatId(l);
			message.setText("LOL");
			myHealthyLifeBot.sendMessageResponse(message);
		}
		
	}

}
