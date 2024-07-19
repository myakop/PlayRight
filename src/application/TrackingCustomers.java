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

public class TrackingCustomers implements Initializable {
	
	@FXML
	private ListView<Customer> customers;
	
	 @FXML
	    private TextField search;
	 @FXML
	    private Label title;

	    @FXML
	    private Button backbtn;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(Main.savelangmanager.equals("English")) {
			
			backbtn.setText("Back");
			title.setText("Tracking Cutomers");
			search.setPromptText("search by name");
        
			
		}
		 if(Main.savelangmanager.equals("Hebrew")) {
			 
				backbtn.setText("חזור");
				title.setText("מעקב התקדמות");
				search.setPromptText("חיפוש לפי שם");
			
		}
		 if(Main.savelangmanager.equals("العربية")) {
			 
				backbtn.setText("رجوع");
				title.setText("تتبع التقدم");
				search.setPromptText("البحث عن طريق الإسم");
			
		}
		
		//customers.setStyle("-fx-control-inner-background: lightgray;");
		customers.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		
		customers.getItems().addAll(Main.gym.getCustomers().values());
		
		search.textProperty().addListener((observable, oldValue, newValue) -> {
	        filterCustomers(newValue);
	    });
		
		customers.setOnMouseClicked(event -> {
		    if (event.getClickCount() == 2) { // Check for double-click
		        Customer selectedExercise = customers.getSelectionModel().getSelectedItem();
		        if (selectedExercise != null) {
		        	int Select = customers.getSelectionModel().getSelectedIndex();
		        	Customer s= customers.getItems().get(Select);
		    		Main.savecustomerfortrack =s;
		    		
		    		
		    	    try {
		    	    	 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    			    Parent root = FXMLLoader.load(getClass().getResource("data2.fxml"));
		    			    Scene scene = new Scene(root,800,466);
		    			    Image icon = new Image("/Images/icon.png");
		    			    primaryStage.getIcons().add(icon);
		    			    primaryStage.setScene(scene);
		    			    primaryStage.show();
		    	    } catch (IOException e) {
		    	        e.printStackTrace();
		    	    }
		        }
				   
	    		
	    	    
	        }
	    
	});
		    
		
		    
		
		
		
		
		
		
		
		
		
	}
	private void filterCustomers(String keyword) {
	    Collection<Customer> allCustomers = Main.gym.getCustomers().values();
	    
	    // Convert the collection to an ObservableList
	    ObservableList<Customer> customerList = FXCollections.observableArrayList(allCustomers);

	    // Create a filtered list based on the keyword
	    ObservableList<Customer> filteredCustomers = customerList.filtered(customer -> {
	        // You can use different conditions to filter by customer name, e.g., using contains() for a case-insensitive search
	        return customer.getFirstName().toLowerCase().contains(keyword.toLowerCase());
	    });

	    // Update the ListView to show the filtered results
	    customers.setItems(filteredCustomers);
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
