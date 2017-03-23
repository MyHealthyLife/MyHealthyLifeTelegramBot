package myhealthylife.telegram.bot.threads;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

import myhealthylife.telegram.bot.MyHealthyLifeBot;
import myhealthylife.telegram.bot.TokenHandler;
import myhealthylife.telegram.bot.cronjob.DailySentence;
import myhealthylife.telegram.bot.handlers.FoodHandler;
import myhealthylife.telegram.bot.handlers.GoalHandler;
import myhealthylife.telegram.bot.handlers.HealthProfileHandler;
import myhealthylife.telegram.bot.handlers.HelpHaldler;
import myhealthylife.telegram.bot.handlers.RankingHandler;
import myhealthylife.telegram.bot.handlers.SentenceHandler;
import myhealthylife.telegram.bot.handlers.UserDataHandler;

public class UpdateThread implements Runnable{
	
	private Update update;
	private MyHealthyLifeBot myHealthyLifeBot;
	
	public UpdateThread(MyHealthyLifeBot myHealthyLifeBot, Update update){
		this.myHealthyLifeBot=myHealthyLifeBot;
		this.update=update;
	}
	
	
	public void handleUpdate(Update update) {
		System.out.println("update");
		if (update.hasMessage() && update.getMessage().hasText()) {
		        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
		                .setChatId(update.getMessage().getChatId());
		        
		        String tokens[]=update.getMessage().getText().split(" ");
		        System.out.println(update.getMessage().getFrom().getUserName());
		        System.out.println(update.getMessage().getFrom().getId());
		        
		        boolean newSubscription=false;
		        
		        String commandSplits[]=tokens[0].split("@");
		        if(commandSplits.length>1){
		        	/*if the command is sent in a group may be like "/addmeasure@myhealthylife_bot" if the username is not the username of the bot
		        	 * the message is not for the bot*/
		        	if(!commandSplits[1].equals(TokenHandler.username))
		        		return;
		        }
		        
		        switch(commandSplits[0].toLowerCase()){
		        	case"/start": //Stefano
		        		
		        		DailySentence.registerToDailyNotification(myHealthyLifeBot,message.getChatId(), update.getMessage().getFrom().getId());
		        	case "/help": //Stefano
		        		message.setText(HelpHaldler.getHelpMessage());
		        		break;
		        	case "/start_notifications":
		        		DailySentence.registerToDailyNotification(myHealthyLifeBot,message.getChatId(), update.getMessage().getFrom().getId());
		        		newSubscription=true;
		        		break;
		        	case "/register": // Simone (done)
		        		
		        		if(tokens.length>1)
		        			message.setText(UserDataHandler.registerNewUser(update.getMessage().getFrom().getId(), tokens[1]));
		        		else
		        			message.setText("Invalid command,\ntry /register <your HealthyLife username>");
		        		break;
		        	case "/name"://change name Simone (done)
		        		
		        		message.setText(UserDataHandler.updateName(""+update.getMessage().getFrom().getId(), tokens[1]));
		        		break;
		        	case "/surname": //change surname Simone (done)
		        		
		        		message.setText(UserDataHandler.updateSurnameName(""+update.getMessage().getFrom().getId(), tokens[1]));
		        		break;
		        	case "/birthdate": //change birthdate Simone (done)
		        		
		        		message.setText(UserDataHandler.updateBirthdate(""+update.getMessage().getFrom().getId(), tokens[1]));
		        		break;
		        	case "/unregister": // Simone (done)
		        		
		        		try{
			        		if(tokens[1].equals("confirm")) {
			        			message.setText(UserDataHandler.deleteUserInformation(""+update.getMessage().getFrom().getId(), tokens[1]));
			        		}
			        		else {
			        			message.setText("If you really want to unregister please write /unregister confirm");
			        		}
		        		} catch(ArrayIndexOutOfBoundsException ex) {
		        			message.setText("If you really want to unregister please write /unregister confirm");
		        		}
		        		break;
		        	case "/healthstate": //Stefano (done)
		        		
		        		message.setText(HealthProfileHandler.getCurrentHealth(""+update.getMessage().getFrom().getId()));
		        		break;
		        	case "/measure_history": //Stefano (done)
		        		message.setText(HealthProfileHandler.getHealthHistory(""+update.getMessage().getFrom().getId()));
		        		break;
		        	case "/addmeasure": //addmeasure weight 80 //Stefano (done)
		        		if(tokens.length==3)
		        			message.setText(HealthProfileHandler.addMeasure(""+update.getMessage().getFrom().getId(), tokens[1], tokens[2]));
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

		        		message.setText(SentenceHandler.getSentenceForMe(""+update.getMessage().getFrom().getId()));
		        		break;
		        	case "/foodsforme": // <max-cal>  extra maxCal service
		        		message.setText(FoodHandler.foodForMe(""+update.getMessage().getFrom().getId()));
		        		break;
		        	//service 02
		        	case "/goal": //my goals
		        		message.setText(GoalHandler.myGoals(""+update.getMessage().getFrom().getId()));
		        		message.enableMarkdown(true);
		        		break;
		        	case "/ranking": // Simone (done)
		        		
		        		message.setText(RankingHandler.getUserRank(""+update.getMessage().getFrom().getId()));
		        		break;
		        	case "/send": //<user> <sentence> Simone (done)
		        		
		        		if(tokens.length==4)
		        			message.setText(SentenceHandler.sendSentence((""+update.getMessage().getFrom().getId()), tokens[1], tokens[2], tokens[3]));
		        		else
		        			message.setText("use /send <user> <sentence type> <sentence motive>");
		        		break;
		        	case "/receive": // Simone (done)
		        		
		        		if(tokens.length==1) {
		        			message.setText(SentenceHandler.receiveSentences(""+update.getMessage().getFrom().getId()));
		        		}
		        		break;
		        	case "/recipe": // Simone (done)

	        			String recipeName = "";
		        		if(tokens.length>=2) {
		        			for(int i=1;i<tokens.length;i++) {
		        				if(i!=1) {
		        					recipeName += " ";
		        				}
		        				recipeName += tokens[i];
		        			}
		        			System.out.println("[" + recipeName + "]");
		        			message.setText(FoodHandler.getRecipeDetails(""+update.getMessage().getFrom().getId(), recipeName));
		        		}
		        		break;
		        	case "/recipesforme": // Simone (done)

	        			if(tokens.length==1) {
		        			message.setText(FoodHandler.getSuggestedRecipes(""+update.getMessage().getFrom().getId()));
		        		}
		        		break;
		        	case "/new_recipe": //<max_cal> //Stefano
		        		break;
		        	case "/update_recipe": //Stefano
		        		break;
		        	case "/newFood"://Stefano
		        		break;
		        	case "/newGoal":
		        		break;
		        	case "/unsubscribe_notification":
		        		DailySentence.unsubscribe(myHealthyLifeBot,message.getChatId(), update.getMessage().getFrom().getId());
		        		message.setText("unsubscribed for daily notification");
		        		break;
		        	default:
		        		message.setText(HelpHaldler.getCommandNotFound());
		        		break;
		        		
		        }
		        
		        if(!newSubscription){
		        	if(update.getMessage().isGroupMessage()){
		        		String text=message.getText();
		        		message.setText("@"+update.getMessage().getFrom().getUserName().toString()+"\n"+text);
		        	}
		        	myHealthyLifeBot.sendMessageResponse(message);
		        }
		        
		    }
	}
	
	@Override
	public void run() {
		
		handleUpdate(update);
		
	}
	
	

}
