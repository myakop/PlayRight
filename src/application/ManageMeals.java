package application;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ManageMeals implements Initializable {
	
	@FXML
	private ListView<Meal> meals;
	@FXML
    private TextField search;
	
	 @FXML
	    private Label title;

	    @FXML
	    private Button backbtn;

	    @FXML
	    private Button addbtn;

	    @FXML
	    private Button removebtn;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(Main.savelangmanager.equals("English")) {
			title.setText("Manage Meals");
			backbtn.setText("back");
			addbtn.setText("add");
			removebtn.setText("remove");
			search.setPromptText("search by name");
		}
        if(Main.savelangmanager.equals("Hebrew")) {
        	title.setText("ניהול ארוחות");
			backbtn.setText("חזור");
			addbtn.setText("הוספה");
			removebtn.setText("מחיקה");
			search.setPromptText("חיפוש לפי שם");
		}
        if(Main.savelangmanager.equals("العربية")) {
        	title.setText("اداره الوجبات");
			backbtn.setText("رجوع");
			addbtn.setText("اضافه");
			removebtn.setText("محي");
			search.setPromptText("البحث عن طريق الإسم");
		}
		
		
		//meals.setStyle("-fx-control-inner-background: lightgray;");
		meals.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		
		meals.getItems().addAll(Main.gym.getMeals().values());
		// TODO Auto-generated method stub
		
		search.textProperty().addListener((observable, oldValue, newValue) -> {
	        filterMeals(newValue);
		});
		
	}
	
	private void filterMeals(String keyword) {
	    Collection<Meal> allMeals = Main.gym.getMeals().values();
	    
	    // Convert the collection to an ObservableList
	    ObservableList<Meal> MealList = FXCollections.observableArrayList(allMeals);

	    // Create a filtered list based on the keyword
	    ObservableList<Meal> filteredCustomers = MealList.filtered(Meal -> {
	        // You can use different conditions to filter by customer name, e.g., using contains() for a case-insensitive search
	        return Meal.getName().toLowerCase().contains(keyword.toLowerCase());
	    });

	    // Update the ListView to show the filtered results
	    meals.setItems(filteredCustomers);
	}

	
	 public void AddMeal(ActionEvent event) throws IOException{
		   
		 Parent root = FXMLLoader.load(getClass().getResource("addMeal.fxml"));
		 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene cn = new Scene(root);
			st.setScene(cn);
			st.show();
			
	}
	 
	 
	 public void removemeal(ActionEvent event) throws IOException{
		 
		 
		 
		 int Select = meals.getSelectionModel().getSelectedIndex();
		 if(Main.gym.removemeal((Meal)meals.getItems().get(Select))) {
		    meals.getItems().remove(Select);
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully remove");
			aler.showAndWait();
			}
		 
	 }
	 
		 
	 
	 
	
	 
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }

}
