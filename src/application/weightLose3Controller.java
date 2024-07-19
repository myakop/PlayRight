package application;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class weightLose3Controller implements Initializable {



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		
	}
	
	
public void goToexercisesday1(ActionEvent event) throws IOException {
	
	    Main.category="WL3";	
	    Main.saveperviospage = "WL3day1";
	    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3DaysTrainig.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    
	    primaryStage.show();
			
}
public void goToexercisesday2(ActionEvent event) throws IOException {
	
    Main.category="WL3";	
    Main.saveperviospage = "WL3day2";
    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3DaysTrainig.fxml"));
    Scene scene = new Scene(root,800,466);
    Image icon = new Image("/Images/icon.png");
    primaryStage.getIcons().add(icon);
    primaryStage.setScene(scene);
    
    primaryStage.show();
		
}
public void goToexercisesday3(ActionEvent event) throws IOException {
	
    Main.category="WL3";	
    Main.saveperviospage = "WL3day3";
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
	    Parent root = FXMLLoader.load(getClass().getResource("TrainingMainPage.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("TrainingMainPage");
	    primaryStage.show();
}

}
