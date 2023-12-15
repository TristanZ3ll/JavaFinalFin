package com.mycompany.finalproj;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button; 
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.geometry.Pos; 
import javafx.geometry.Insets; 
import javafx.scene.control.Label;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
       RecipeBook book = new RecipeBook();
        
        
        
        
        
        
        //Add recipe, display, and search recipe button.
        Button addB = new Button("Add Recipe");
        Button searchB= new Button("Search Recipe");
        Button displayB = new Button("Display");
        //Search textfield
        TextField searchT = new TextField("");
        
        
        
        StackPane stack = new StackPane();
        
        
        //Main GridPane
        GridPane griddy = new GridPane();
        griddy.setMinSize(400,200);
        griddy.setPadding(new Insets(10,10,10,10));
        griddy.setVgap(5); 
        griddy.setHgap(5);     
        griddy.setAlignment(Pos.CENTER);
        griddy.add(searchT, 0 ,1);
        griddy.add(searchB,1,1);
        griddy.add(addB,1,0);
        griddy.add(displayB,0,0);
        Button deleteB= new Button("Delete Recipe");
        griddy.add(deleteB,1,2);
    
        
        //Gridpane for adding recipes
        GridPane addPane = new GridPane();
        addPane.setMinSize(400,200);
        addPane.setPadding(new Insets(10,10,10,10));
        addPane.setVgap(5); 
        addPane.setHgap(5);     
        addPane.setAlignment(Pos.CENTER);
        
        
        
        //addPane buttons
        Button submitB = new Button("Submit");
        
        //addPane textFields
        TextField nameF = new TextField("Name of recipe");
        TextArea ingredientsF = new TextArea("Ingredients needed for recipe");
        TextField cookTimeF = new TextField("Cook Time in Minutes");
        TextArea instructionsF = new TextArea("Instructions for the dish");
       
        addPane.add(nameF,0,0);
        addPane.add(ingredientsF,1,0);
        addPane.add(cookTimeF, 0, 1);
        addPane.add(instructionsF,1,1);
        addPane.add(submitB,2,2);
        
         Scene main = new Scene(stack); 
         
         stack.getChildren().add(griddy);
         
         
         //gridpane to display results from search
         GridPane resultPane = new GridPane();
        resultPane.setMinSize(400,200);
        resultPane.setPadding(new Insets(10,10,10,10));
        resultPane.setVgap(5); 
        resultPane.setHgap(5);     
        resultPane.setAlignment(Pos.CENTER);
        Button resultBack = new Button("Back");
        resultPane.add(resultBack,5,5);
        
        
        //pane for displaying all recipes
        GridPane displayPane = new GridPane();
        displayPane.setMinSize(400,200);
        displayPane.setPadding(new Insets(10,10,10,10));
        displayPane.setVgap(5); 
        displayPane.setHgap(5);     
        displayPane.setAlignment(Pos.CENTER);
        Button displayBack= new Button("Back");
        
        
         
        stage.setScene(main);
        
        
        //event for addB button to pull up add recipe screen
        addB.setOnAction(e -> {
            stack.getChildren().remove(griddy);
            stack.getChildren().add(addPane);
            
            
            /*griddy.getChildren().clear();
            griddy.getChildren().add(addPane);
*/
        });
        
        
        submitB.setOnAction(e->{
            try{
                int cookTimeInt = Integer.parseInt(cookTimeF.getText());
            } catch (NumberFormatException nfe){
                return;
            }
            
            int cookTimeInt = Integer.parseInt(cookTimeF.getText());
            
            Recipe recipe = new Recipe(nameF.getText(),cookTimeInt,instructionsF.getText(), ingredientsF.getText());
            //Add Recipe to array list
            
            stack.getChildren().remove(addPane);
            stack.getChildren().add(griddy);
            
            //Adds recipe object ro recipe book array
            book.addRecipe(recipe);
        });
        
        
        //Searches recipe book for recipe and displays all info about it.
        searchB.setOnAction(e->{
           Recipe recipe = book.searchRecipe(searchT.getText());
           
           if (recipe== null){
               griddy.add(new Label("Recipe not found"), 5, 5);
               return;
           }
           
           resultPane.add(new Label(recipe.getName()),0,0);
           resultPane.add(new Label(recipe.getCookTime()+" minutes to cook."),1,1);
           resultPane.add(new Label(recipe.getInstruct()),2,2);
           resultPane.add(new Label("Ingredients: "+ recipe.getIngredients()),3,3);
           
           stack.getChildren().remove(griddy);
           stack.getChildren().add(resultPane);
           
        });
        
        
        
        //Delete recipe 
        
        deleteB.setOnAction(e-> {
             
           Recipe recipe = book.searchRecipe(searchT.getText());
           
           if (recipe== null){
               griddy.add(new Label("Recipe not found"), 5, 5);
               return;
           }
           book.deleteRecipe(recipe.getName());
           
        });
        
        
        //back button for result page
        resultBack.setOnAction(e-> {
            stack.getChildren().remove(resultPane);
            stack.getChildren().add(griddy);
        });
        
        displayBack.setOnAction(e-> {
            displayPane.getChildren().clear();
            stack.getChildren().remove(displayPane);
            stack.getChildren().add(griddy);
        });
        
        //Display all recipe names
        
        displayB.setOnAction(e->{
            for (int i =0; i< book.bookSize(); i++){
                displayPane.add(new Label(book.getIndex(i)),0,i);
            }
            stack.getChildren().remove(griddy);
            stack.getChildren().add(displayPane);
            displayPane.add(displayBack,5,5);
        });
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}