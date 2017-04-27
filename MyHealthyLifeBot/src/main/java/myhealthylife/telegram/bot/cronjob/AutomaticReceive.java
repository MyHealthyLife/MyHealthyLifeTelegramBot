package myhealthylife.telegram.bot.cronjob;

import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.telegram.telegrambots.api.methods.send.SendMessage;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.MyHealthyLifeBot;
import myhealthylife.telegram.bot.handlers.SentenceHandler;
import myhealthylife.telegram.bot.model.entities.ChatsData;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class AutomaticReceive extends TimerTask{

private MyHealthyLifeBot myHealthyLifeBot;
	
	public AutomaticReceive(MyHealthyLifeBot myHealthyLifeBot) {
		super();
		this.myHealthyLifeBot=myHealthyLifeBot;
	}
	
	@Override
	public void run() {
		
		List<ChatsData> chatsData=ChatsData.getAll();
		System.out.println("[AUTOMATIC RECEIVE]... "+chatsData.size()+" person");
		
		Iterator<ChatsData> it=chatsData.iterator(); //retrieve chats informations from the database
		
		while(it.hasNext()){
			ChatsData c=it.next();
			
			/*retrieve the senteces based on person id*/
			String msg=SentenceHandler.receiveSentences(""+c.getPersonId());
			
			//retrieve the person information from telegramid
			Response resPerson= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+c.getPersonId()).request().accept(MediaType.APPLICATION_JSON).get();
			
			String username="";
			
			if(resPerson.getStatus()==Response.Status.OK.getStatusCode()){
				Person p=resPerson.readEntity(Person.class);
				username="@"+p.getUsername()+"\n";
			}
			
			
			SendMessage message=new SendMessage();
			message.setChatId(c.getChatId());
			message.setText(username+msg);
			myHealthyLifeBot.sendMessageResponse(message);
			
			
		}
	}

}
