/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproj;
import java.util.*;

/**
 *
 * @author tczel
 */
public class RecipeBook {
    
    
    private List<Recipe> recipes = new ArrayList<Recipe>();

    

    
       public String getIndex(int i){
           return recipes.get(i).getName();
       }
    
     public int bookSize(){
        return recipes.size();
    }
    void addRecipe(Recipe recipe){
        recipes.add(recipe);
}
    
    
    
    Recipe searchRecipe(String recipe){
        for(Recipe i : recipes){
            if (i.getName().equals(recipe)){
                return i;
            }
        }
        return null;
    }
    
    void deleteRecipe(String recipe){
        for (Recipe i : recipes){
            if (i.getName().equals(recipe)){
                recipes.remove(i);
                return;
            }
        }
    }
}