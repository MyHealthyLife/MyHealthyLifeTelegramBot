package myhealthylife.telegram.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import myhealthylife.telegram.bot.handlers.HealthProfileHandler;
import myhealthylife.telegram.bot.handlers.HelpHaldler;
import myhealthylife.telegram.bot.handlers.RankingHandler;
import myhealthylife.telegram.bot.handlers.SentenceHandler;
import myhealthylife.telegram.bot.handlers.UserDataHandler;

public class MyHealthyLifeBot extends TelegramLongPollingBot{

	public void onUpdateReceived(Update update) {
		 if (update.hasMessage() && update.getMessage().hasText()) {
		        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
		                .setChatId(update.getMessage().getChatId());
		        
		        String tokens[]=update.getMessage().getText().split(" ");
		        
		        switch(tokens[0]){
		        	case"/start": //Stefano
		        	case "/help": //Stefano
		        		message.setText(HelpHaldler.getHelpMessage());
		        		break;
		        	case "/register": // Simone (done)
		        		
		        		message.setText(UserDataHandler.registerNewUser(update.getMessage().getChat().getUserName(), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]));
		        		break;
		        	case "/name"://change name Simone (done)
		        		
		        		message.setText(UserDataHandler.updateName(update.getMessage().getChat().getUserName(), tokens[1]));
		        		break;
		        	case "/surname": //change surname Simone (done)
		        		
		        		message.setText(UserDataHandler.updateName(update.getMessage().getChat().getUserName(), tokens[1]));
		        		break;
		        	case "/birthdate":
		        		break;
		        	case "/unregister":
		        		break;
		        	case "/healthstate": //Stefano (done)
		        		
		        		message.setText(HealthProfileHandler.getCurrentHealth(update.getMessage().getChat().getUserName()));
		        		break;
		        	case "/measureHistory": //Stefano (done)
		        		message.setText(HealthProfileHandler.getHealthHistory(update.getMessage().getChat().getUserName()));
		        		break;
		        	case "/addmeasure": //addmeasure weight 80 //Stefano (done)
		        		if(tokens.length==3)
		        			message.setText(HealthProfileHandler.addMeasure(update.getMessage().getChat().getUserName(), tokens[1], tokens[2]));
		        		else
		        			message.setText("use /addmeasure <type> <value>");
		        		break;
		        	case "/measuretypes"://Stefano(done)
		        		message.setText(HealthProfileHandler.getMeasureTypes());
		        		break;
		        	case "/randomsentence": // Simone (done)
		        		
		        		message.setText(SentenceHandler.getRandomSentence());
		        		break;
		        	case "/sentenceforme": // Simone (done)

		        		message.setText(SentenceHandler.getSentenceForMe(update.getMessage().getChat().getUserName()));
		        		break;
		        	case "/foodsForMe": // <max-cal>  extra maxCal service
		        		break;
		        	//service 02
		        	case "/goal": //my goals
		        		break;
		        	case "/ranking": // Simone (done but add support for map obj)
		        		
		        		message.setText(RankingHandler.getUserRank(update.getMessage().getChat().getUserName()));
		        		break;
		        	case "/send": //<user> <sentence> Simone (done)
		        		
		        		if(tokens.length==3) {
		        			message.setText(SentenceHandler.sendSentence((update.getMessage().getChat().getUserName()), tokens[1], tokens[2]));
		        		}
		        		break;
		        	case "/receive": // Simone
		        		
		        		if(tokens.length==1) {
		        			message.setText(SentenceHandler.receiveSentences(update.getMessage().getChat().getUserName()));
		        		}
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
