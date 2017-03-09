package myhealthylife.centric2.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFormat;



@XmlRootElement(name="dedicatedSentence")
@XmlType(propOrder={"idDedicatedSentence", "idUserOne", "idUserTwo", "usernameOne", "usernameTwo", "idSentence", "sentenceText", "insertionTime"})
public class DedicatedSentence implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idDedicatedSentence;

	@Column(name="userOne")
	private Long idUserOne;
	
	@Column(name="userTwo")
	private Long idUserTwo;

	@Column(name="usernameOne")
	private String usernameOne;

	@Column(name="usernameTwo")
	private String usernameTwo;
	
	@Column(name="idSentence")
	private Long idSentence;
	
	@Column(name="sentencetext")
	private String sentenceText;

	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@Column(name="insertionTime", insertable = true, updatable = true)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date insertionTime;
	
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


	public String getUsernameOne() {
		return usernameOne;
	}


	public void setUsernameOne(String usernameOne) {
		this.usernameOne = usernameOne;
	}


	public String getUsernameTwo() {
		return usernameTwo;
	}


	public void setUsernameTwo(String usernameTwo) {
		this.usernameTwo = usernameTwo;
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


	public Date getInsertionTime() {
		return insertionTime;
	}


	public void setInsertionTime(Date insertionTime) {
		this.insertionTime = insertionTime;
	}

	
	
}
