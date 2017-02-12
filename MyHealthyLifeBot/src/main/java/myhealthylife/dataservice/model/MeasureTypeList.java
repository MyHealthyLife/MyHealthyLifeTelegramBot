package myhealthylife.dataservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="measureTypes")
/**
 * this class is used for the call that must return all the measure type available (weight, eight, etc..)
 * 
 * @author stefano
 *
 */
public class MeasureTypeList {

	private List<String> measureType;

	public List<String> getMeasureType() {
		
		/*Convert all measure type in the enumerator in strings*/
		MeasureTypes types[]=MeasureTypes.values();
		measureType=new ArrayList<String>();
		
		for(MeasureTypes t:types){
			measureType.add(t.toString());
		}
		
		return measureType;
	}

	public void setMeasureType(List<String> measureType) {
		this.measureType = measureType;
	}
}
