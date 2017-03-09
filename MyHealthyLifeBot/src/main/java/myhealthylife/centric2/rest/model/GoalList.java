package myhealthylife.centric2.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import myhealtylife.optimalparamters.model.entity.Parameter;


@XmlRootElement(name="goal_element")
public class GoalList {
	private List<Parameter> goals;

	public List<Parameter> getGoals() {
		return goals;
	}

	public void setGoals(List<Parameter> goals) {
		this.goals = goals;
	}
}
