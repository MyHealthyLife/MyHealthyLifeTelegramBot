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
		
		Response foodsResponse=ServicesLocator.getCentric1Connection().path("/recipe/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
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

		String message="";
		List<Recipe> foods=recipeResponse.readEntity(RecipeList.class).getRecipes();
		
		message = FoodHandler.printRecipesList(foods);
		
		if(message.equals("")) {
			message += "No recipe named '" + recipeName + "' was found\n";
		}
		
		return message;
		
	}
	
	
	
	
	
	public static String getSuggestedRecipes(String personId){
		
		Person p=null;
		
		Response res= ServicesLocator.getCentric1Connection().path("user/data/telegram/id/"+personId).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(res.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Person data)";
		}
		
		p=res.readEntity(Person.class);
		
		
		Response recipeResponse=ServicesLocator.getCentric2Connection().path("/recipe/suggested/"+p.getUsername()).request().accept(MediaType.APPLICATION_JSON).get();
		
		if(recipeResponse.getStatus()!=Response.Status.OK.getStatusCode()){
			return "An error occurs during information retrival (Foods)";
		}

		String message="";
		List<Recipe> foods=recipeResponse.readEntity(RecipeList.class).getRecipes();
		
		message = FoodHandler.printRecipesList(foods);
		
		if(message.equals("")) {
			message += "No recipe named was found in the database\n";
		}
		
		return message;
		
	}
	
	
	
	public static String printRecipesList(List<Recipe> foods) {
		
		String message = "";
		Iterator<Recipe> it=foods.iterator();
		
		while(it.hasNext()){
			
			Recipe r=it.next();
			List<Food> ingredients = r.getIngredients();
			
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
