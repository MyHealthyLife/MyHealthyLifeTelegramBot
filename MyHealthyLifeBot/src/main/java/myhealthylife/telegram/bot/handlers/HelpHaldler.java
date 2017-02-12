package myhealthylife.telegram.bot.handlers;

public class HelpHaldler {
	public static String getHelpMessage(){
		String message="/help: visualize this message\n";
		
		message+="/register <name> <surname> <birthdate>: register to the service";
		
		return message;
	}
	
	public static String getCommandNotFaud(){
		return "type /help for the list of available commands";
	}
}
