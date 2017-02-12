package myhealthylife.telegram.bot.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;

public class ServicesLocator {

	public static WebTarget getCentric1Connection(){
		ClientConfig clientConfig=new ClientConfig();
		Client client=ClientBuilder.newClient(clientConfig);
		return client.target("https://centric01-main.herokuapp.com");
	}
	
	public static WebTarget getCentric2Connection(){
		ClientConfig clientConfig=new ClientConfig();
		Client client=ClientBuilder.newClient(clientConfig);
		return client.target("https://centric02-social.herokuapp.com");
	}
}
