package myhealthylife.telegram.bot.handlers;

public class HelpHaldler {
	public static String getHelpMessage(){
		String message="/help: visualize this message\n";
		
		message+="/register <name> <surname> <birthdate>: register to the service\n";
		message+="/name <new name> updates your name\n";
		message+="/surname <new surname> updates your surname\n";
		message+="/birthdate <YYYY-MM-DD> updates your birthdate\n";
		message+="/unregister Deletes your user and all your data in the system\n";
		message+="/healthstate visualize your current health state\n";
		message+="/measure_history visualize the history of you measures\n";
		message+="/addmeasure <type> <value> save a new measure\n";
		message+="/randomsentence Get a random sentence to motivate the user\n";
		message+="/sentenceforme Get a specific sentence based on your measures\n";
		message+="/foodsforme Gets specific type of foods based on your health state\n";
		message+="/goal Gets the goals you should reach\n";
		message+="/ranking Gets a compact ranking with the neareast users around your position\n";
		message+="/send <destination user> <type> <trend (gain or loss)> Sends a sentence to a destination user\n";
		message+="/receive Receive all the sentences the other users dedicated to you within 7 days\n";
		message+="/recipe <recipe name> Shows the details of an existing recipe\n";
		message+="/recipesforme Gets specific recipes based on your measures\n";
		message+="/new_recipe\n";
		message+="/update_recipe\n";
		message+="/newFood\n";
		message+="/newGoal\n";
		message+="/start_notifications Starts the push notification service for your user\n";
		message+="/unsubscribe_notification Stops the push notification service for your user\n";
		
		return message;
	}
	
	public static String getCommandNotFound(){
		return "type /help for the list of available commands";
	}
}
