package myhealthylife.telegram.bot.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.dataservice.model.generated.weather.Current;
import myhealthylife.telegram.bot.utils.ServicesLocator;

public class WeatherHandler {

	public static String getWeather(String personId){
		Person p= UserDataHandler.getPerson(personId);
		
		if(p==null)
			return "Register first!";
		
		if(p.getCity()==null || p.getCountry()==null)
			return "set you city and country in your profile in order to get the weather information";
		
		Response res=ServicesLocator.getCentric1Connection().path("/weather/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode())
			return "An error occurs";
		
		Current c=res.readEntity(Current.class);
		
		return "Weather in *"+p.getCity()+"* -"+p.getCountry()+":\n"+
				"*"+c.getWeather().getValue()+"* - temperature: "+c.getTemperature().getValue()+"°C\n"+
				"\t*humidity*: "+c.getHumidity().getValue()+" "+c.getHumidity().getUnit()+"\n"
				+"\t*pressure*: "+c.getPressure().getValue()+" "+c.getPressure().getUnit();
	}
}
