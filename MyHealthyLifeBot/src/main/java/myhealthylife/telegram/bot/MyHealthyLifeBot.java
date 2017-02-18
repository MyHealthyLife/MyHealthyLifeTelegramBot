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
		        System.out.println(update.getMessage().getFrom().getUserName());
		        System.out.println(update.getMessage().getFrom().getId());
		        
		        String commandSplits[]=tokens[0].split("@");
		        if(commandSplits.length>1){
		        	/*if the command is sent in a group may be like "/addmeasure@myhealthylife_bot" if the username is not the username of the bot
		        	 * the message is not for the bot*/
		        	if(!commandSplits[1].equals(TokenHandler.username))
		        		return;
		        }
		        switch(commandSplits[0]){
		        	case"/start": //Stefano
		        	case "/help": //Stefano
		        		message.setText(HelpHaldler.getHelpMessage());
		        		break;
		        	case "/register": // Simone (done)
		        		
		        		message.setText(UserDataHandler.registerNewUser(update.getMessage().getFrom().getUserName(), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]));
		        		break;
		        	case "/name"://change name Simone (done)
		        		
		        		message.setText(UserDataHandler.updateName(update.getMessage().getFrom().getUserName(), tokens[1]));
		        		break;
		        	case "/surname": //change surname Simone (done)
		        		
		        		message.setText(UserDataHandler.updateSurnameName(update.getMessage().getFrom().getUserName(), tokens[1]));
		        		break;
		        	case "/birthdate": //change birthdate Simone (done)
		        		
		        		message.setText(UserDataHandler.updateBirthdate(update.getMessage().getFrom().getUserName(), tokens[1]));
		        		break;
		        	case "/unregister": // Simone (done)
		        		
		        		try{
			        		if(tokens[1].equals("confirm")) {
			        			message.setText(UserDataHandler.deleteUserInformation(update.getMessage().getChat().getUserName(), tokens[1]));
			        		}
			        		else {
			        			message.setText("If you really want to unregister please write /unregister confirm");
			        		}
		        		} catch(ArrayIndexOutOfBoundsException ex) {
		        			message.setText("If you really want to unregister please write /unregister confirm");
		        		}
		        		break;
		        	case "/healthstate": //Stefano (done)
		        		
		        		message.setText(HealthProfileHandler.getCurrentHealth(update.getMessage().getFrom().getUserName()));
		        		break;
		        	case "/measureHistory": //Stefano (done)
		        		message.setText(HealthProfileHandler.getHealthHistory(update.getMessage().getFrom().getUserName()));
		        		break;
		        	case "/addmeasure": //addmeasure weight 80 //Stefano (done)
		        		if(tokens.length==3)
		        			message.setText(HealthProfileHandler.addMeasure(update.getMessage().getFrom().getUserName(), tokens[1], tokens[2]));
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

		        		message.setText(SentenceHandler.getSentenceForMe(update.getMessage().getFrom().getUserName()));
		        		break;
		        	case "/foodsForMe": // <max-cal>  extra maxCal service
		        		break;
		        	//service 02
		        	case "/goal": //my goals
		        		break;
		        	case "/ranking": // Simone (done)
		        		
		        		message.setText(RankingHandler.getUserRank(update.getMessage().getFrom().getUserName()));
		        		break;
		        	case "/send": //<user> <sentence> Simone (done)
		        		
		        		if(tokens.length==3) {
		        			message.setText(SentenceHandler.sendSentence((update.getMessage().getFrom().getUserName()), tokens[1], tokens[2]));
		        		}
		        		break;
		        	case "/receive": // Simone (done)
		        		
		        		if(tokens.length==1) {
		        			message.setText(SentenceHandler.receiveSentences(update.getMessage().getFrom().getUserName()));
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
