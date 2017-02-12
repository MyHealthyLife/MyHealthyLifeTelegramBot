package myhealtylife.optimalparamters.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import myhealtylife.optimalparamters.model.entity.Parameter;

@XmlRootElement(name="parametersList")
public class ParametersList {
	private List<Parameter> parameters;

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
}
