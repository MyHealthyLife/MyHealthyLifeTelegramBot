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

	public static String foodForMe(String personId){
		
		Person p=null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		Response foodsResponse=ServicesLocator.getCentric1Connection().path("/foods/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(foodsResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}
		
		List<Food> foods=foodsResponse.readEntity(FoodList.class).getFood();
		
		Iterator<Food> it=foods.iterator();
		
		String message="";
		
		while(it.hasNext()){
			Food f=it.next();
			if(f.getName()!=null && f.getCalories()!=null)
				message+=f.getName()+"( "+f.getCalories()+"kcal )";
			else
				continue;
			
			if(f.getFoodType()!=null){
				if(f.getFoodType().getCategory()!=null){
					message+=" [ type: "+f.getFoodType().getCategory()+"]";
				}
			}
			
			message+="\n";
		}
		
		return message;
		
	}
	
	
	
	
	public static String getRecipeDetails(String personId, String recipeName){
		
		Person p=null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		
		Response recipeResponse=ServicesLocator.getCentric2Connection().path("/recipe/name/"+recipeName).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(recipeResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}

		List<Recipe> foods=recipeResponse.readEntity(RecipeList.class).getRecipes();
		
		Iterator<Recipe> it=foods.iterator();
		
		String message="";
		
		while(it.hasNext()){
			
			Recipe r=it.next();
			List<Food> ingredients = r.getIngredients();
			System.out.println("Size of ingredients: " + ingredients!=null);
			
			if(r.getName()!=null) {
				message+="RECIPE #" + r.getRecipeId() + ": " + r.getName()+"["+r.getCalories()+"kcal]\n";
			}
			else {
				continue;
			}
			if(r.getDescription()!=null) {
				message+="DESCRIPTION: " + r.getDescription() + "\n";
			}
			if(ingredients!=null && ingredients.size()!=0) {
				System.out.println("Size of ingredients: " + ingredients.size());
				message+="INGREDIENTS:";
				for(int i=0;i<ingredients.size();i++) {
					
					Food singleIngredient = ingredients.get(i);
					message+="\n=>" + i + ". " + singleIngredient.getName() + " [" + singleIngredient.getCalories() + " - " + singleIngredient.getFoodType().getCategory() + "]";
					
				}
				
			}
			
			
			message+="\n__________\n\n";
		}
		if(message.equals("")) {
			message += "No recipe named '" + recipeName + "' was found\n";
		}
		
		return message;
		
	}
	
	
	
	
	
	public static String getSuggestedRecipes(String personId){
		
		Person p=null;
		System.out.println("Username id: " + personId);
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		System.out.println("Username request: /recipe/suggested/" + p.getUsername());
		Response recipeResponse=ServicesLocator.getCentric2Connection().path("/recipe/suggested/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(recipeResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}

		List<Recipe> foods=recipeResponse.readEntity(RecipeList.class).getRecipes();
		
		Iterator<Recipe> it=foods.iterator();
		
		String message="";
		
		while(it.hasNext()){
			
			Recipe r=it.next();
			List<Food> ingredients = r.getIngredients();
			System.out.println("Size of ingredients: " + ingredients!=null);
			
			if(r.getName()!=null) {
				message+="RECIPE #" + r.getRecipeId() + ": " + r.getName()+"["+r.getCalories()+"kcal]\n";
			}
			else {
				continue;
			}
			if(r.getDescription()!=null) {
				message+="DESCRIPTION: " + r.getDescription() + "\n";
			}
			if(ingredients!=null && ingredients.size()!=0) {
				System.out.println("Size of ingredients: " + ingredients.size());
				message+="INGREDIENTS:";
				for(int i=0;i<ingredients.size();i++) {
					
					Food singleIngredient = ingredients.get(i);
					message+="\n=>" + i + ". " + singleIngredient.getName() + " [" + singleIngredient.getCalories() + " - " + singleIngredient.getFoodType().getCategory();
					
				}
				
			}
			
			
			message+="\n__________\n\n";
		}
		if(message.equals("")) {
			message += "No recipe named was found in the database\n";
		}
		
		return message;
		
	}
	
	
}
