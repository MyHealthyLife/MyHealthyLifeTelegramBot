package myhealthylife.dataservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import myhealthylife.dataservice.model.entities.Measure;

@XmlRootElement(name="currentHealth")
public class CurrentHealth {

	private List<Measure> measure;

	public List<Measure> getMeasure() {
		return measure;
	}

	public void setMeasure(List<Measure> measure) {
		this.measure = measure;
	}
	
}
