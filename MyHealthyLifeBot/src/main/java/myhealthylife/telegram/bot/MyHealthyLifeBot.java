package myhealthylife.telegram.bot;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import myhealthylife.telegram.bot.handlers.HealthProfileHandler;
import myhealthylife.telegram.bot.handlers.HelpHaldler;
import myhealthylife.telegram.bot.handlers.RankingHandler;
import myhealthylife.telegram.bot.handlers.SentenceHandler;
import myhealthylife.telegram.bot.handlers.UserDataHandler;
import myhealthylife.telegram.bot.threads.UpdateThread;
import myhealthylife.telegram.bot.threads.UpdateThreadFactory;

public class MyHealthyLifeBot extends TelegramLongPollingBot{
	private ThreadPoolExecutor executor;

	public void onUpdateReceived(Update update) {
		/*giving the update to the thread pool*/
		 executor.execute(new UpdateThread(this, update));
		 System.out.println(executor.getPoolSize());
		
	}
	
	/*create a threadpool of 10 threads*/
	public void inizializeExecutor(){
		executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		System.out.println(executor.getPoolSize());
	}

	

	public void sendMessageResponse(SendMessage message) {
		try {
			System.out.println(message);
		    sendMessage(message); // Call method to send the message
		} catch (TelegramApiException e) {
		    e.printStackTrace();
		}
	}

	public String getBotUsername() {
		return TokenHandler.username;
	}

	@Override
	public String getBotToken() {
		return TokenHandler.tocken;
	}

}
