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

public class ManageTrainig2 implements Initializable {
	
	@FXML
	private ListView<Customer> waitingcustomers;
	
	@FXML
    private Label title;

    @FXML
    private Button backbtn;
    @FXML
    private Button sort;
    @FXML
    private Button build;

   

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		for(Customer cust :Main.gym.getWaitingcustomers()) {
			if(cust.palntrainer != null) {
				Main.gym.getWaitingcustomers().remove(cust);
				Main.update();
			}
		}
		
		

		if(Main.savelangmanager.equals("English")) {
			title.setText("Manage Training");
			backbtn.setText("back");
			sort.setText("WaitCustomers");
			build.setText("build plan");
		
		}
        if(Main.savelangmanager.equals("Hebrew")) {
        	title.setText("ניהול אימונים");
			backbtn.setText("חזור");
			sort.setText("לקוחות בהמתנה");
			build.setText("בנה תוכנית");
		
		}
        if(Main.savelangmanager.equals("العربية")) {
        	title.setText(" اداره التدريبات");
			backbtn.setText("رجوع");
			sort.setText("زباىن بانتظار");
			build.setText("ابني البرنامج");
		
		}
		
		//music.setStyle("-fx-control-inner-background: lightgray;");
        waitingcustomers.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
      
        waitingcustomers.getItems().addAll(Main.gym.getCustomers().values());
        waitingcustomers.setCellFactory(new CustomerNameListCellFactory());
		// TODO Auto-generated method stub
				
	}
	
	
	public void buildplan (ActionEvent event) throws IOException {
		int Select = waitingcustomers.getSelectionModel().getSelectedIndex();
		Main.savecustomerforplan = waitingcustomers.getItems().get(Select);
		if(Main.savecustomerforplan.howmanydays == null) {
			 Alert aler = new Alert(AlertType.CONFIRMATION);
				aler.setHeaderText("The customer did not sign up for the training program");
				aler.showAndWait();	
				return;
		}
		
		
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("ManageTraining3.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	}
	
	public void waitcust(ActionEvent event) throws IOException{
		
	
		if(sort.getText().equals("WaitCustomers") || sort.getText().equals("לקוחות בהמתנה") || sort.getText().equals("زباىن بانتظار")  ) {
			
			if(sort.getText().equals("WaitCustomers")) {
				sort.setText("All");
			}
			if(sort.getText().equals("לקוחות בהמתנה")) {
				sort.setText("הכל");
			}
			if(sort.getText().equals("زباىن بانتظار")) {
				sort.setText("الكل");
			}
			
			waitingcustomers.getItems().clear();
		waitingcustomers.getItems().addAll(Main.gym.waitingcustomers);
		waitingcustomers.setCellFactory(new CustomerNameListCellFactory());
		
		}
		else if(sort.getText().equals("All") || sort.getText().equals("הכל") || sort.getText().equals("الكل") ) {
			
			if(sort.getText().equals("All")){
				sort.setText("WaitCustomers");
			}
			if(sort.getText().equals("הכל")){
				sort.setText("לקוחות בהמתנה");
			}
			if(sort.getText().equals("الكل")){
				sort.setText("زباىن بانتظار");
			}
			
			
			waitingcustomers.getItems().clear();
			waitingcustomers.getItems().addAll(Main.gym.getCustomers().values());
			waitingcustomers.setCellFactory(new CustomerNameListCellFactory());
			
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
