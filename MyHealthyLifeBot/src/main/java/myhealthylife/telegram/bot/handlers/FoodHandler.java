package myhealthylife.telegram.bot.handlers;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myhealthylife.centric2.rest.model.Recipe;
import myhealthylife.centric2.rest.model.RecipeList;
import myhealthylife.dataservice.model.entities.Person;
import myhealthylife.telegram.bot.utils.ServicesLocator;
import myhealthylife.nutritionservice.soap.*;

public class FoodHandler {

	/**
	 * Gets a list of all the suggested foods for a specific user
	 * @param personId
	 * @return
	 */
	public static String foodForMe(String personId){
		
		Person p=null;
		
		// Checks if the person exists
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		// Gets all the foods present in service04
		Response foodsResponse=ServicesLocator.getCentric1Connection().path("/foods/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		// Checks the response status code
		if(foodsResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}
		
		List<Food> foods=foodsResponse.readEntity(FoodList.class).getFood();
		
		Iterator<Food> it=foods.iterator();
		
		String message="";
		
		// Composes the message to return to the client
		while(it.hasNext()){
			Food f=it.next();
			
			// Writes name and calories
			if(f.getName()!=null && f.getCalories()!=null)
				message+=f.getName()+"( "+f.getCalories()+"kcal )";
			else
				continue;
			
			if(f.getFoodType()!=null){
				
				// Writes type and category
				if(f.getFoodType().getCategory()!=null){
					message+=" [ type: "+f.getFoodType().getCategory()+"]";
				}
			}
			
			message+="\n";
		}
		
		return message;
		
	}
	
	
	
	/**
	 * Gets a specific recipe and all its details
	 * @param personId
	 * @param recipeName
	 * @return
	 */
	public static String getRecipeDetails(String personId, String recipeName){
		
		Person p=null;
		
		// Checks if the person exists
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		// Gets a specific recipe
		Response recipeResponse=ServicesLocator.getCentric2Connection().path("/recipe/name/"+recipeName).request().accept(MediaType.APPLICATION_JSON).get();
		
		// Checks the response status code
		if(recipeResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}

		String message="";
		List<Recipe> foods=recipeResponse.readEntity(RecipeList.class).getRecipes();
		
		// Prints all the foods in the recipe
		message = FoodHandler.printRecipesList(foods);
		
		// If no recipe was returned, then it prints an error
		if(message.equals("")) {
			message += "No recipe named '" + recipeName + "' was found\n";
		}
		
		return message;
		
	}
	
	
	
	
	/**
	 * Gets all the suggested recipes for the user
	 * @param personId
	 * @return
	 */
	public static String getSuggestedRecipes(String personId){
		
		Person p=null;
		
		// Checks if the person exists
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		// Gets all the suggested recipes
		Response recipeResponse=ServicesLocator.getCentric2Connection().path("/recipe/suggested/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		// Checks the response status code
		if(recipeResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}

		String message="";
		List<Recipe> foods=recipeResponse.readEntity(RecipeList.class).getRecipes();
		
		// Prints all the foods listed in the recipe
		message = FoodHandler.printRecipesList(foods);
		
		// If no food was found, then it prints an error
		if(message.equals("")) {
			message += "No recipe named was found in the database\n";
		}
		
		return message;
		
	}
	
	
	
	/**
	 * Prints all the recipes listed in a list (prints also the ingredients and the types information)
	 * @param foods The list of recipes
	 * @return The string representation of the recipe and their ingredients
	 */
	public static String printRecipesList(List<Recipe> foods) {
		
		String message = "";
		Iterator<Recipe> it=foods.iterator();
		
		// For every recipe in the list it prints all the information
		while(it.hasNext()){
			
			Recipe r=it.next();
			List<Food> ingredients = r.getIngredients();
			
			// Basic information and total calories
			if(r.getName()!=null) {
				message+="RECIPE #" + r.getRecipeId() + ": " + r.getName()+"["+r.getCalories()+"kcal]\n";
			}
			else {
				continue;
			}
			// Description
			if(r.getDescription()!=null) {
				message+="DESCRIPTION: " + r.getDescription() + "\n";
			}
			
			// Ingredients
			if(ingredients!=null && ingredients.size()!=0) {
				
				message+="INGREDIENTS:";
				for(int i=0;i<ingredients.size();i++) {
					
					Food singleIngredient = ingredients.get(i);
					message+="\n=>" + i + ". " + singleIngredient.getName() + " [" + singleIngredient.getCalories() + " - " + singleIngredient.getFoodType().getCategory() + "]";
					
				}
				
			}
			
			
			message+="\n__________\n\n";
		}
		
		return message;
	}
	
	
}
