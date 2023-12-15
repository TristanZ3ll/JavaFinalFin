/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproj;
import java.util.ArrayList;


/**
 *
 * @author tczel
 */
public class Recipe {
     private String name;
   private int cookTime;
   private String instructions;
    private int rating;
    private String catagory;
    private String ingredients;

    //ArrayList<String> ingredients = new ArrayList<String>();


    Recipe(String name, int cookTime, String instructions, String ingredients) {
        this.name = name;
        this.cookTime=cookTime;
        this.instructions =instructions;
        this.ingredients=ingredients;
    }
    
   
    
    public String getIngredients(){
        return ingredients;
    }
    
    
    public void setIngredients(String newIngredients){
        ingredients = newIngredients;
    }
    
    
    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public int getCookTime(){
        return cookTime;
    }

    public void setCookTime(int newCookTime){
        cookTime = newCookTime;
    }



    public String getInstruct(){
        return instructions;
    }


    public void setInstuct(String newInstructions){
        instructions = newInstructions;
}

    public int getRating(){
        return rating;
    }

    public void setRating(int newRating){
        rating = newRating;
    }

    public String getCat(){
        return catagory;
    }

    public void setCat(String newCat){
        catagory =newCat;
    }


}
