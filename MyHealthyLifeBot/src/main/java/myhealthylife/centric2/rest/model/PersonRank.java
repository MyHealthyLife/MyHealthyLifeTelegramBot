package myhealthylife.centric2.rest.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="personRank")
public class PersonRank {


    private long idPerson;
    private String username;
	private String firstname;
    private String lastname;
    private String sex;
    private Double weight;
    private Double steps;
    private Double points;
    private Boolean telegramUsernameAvailable;
    private String telegramUsername;
    private Boolean telegramUsernameVisible;
    
    
	public long getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getSteps() {
		return steps;
	}
	public void setSteps(Double steps) {
		this.steps = steps;
	}
	public Double getPoints() {
		return points;
	}
	public void setPoints(Double points) {
		this.points = points;
	}
	public Boolean getTelegramUsernameAvailable() {
		return telegramUsernameAvailable;
	}
	public void setTelegramUsernameAvailable(Boolean telegramUsernameAvailable) {
		this.telegramUsernameAvailable = telegramUsernameAvailable;
	}
	public String getTelegramUsername() {
		return telegramUsername;
	}
	public void setTelegramUsername(String telegramUsername) {
		this.telegramUsername = telegramUsername;
	}
	public Boolean getTelegramUsernameVisible() {
		return telegramUsernameVisible;
	}
	public void setTelegramUsernameVisible(Boolean telegramUsernameVisible) {
		this.telegramUsernameVisible = telegramUsernameVisible;
	}
	
}
