package myhealthylife.sentencegenerator.model.entities;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sentenceTypes")
public class SentenceTypeList {
	
	private List<SentenceType> sentenceType;

	public List<SentenceType> getSentenceType() {
		return sentenceType;
	}

	public void setSentenceType(List<SentenceType> sentenceType) {
		this.sentenceType = sentenceType;
	}

}
