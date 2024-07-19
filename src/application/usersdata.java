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

public class usersdata implements Initializable {
	
	@FXML
	private ListView<Customer> waitingcustomers;
	
	@FXML
    private Label title;

  

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		

		if(Main.savelangmanager.equals("English")) {
			title.setText("Manage Training");
		
		
		}
        if(Main.savelangmanager.equals("Hebrew")) {
        	title.setText("ניהול אימונים");
			
		
		}
        if(Main.savelangmanager.equals("العربية")) {
        	title.setText(" اداره التدريبات");
			
		
		}
		
		//music.setStyle("-fx-control-inner-background: lightgray;");
        waitingcustomers.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
      
        waitingcustomers.getItems().addAll(Main.gym.getCustomers().values());
        waitingcustomers.setCellFactory(new CustomerNameListCellFactory2());
        
        waitingcustomers.setOnMouseClicked(event -> {
		    if (event.getClickCount() == 2) { // Check for double-click
		        Customer selectedExercise = waitingcustomers.getSelectionModel().getSelectedItem();
		        if (selectedExercise != null) {
		        	int Select = waitingcustomers.getSelectionModel().getSelectedIndex();
		        	Customer s= waitingcustomers.getItems().get(Select);
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
		// TODO Auto-generated method stub
				
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
