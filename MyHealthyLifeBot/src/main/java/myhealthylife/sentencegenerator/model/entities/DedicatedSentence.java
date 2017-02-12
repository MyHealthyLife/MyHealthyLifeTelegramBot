package myhealthylife.sentencegenerator.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name="dedicatedSentence")
public class DedicatedSentence implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private long idDedicatedSentence;

	private Long idUserOne;
	
	private Long idUserTwo;

	private Long idSentence;
	
	private String sentenceText;
	
	public DedicatedSentence() {
	}


	public long getIdDedicatedSentence() {
		return idDedicatedSentence;
	}


	public void setIdDedicatedSentence(long idDedicatedSentence) {
		this.idDedicatedSentence = idDedicatedSentence;
	}


	public Long getIdUserOne() {
		return idUserOne;
	}


	public void setIdUserOne(Long idUserOne) {
		this.idUserOne = idUserOne;
	}


	public Long getIdUserTwo() {
		return idUserTwo;
	}


	public void setIdUserTwo(Long idUserTwo) {
		this.idUserTwo = idUserTwo;
	}


	public Long getIdSentence() {
		return idSentence;
	}


	public void setIdSentence(Long idSentence) {
		this.idSentence = idSentence;
	}


	public String getSentenceText() {
		return sentenceText;
	}


	public void setSentenceText(String sentenceText) {
		this.sentenceText = sentenceText;
	}
	
}
