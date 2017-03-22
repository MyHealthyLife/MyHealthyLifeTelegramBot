package myhealthylife.nutritionservice.soap;

import java.io.Serializable;



public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idFood;
	
	private String name;
	
	private Integer calories;
	
	private FoodType foodType;
	
	public Food() {
	}
	

	/* GETTERS AND SETTERS */
	public Long getIdFood() {
		return idFood;
	}


	public void setIdFood(Long idFood) {
		this.idFood = idFood;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getCalories() {
		return calories;
	}


	public void setCalories(Integer calories) {
		this.calories = calories;
	}


	public FoodType getFoodType() {
		return foodType;
	}


	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
}