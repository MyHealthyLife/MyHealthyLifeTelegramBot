package myhealthylife.dataservice.model.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import myhealthylife.dataservice.model.entities.Person;



public class Utilities {
	
	private static DateFormat format=new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * get a XMLGregorianCalendar from a string formatted in the following way: "1965-01-05"
	 * @param date
	 * @return
	 */
	public static Date getDateFromString(String date){
		try {
        	return  format.parse(date);
        } catch (ParseException e) {
        	return null;
        }
	}
	
	/**
	 * get a XMLGregorianCalendar from a a time in milliseconds
	 * @param time
	 * @return
	 */
	public static Date getDate(long time){
		return new Date(time);
	}
	
	/**
	 * get current date in a XMLGregorianCalendar object
	 * @return
	 */
	public static Date getCurrentDate(){
		return getDate(System.currentTimeMillis());
	}
}
