package myhealthylife.dataservice.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import myhealthylife.dataservice.model.CurrentHealth;
import myhealthylife.dataservice.model.MeasureTypes;
import myhealthylife.dataservice.model.util.Utilities;


@XmlRootElement(name="healthProfile")
public class HealthProfile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@XmlTransient
    private long idHealthProfile;
	
	@XmlTransient
	private Person person;
	
	@XmlTransient
	private List<Measure> measureList;
	
	/*the current health profile is not saved in the database, is generated on-demand using the measure history*/
	private CurrentHealth currentHealth;
	
	
	public void addMeasure(Measure m){
		if(this.getMeasureList()==null){
			this.setMeasureList(new ArrayList<Measure>());
		}
		
		if(m.getDateRegistered()==null){
			m.setDateRegistered(Utilities.getCurrentDate());
		}
		
		this.getMeasureList().add(m);
	}

	@XmlTransient
	public long getIdHealthProfile() {
		return idHealthProfile;
	}

	public void setIdHealthProfile(long idHealthProfile) {
		this.idHealthProfile = idHealthProfile;
	}

	@XmlTransient
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@XmlTransient
	public List<Measure> getMeasureList() {
		return measureList;
	}

	public void setMeasureList(List<Measure> measureList) {
		this.measureList = measureList;
	}


	/**
	 * generates and returns the current health of the person.
	 * it takes the last measures by date and type in order to generate the current health state of the person.
	 * @return
	 */
	public CurrentHealth getCurrentHealth() {
		
		return currentHealth;
	}

	public void setCurrentHealth(CurrentHealth currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public Measure findMeasureByType(MeasureTypes type){
		if(measureList==null){
			return null;
		}
		
		if(measureList.size()==0){
			return null;
		}
		
		List<Measure> measures=new ArrayList<>(measureList);
		Collections.sort(measures);
		
		Iterator<Measure> it=measures.iterator();
		
		while(it.hasNext()){
			Measure m=it.next();
			if(m.getMeasureType().equals(type.toString())){
				return m;
			}
		}
		
		return null;
	}

}