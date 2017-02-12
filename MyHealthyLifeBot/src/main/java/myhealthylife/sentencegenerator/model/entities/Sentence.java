package myhealthylife.sentencegenerator.model.entities;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import java.util.Date;
import java.util.List;

@XmlRootElement(name="sentence")
public class Sentence implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idSentence;
	
	private String text;
	
	private String url;
	
	private SentenceType sentenceType;
	
	public Sentence() {
	}
	

	/* GETTERS AND SETTERS */
	public long getIdSentence() {
		return idSentence;
	}


	public void setIdSentence(long idSentence) {
		this.idSentence = idSentence;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	public SentenceType getSentenceType() {
		return sentenceType;
	}


	public void setSentenceType(SentenceType sentenceType) {
		this.sentenceType = sentenceType;
	}


}