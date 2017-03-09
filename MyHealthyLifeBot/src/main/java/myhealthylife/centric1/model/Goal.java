package myhealthylife.centric1.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="goal")
/**
 * This class rapresent the value which the may be reach in order to have the optimal value based on its age and sex;
 * @author stefano
 *
 */
public class Goal {

	private Double valueToReach;
	private Double actualValue;
	private Double difference;
	private String goalName;
	
	public Goal(){
		
	}
	
	public Goal(double goal, double actual, String name){
		actualValue=actual;
		valueToReach=goal;
		
		difference=goal-actual;
		
		goalName=name;
	}
	
	public Double getValueToReach() {
		return valueToReach;
	}
	public void setValueToReach(Double valueToReach) {
		this.valueToReach = valueToReach;
	}
	public Double getActualValue() {
		return actualValue;
	}
	public void setActualValue(Double actualValue) {
		this.actualValue = actualValue;
	}
	public Double getDifference() {
		return difference;
	}
	public void setDifference(Double difference) {
		this.difference = difference;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
}
