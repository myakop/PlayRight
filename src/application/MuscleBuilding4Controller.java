package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MuscleBuilding4Controller implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	}
	
	
public void goToexercisesday1(ActionEvent event) throws IOException {
	if(Main.saveCustomer.palntrainer ==  null) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
	
	
	 if(Main.saveCustomer.palntrainer.get(1).isEmpty()) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
		
	 Main.category="MB4";
	    Main.saveperviospage = "MB4day1";
	    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3DaysTrainig.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    
	    primaryStage.show();
	    
			
}

public void goToexercisesday2(ActionEvent event) throws IOException {
	if(Main.saveCustomer.palntrainer ==  null) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
	
	if(Main.saveCustomer.palntrainer.get(2).isEmpty()) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
	
	 Main.category="MB4";
	    Main.saveperviospage = "MB4day2";
	    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3DaysTrainig.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    
	    primaryStage.show();
			
}
public void goToexercisesday3(ActionEvent event) throws IOException {
	if(Main.saveCustomer.palntrainer ==  null) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
	if(Main.saveCustomer.palntrainer.get(3).isEmpty()) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
	
	 Main.category="MB4";
	    Main.saveperviospage = "MB4day3";
	    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3DaysTrainig.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    
	    primaryStage.show();
			
}
public void goToexercisesday4(ActionEvent event) throws IOException {
	if(Main.saveCustomer.palntrainer ==  null) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
	if(Main.saveCustomer.palntrainer.get(4).isEmpty()) {
		   Alert aler = new Alert(AlertType.WARNING);
			aler.setHeaderText("the manager still didnt build the plan");
			aler.showAndWait();	
			return;
	   }
	
	 Main.category="MB4";
	    Main.saveperviospage = "MB4day4";
	    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3DaysTrainig.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    
	    primaryStage.show();
			
}
public void back(ActionEvent event) throws IOException{
	 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("TrainingMainPage");
	    primaryStage.show();
}

}
