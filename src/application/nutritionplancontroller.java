package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class nutritionplancontroller  implements Initializable {
	
	@FXML
    private ListView<Meal> meals;

    @FXML
    private ListView<Meal> AddedMeals;
    
    @FXML
    private ComboBox<String> sortCombBox;
    
   
    
    @FXML
    private Label cal, carbs, protin;
	
    double updatedCarbs=0, updatedCal=0, updatedProtin=0;
    double NeedsCarbs, NeedsCal, NeedsProtin;

	public void initialize(URL location, ResourceBundle resources) { 
		ObservableList<String> list = FXCollections.observableArrayList("calories","carbs","protin");
		sortCombBox.setItems(list);
		
		NeedsCarbs = Main.saveCarbs;
		NeedsCal = Main.saveCalories;
		NeedsProtin = Main.saveProtin;
		
	   	//meals.setStyle("-fx-control-inner-background: lightgray;");
	   	meals.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		//AddedMeals.setStyle("-fx-control-inner-background: lightgray;");
		AddedMeals.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
	
		meals.getItems().addAll(Main.gym.getMeals().values());
		//meals.getItems().sort(Comparator.comparingDouble(Meal::getProtin).reversed());

		cal.setText(updatedCal + "/" + String.valueOf(Main.saveCalories));
		cal.setTextFill(Color.RED);
		cal.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		carbs.setText(updatedCarbs + "/" + String.valueOf(Main.saveCarbs));
		carbs.setTextFill(Color.RED);
		carbs.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		protin.setText(updatedProtin + "/" + String.valueOf(Main.saveProtin));
		protin.setTextFill(Color.RED);
		protin.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		
		
		 Random random = new Random();
		 int number = random.nextInt(4);
		 int number2 = random.nextInt(4);
		 int number3 = random.nextInt(4);
		 
		 meals.getItems().sort(Comparator.comparingDouble(Meal::getCal).reversed());
		 
		// interestedjoin randomcust = items.get(number);
		 
		 Main.meal1=  meals.getItems().get(number);
		 meals.getItems().sort(Comparator.comparingDouble(Meal::getCarbs).reversed());
		 Main.meal2 = meals.getItems().get(number2);
		
		 meals.getItems().sort(Comparator.comparingDouble(Meal::getProtin).reversed());
		Main.meal3 = meals.getItems().get(number3);
	
		
			meals.getItems().clear();
			meals.getItems().addAll(Main.gym.getMeals().values());
		
		
		
	    
	}
	
	public void addact(MouseEvent Action) {
		try {
		int Select = meals.getSelectionModel().getSelectedIndex();
		AddedMeals.getItems().add(meals.getItems().get(Select));
		updatedCarbs=0; 
		updatedCal=0;
		updatedProtin=0;
		for (Meal meal : AddedMeals.getItems()) {
			updatedCarbs = updatedCarbs+ meal.getCarbs();
			updatedCal = updatedCal +meal.getCal();
			updatedProtin = updatedProtin+ meal.getProtin();
		}
		cal.setText(updatedCal + "/" + String.valueOf(Main.saveCalories));
		if(updatedCal - NeedsCal < 10   &&  updatedCal>NeedsCal) {
			cal.setTextFill(Color.GREEN);
		}
		else {
			cal.setTextFill(Color.RED);
		}
		
		
		carbs.setText(updatedCarbs + "/" + String.valueOf(Main.saveCarbs));
		if(updatedCarbs - NeedsCarbs < 10   && updatedCarbs>NeedsCarbs ) {
			carbs.setTextFill(Color.GREEN);
		}
		else {
			carbs.setTextFill(Color.RED);
		}
		
		
		
		protin.setText(updatedProtin + "/" + String.valueOf(Main.saveProtin));
		if(updatedProtin - NeedsProtin < 10 && updatedProtin>NeedsProtin) {
			protin.setTextFill(Color.GREEN);
		}
		else {
			protin.setTextFill(Color.RED);
		}
		
		
		
		}catch(IndexOutOfBoundsException e) {
			Alert aler = new Alert(AlertType.ERROR);
			aler.setHeaderText("no selected thing");
			aler.showAndWait();
		}
	}                                              
	 public void remove(MouseEvent Action) {
		 try {
			int Select = AddedMeals.getSelectionModel().getSelectedIndex();
			AddedMeals.getItems().remove(Select);
			updatedCarbs=0; 
			updatedCal=0;
			updatedProtin=0;
			for (Meal meal : AddedMeals.getItems()) {
				updatedCarbs = updatedCarbs+ meal.getCarbs();
				updatedCal = updatedCal +meal.getCal();
				updatedProtin = updatedProtin+ meal.getProtin();
			}
			cal.setText(updatedCal + "/" + String.valueOf(Main.saveCalories));
			if(updatedCal - NeedsCal < 10  && updatedCal>NeedsCal) {
				cal.setTextFill(Color.GREEN);
			}
			else {
				cal.setTextFill(Color.RED);
			}
			
			
			carbs.setText(updatedCarbs + "/" + String.valueOf(Main.saveCarbs));
			if(updatedCarbs - NeedsCarbs < 10  && updatedCarbs>NeedsCarbs ) {
				carbs.setTextFill(Color.GREEN);
			}
			else {
				carbs.setTextFill(Color.RED);
			}
			
			
			
			protin.setText(updatedProtin + "/" + String.valueOf(Main.saveProtin));
			if(updatedProtin - NeedsProtin < 10 && updatedProtin>NeedsProtin)  {
				protin.setTextFill(Color.GREEN);
			}
			else {
				protin.setTextFill(Color.RED);
			}
			
			
			}catch(IndexOutOfBoundsException e) {
				Alert aler = new Alert(AlertType.ERROR);
				aler.setHeaderText("no selected thing");
				aler.showAndWait();
			}
		}
	 
	 public void sort(ActionEvent event) throws IOException{
		 
		 if( sortCombBox.getValue().equals("calories")) {
			 meals.getItems().sort(Comparator.comparingDouble(Meal::getCal).reversed());
			 
		 }
         if( sortCombBox.getValue().equals("carbs")) {
        	 meals.getItems().sort(Comparator.comparingDouble(Meal::getCarbs).reversed());
			 
		 }
         if( sortCombBox.getValue().equals("protin")) {
        	 meals.getItems().sort(Comparator.comparingDouble(Meal::getProtin).reversed());
	 
 }
		 
		
	 }
	 
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("nutritionMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }
	
	
	


}
