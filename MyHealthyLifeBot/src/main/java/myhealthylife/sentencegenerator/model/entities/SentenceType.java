package myhealthylife.sentencegenerator.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="sentenceType")
public class SentenceType implements Serializable {

	private long idSentenceType;
	
	private String name;

	private Boolean motive;
	
	public long getIdSentenceType() {
		return idSentenceType;
	}

	public void setIdSentenceType(long idSentenceType) {
		this.idSentenceType = idSentenceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getMotive() {
		return motive;
	}

	public void setMotive(Boolean motive) {
		this.motive = motive;
	}
	
	
	
}
