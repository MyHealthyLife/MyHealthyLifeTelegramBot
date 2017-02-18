package myhealtylife.optimalparamters.model;


import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rank")
public class Rank {

	private ArrayList<String> compactRanking;
	
	public ArrayList<String> getCompactRanking() {
		return compactRanking;
	}

	public void setCompactRanking(ArrayList<String> compactRanking) {
		this.compactRanking = compactRanking;
	}
	
}
