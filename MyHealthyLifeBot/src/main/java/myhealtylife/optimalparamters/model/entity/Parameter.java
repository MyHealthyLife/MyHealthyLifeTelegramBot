package myhealtylife.optimalparamters.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="parameter")
public class Parameter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long idParameter;
	
	private String parameterName;
	
	private String sex;
	
	private Double value;
	
	private AgeRange ageRange;

	public long getIdParameter() {
		return idParameter;
	}

	public void setIdParameter(long idParameter) {
		this.idParameter = idParameter;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public AgeRange getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(AgeRange ageRange) {
		this.ageRange = ageRange;

	}
}
