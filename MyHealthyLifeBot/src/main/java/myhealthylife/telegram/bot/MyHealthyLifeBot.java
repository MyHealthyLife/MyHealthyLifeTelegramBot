package myhealthylife.telegram.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyHealthyLifeBot extends TelegramLongPollingBot{

	public void onUpdateReceived(Update update) {
		 if (update.hasMessage() && update.getMessage().hasText()) {
		        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
		                .setChatId(update.getMessage().getChatId())
		                .setText(update.getMessage().getText());
		        try {
		        	System.out.println(message);
		            sendMessage(message); // Call method to send the message
		        } catch (TelegramApiException e) {
		            e.printStackTrace();
		        }
		    }
		
	}

	public String getBotUsername() {
		return TockenHandler.username;
	}

	@Override
	public String getBotToken() {
		return TockenHandler.tocken;
	}

}
