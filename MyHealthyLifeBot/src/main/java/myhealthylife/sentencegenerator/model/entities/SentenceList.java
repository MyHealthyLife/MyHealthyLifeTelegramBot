package myhealthylife.sentencegenerator.model.entities;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sentences")
public class SentenceList {
	
	private List<Sentence> sentence;

	public List<Sentence> getSentence() {
		return sentence;
	}

	public void setSentence(List<Sentence> sentence) {
		this.sentence = sentence;
	}

}
