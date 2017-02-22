package myhealthylife.telegram.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
	public static void main(String[] args) {

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        MyHealthyLifeBot myHealthyLifeBot=new MyHealthyLifeBot();
        myHealthyLifeBot.inizializeExecutor();
        
        try {
            botsApi.registerBot(myHealthyLifeBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
