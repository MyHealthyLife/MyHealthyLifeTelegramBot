package myhealthylife.telegram.bot;

import java.util.Timer;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import myhealthylife.telegram.bot.cronjob.DailySentence;

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
        
        //inizialize timer
        
        Timer t=new Timer();
        DailySentence ds=new DailySentence(myHealthyLifeBot);
        
        t.scheduleAtFixedRate(ds, 0, 6*1000*60*60);
    }
}
