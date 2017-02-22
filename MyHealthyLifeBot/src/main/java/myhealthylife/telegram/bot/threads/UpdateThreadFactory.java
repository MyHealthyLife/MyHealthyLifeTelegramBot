package myhealthylife.telegram.bot.threads;

import java.util.concurrent.ThreadFactory;

public class UpdateThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		
		Thread th=new Thread(r,"a");
		
		return th;
	}

}
