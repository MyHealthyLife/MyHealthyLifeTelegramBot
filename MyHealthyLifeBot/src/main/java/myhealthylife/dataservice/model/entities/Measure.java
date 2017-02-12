package myhealthylife.dataservice.model.entities;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



public class Measure implements Comparable<Measure>{
	
    private long mid;
	
	private Double measureValue;
	
	private String measureType;
	
    private Date dateRegistered;
	
	
	@XmlTransient
	private HealthProfile  healthProfile;

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public Double getMeasureValue() {
		return measureValue;
	}

	public void setMeasureValue(Double value) {
		this.measureValue = value;
	}


	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date created) {
		this.dateRegistered = created;
	}

	public String getMeasureType() {
		return measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	@XmlTransient
	public HealthProfile getHealthProfile() {
		return healthProfile;
	}

	public void setHealthProfile(HealthProfile healthProfile) {
		this.healthProfile = healthProfile;
	}
	
	

	@Override
	public int compareTo(Measure o) {
		if(o.getDateRegistered().getTime()>getDateRegistered().getTime())
			return 1;
		return -1;
	}
	

	
}
