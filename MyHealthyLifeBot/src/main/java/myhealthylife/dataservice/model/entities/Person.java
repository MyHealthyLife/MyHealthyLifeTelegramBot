package myhealthylife.dataservice.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private long idPerson;
	
	private String firstname;
	
	private String lastname;
	
	private String sex;
	
	private String birthdate;
	
	private String username;
	
	private String password;
	
	private String telegramUsername;
	
	private HealthProfile healthProfile;
	
	private String telegramID;
	
	private Boolean usernameVisible;
	
	private String country;

	private String city;

	public long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelegramUsername() {
		return telegramUsername;
	}

	public void setTelegramUsername(String telegramUsername) {
		this.telegramUsername = telegramUsername;
	}

	public HealthProfile getHealthProfile() {
		return healthProfile;
	}

	public void setHealthProfile(HealthProfile healthProfile) {
		this.healthProfile = healthProfile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelegramID() {
		return telegramID;
	}

	public void setTelegramID(String telegramID) {
		this.telegramID = telegramID;
	}
	
	public Boolean getUsernameVisible() {
		return usernameVisible;
	}

	public void setUsernameVisible(Boolean usernameVisible) {
		this.usernameVisible = usernameVisible;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
