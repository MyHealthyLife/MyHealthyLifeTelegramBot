package myhealtylife.optimalparamters.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name="age_range")
public class AgeRange implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long idRange;
	
	private Integer fromAge;
	
	private Integer toAge;
	
	private List<Parameter> parameter;

	public long getIdRange() {
		return idRange;
	}

	public void setIdRange(long idRange) {
		this.idRange = idRange;
	}

	public Integer getFromAge() {
		return fromAge;
	}

	public void setFromAge(Integer fromAge) {
		this.fromAge = fromAge;
	}

	public Integer getToAge() {
		return toAge;
	}

	public void setToAge(Integer toAge) {
		this.toAge = toAge;
	}

	@XmlTransient
	public List<Parameter> getParameter() {
		return parameter;
	}

	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}
	
    
  

}
