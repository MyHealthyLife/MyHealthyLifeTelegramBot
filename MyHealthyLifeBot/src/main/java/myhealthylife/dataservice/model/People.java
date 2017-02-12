package myhealthylife.dataservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import myhealthylife.dataservice.model.entities.Person;

@XmlRootElement(name="people")
public class People {
	
	private List<Person> person;

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

}
