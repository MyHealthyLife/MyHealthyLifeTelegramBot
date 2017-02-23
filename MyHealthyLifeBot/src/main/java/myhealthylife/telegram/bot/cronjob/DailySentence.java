package myhealthylife.telegram.bot.cronjob;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.telegram.telegrambots.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.updateshandlers.SentCallback;

import myhealthylife.dataservice.model.People;
import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.MyHealthyLifeBot;
import myhealthylife.telegram.bot.handlers.SentenceHandler;
import myhealthylife.telegram.bot.model.entities.ChatsData;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class DailySentence extends TimerTask {
	
	private MyHealthyLifeBot myHealthyLifeBot;
	
	public DailySentence(MyHealthyLifeBot myHealthyLifeBot) {
		super();
		this.myHealthyLifeBot=myHealthyLifeBot;
	}
	
	public static void registerToDailyNotification(String string,Integer personId){//Check if is already exis
		ChatsData c=new ChatsData();
		c.setChatId(string);
		c.setPersonId(personId);
		
		ChatsData.save(c);
	}

	@Override
	public void run() {
		
		System.out.print("[TIMER TASK] sending...");
		
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
		List<ChatsData> chatsDatas=ChatsData.getAll();
		
		System.out.println(""+chatsDatas.size()+" people");
		
		Iterator<ChatsData> it=chatsDatas.iterator();
		
		while(it.hasNext()){
			ChatsData c=it.next();
			
			Response res=ServicesLocator.getCentric1Connection().path("/user/data/telegram/id/"+c.getPersonId()).request().accept(MediaType.APPLICATION_JSON).get();
			
			if(res.getStatus()!=Response.Status.OK.getStatusCode()){
				//TODO handle error
				SendMessage message=new SendMessage();
				message.setChatId(c.getChatId());
				message.setText("Error during the information retrival");
				myHealthyLifeBot.sendMessageResponse(message);
				
				continue;
			}
			
			Person p=res.readEntity(Person.class);
			String msg=SentenceHandler.getSentenceForMe(p.getTelegramUsername());
			
			SendMessage message=new SendMessage();
			message.setChatId(c.getChatId());
			message.setText(msg);
			myHealthyLifeBot.sendMessageResponse(message);
		}
		
	}

}
