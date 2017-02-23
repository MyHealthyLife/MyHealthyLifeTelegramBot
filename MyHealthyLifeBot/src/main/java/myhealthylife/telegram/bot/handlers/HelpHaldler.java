package myhealthylife.telegram.bot.handlers;

public class HelpHaldler {
	public static String getHelpMessage(){
		String message="/help: visualize this message\n";
		
		message+="/register <name> <surname> <birthdate>: register to the service\n";
		message+="/name\n";
		message+="/surname\n";
		message+="/birthdate\n";
		message+="/unregister\n";
		message+="/healthstate visualize your current health state\n";
		message+="/measure_history visualize the history of you measures\n";
		message+="/addmeasure <type> <value> save a new measure\n";
		message+="/randomsentence \n";
		message+="/sentenceforme \n";
		message+="/foodsForMe\n";
		message+="/goal\n";
		message+="/ranking\n";
		message+="/send\n";
		message+="/receive\n";
		message+="/new_recipe\n";
		message+="/update_recipe\n";
		message+="/newFood\n";
		message+="/newGoal\n";
		message+="/start_notifications\n";
		message+="/unsubscribe_notification\n";
		
		return message;
	}
	
	public static String getCommandNotFound(){
		return "type /help for the list of available commands";
	}
}
