package myhealthylife.dataservice.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import myhealthylife.dataservice.model.entities.Measure;

@XmlRootElement(name="measure_hystory")
/**
 * this class is used for encapsulate and send the measure history of a person to the user
 * @author stefano
 *
 */
public class MeasureHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Measure> measures;

	public List<Measure> getMeasures() {
		return measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

}
