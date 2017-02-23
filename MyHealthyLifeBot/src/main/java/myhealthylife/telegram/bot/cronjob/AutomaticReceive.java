package myhealthylife.telegram.bot.cronjob;

import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import org.telegram.telegrambots.api.methods.send.SendMessage;

import myhealthylife.telegram.bot.MyHealthyLifeBot;
import myhealthylife.telegram.bot.handlers.SentenceHandler;
import myhealthylife.telegram.bot.model.entities.ChatsData;

public class AutomaticReceive extends TimerTask{

private MyHealthyLifeBot myHealthyLifeBot;
	
	public AutomaticReceive(MyHealthyLifeBot myHealthyLifeBot) {
		super();
		this.myHealthyLifeBot=myHealthyLifeBot;
	}
	
	@Override
	public void run() {//TODO works only for person with active notification
		
		List<ChatsData> chatsData=ChatsData.getAll();
		System.out.println("[AUTOMATIC RECEIVE]... "+chatsData.size()+" person");
		
		Iterator<ChatsData> it=chatsData.iterator();
		
		while(it.hasNext()){
			ChatsData c=it.next();
			
			String msg=SentenceHandler.receiveSentences(""+c.getPersonId());
			
			SendMessage message=new SendMessage();
			message.setChatId(c.getChatId());
			message.setText(msg);
			myHealthyLifeBot.sendMessageResponse(message);
			
			
		}
	}

}
