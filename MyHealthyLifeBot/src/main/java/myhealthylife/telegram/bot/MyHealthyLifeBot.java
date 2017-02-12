package myhealthylife.telegram.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import myhealthylife.telegram.bot.handlers.HealthProfileHandler;
import myhealthylife.telegram.bot.handlers.HelpHaldler;
import myhealthylife.telegram.bot.handlers.SentenceHandler;

public class MyHealthyLifeBot extends TelegramLongPollingBot{

	public void onUpdateReceived(Update update) {
		 if (update.hasMessage() && update.getMessage().hasText()) {
		        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
		                .setChatId(update.getMessage().getChatId());
		        
		        String tockens[]=update.getMessage().getText().split(" ");
		        
		        switch(tockens[0]){
		        	case"/start": //Stefano
		        	case "/help": //Stefano
		        		message.setText(HelpHaldler.getHelpMessage());
		        		break;
		        	case "/register": //tocken[1] Name Surname Sex BirthDate;
		        		
		        		break;
		        	case "/name"://change name
		        		break;
		        	case "/surname": //change surname
		        		break;
		        	case "/birthdate":
		        		break;
		        	case "/unregister":
		        		break;
		        	case "/healthstate": //Stefano
		        		
		        		message.setText(HealthProfileHandler.getCurrentHealth(update.getMessage().getChat().getUserName()));
		        		break;
		        	case "/measureHistory": //Stefano
		        		break;
		        	case "/addmeasure": //addmeasure weight 80 //Stefano
		        		break;
		        	case "/measuretypes"://Stefano
		        		break;
		        	case "/randomsentence":
		        		
		        		message.setText(SentenceHandler.getRandomSentence());
		        		break;
		        	case "/sentenceForMe":
		        		break;
		        	case "/foodsForMe": // <max-cal>  extra maxCal service
		        		break;
		        	//service 02
		        	case "/goal": //my goals
		        		break;
		        	case "/ranking":
		        		break;
		        	case "/send": //<user> <sentence>
		        		break;
		        	case "/receive": //Stefano
		        		break;
		        	case "/newRecipe": //<max_cal> //Stefano
		        		break;
		        	case "/updateRecipe": //Stefano
		        		break;
		        	case "/newFood"://Stefano
		        		break;
		        	case "/newGoal":
		        		break;
		        	default:
		        		message.setText(HelpHaldler.getCommandNotFound());
		        		break;
		        		
		        }
		        
		        try {
		        	System.out.println(message);
		            sendMessage(message); // Call method to send the message
		        } catch (TelegramApiException e) {
		            e.printStackTrace();
		        }
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
