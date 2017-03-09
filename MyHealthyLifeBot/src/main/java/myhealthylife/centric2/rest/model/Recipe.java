package myhealthylife.centric2.rest.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import myhealthylife.nutritionservice.soap.Food;

@XmlRootElement(name="recipe")
public class Recipe {

	@Id // defines this attributed as the one that identifies the entity
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name="recipeId") // maps the following attribute to a column
    private long recipeId;
	
	private List<Long> ingredientsIDs;
	
	private String name;
	
	private String description;
	
	/**
	 * this list will not saved in the DB, only the IDs, foods are already stored in the Service04
	 */
	@Transient
	private List<Food> ingredients;
	
	@Transient
	private long calories;

	public long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}

	@XmlTransient
	public List<Long> getIngredientsIDs() {
		
		/**/
		//computeIDS();
		return ingredientsIDs;
	}

	/**
	 * only the ids will be saved in the DB, calculate the id when someone asking for it
	 */
	public void computeIDS() {
		ingredientsIDs=new ArrayList<Long>();
		
		if(ingredients!=null){
			Iterator<Food> it=ingredients.iterator();
			
			while(it.hasNext()){
				Food f=it.next();
				
				ingredientsIDs.add(f.getIdFood());
			}
		}
	}

	public void setIngredientsIDs(List<Long> ingredientsIDs) {
		this.ingredientsIDs = ingredientsIDs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Food> getIngredients() {
				
		return ingredients;
	}


	public long getCalories() {
		return calories;
	}

	public void setCalories(long calories) {
		this.calories = calories;
	}
	
	public void computeCalories(){
		calories=0;
		Iterator<Food> iterator=getIngredients().iterator();
		
		while(iterator.hasNext()){
			Food f=iterator.next();
			if(f.getCalories()!=null)
				calories+=f.getCalories();
		}
	}
}
