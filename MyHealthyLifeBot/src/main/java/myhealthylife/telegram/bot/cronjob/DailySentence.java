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
	
	/**
	 * register to notification service by saving the chat informations
	 * @param myHealthyLifeBot
	 * @param chatId
	 * @param personId
	 */
	public static void registerToDailyNotification(MyHealthyLifeBot myHealthyLifeBot,String chatId,Integer personId){
		
		//chec if the person is already susbcribed in this chat
		if(ChatsData.getByChatIDandPersonID(chatId, personId).size()!=0)
		{
			String msg="Already subscribed";
	    	SendMessage mesg=new SendMessage();
	    	mesg.setChatId(chatId);
	    	mesg.setText(msg);
	    	myHealthyLifeBot.sendMessageResponse(mesg);
	    	return;
		}
		
		ChatsData c=new ChatsData();
		c.setChatId(chatId);
		c.setPersonId(personId);
		
		ChatsData.save(c); //save the information
		
		String msg="Subscription to daily message activated! type /unsubscribe_notification to disable it";
    	SendMessage mesg=new SendMessage();
    	mesg.setChatId(chatId);
    	mesg.setText(msg);
    	myHealthyLifeBot.sendMessageResponse(mesg);
	}
	
	
	/**
	 * unsubscribe from notification service
	 * 
	 * @param myHealthyLifeBot
	 * @param chatId
	 * @param personId
	 */
	public static void unsubscribe(MyHealthyLifeBot myHealthyLifeBot,String chatId,Integer personId){
		List<ChatsData> list=ChatsData.getByChatIDandPersonID(chatId, personId);
		if(list.size()==0){
			return;
		}
		ChatsData c=list.get(0);
		
		ChatsData.remove(c.getId());
		
	}

	@Override
	public void run() {
		
		System.out.print("[TIMER TASK] sending...");
		
		List<ChatsData> chatsDatas=ChatsData.getAll();
		
		System.out.println(""+chatsDatas.size()+" people");
		
		Iterator<ChatsData> it=chatsDatas.iterator();
		
		while(it.hasNext()){
			ChatsData c=it.next();
			
			//retrieve the person by the telegram id
			Response res=ServicesLocator.getCentric1Connection().path("/user/data/telegram/id/"+c.getPersonId()).request().accept(MediaType.APPLICATION_JSON).get();
			
			//handling errors
			if(res.getStatus()!=Response.Status.OK.getStatusCode()){
				
				SendMessage message=new SendMessage();
				message.setChatId(c.getChatId());
				message.setText("Error during the information retrival");
				myHealthyLifeBot.sendMessageResponse(message);
				
				continue;
			}
			
			//retrive the sentence
			Person p=res.readEntity(Person.class);
			String msg="@"+p.getTelegramUsername()+" "+SentenceHandler.getSentenceForMe(""+c.getPersonId());
			
			SendMessage message=new SendMessage();
			message.setChatId(c.getChatId());
			message.setText(msg);
			myHealthyLifeBot.sendMessageResponse(message);
		}
		
	}

}
