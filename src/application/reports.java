package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class reports implements Initializable {
	
	
	 @FXML
	    private Button genders;

	    @FXML
	    private Button ages;

	    @FXML
	    private Button backs;
	
	 public void gender(ActionEvent event) throws IOException{
		 Parent root = FXMLLoader.load(getClass().getResource("data.fxml"));
		 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene cn = new Scene(root);
			st.setScene(cn);
			st.show();
	}
   public void godata(ActionEvent event) throws IOException{
		 Parent root = FXMLLoader.load(getClass().getResource("usersdata.fxml"));
		 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene cn = new Scene(root);
			st.setScene(cn);
			st.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Main.savelangmanager.equals("English")) {
			
         backs.setText("back");
         genders.setText("Gender");
         ages.setText("Ages");
    
			
		}
		 if(Main.savelangmanager.equals("Hebrew")) {
		
			 backs.setText("חזור");
			 genders.setText("מין");
	         ages.setText("גיל");
			 
			
		}
		 if(Main.savelangmanager.equals("العربية")) {
				
			 backs.setText("رجوع");
			 genders.setText("جنس");
	         ages.setText("عمر");
			 
			
		}
		
		
		// TODO Auto-generated method stub
		
	}
	
	public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }

}
