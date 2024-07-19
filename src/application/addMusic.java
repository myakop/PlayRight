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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class addMusic implements Initializable {
	
	@FXML
    private Button backbtn;
    @FXML
    private Label title;
    @FXML
    private Button sumbitbtn;
    @FXML
    private Label path2;

    @FXML
    private Label name2;
    @FXML
	TextField name, path;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Main.savelangmanager.equals("English")) {
			name2.setText("Name");
			path2.setText("path");
			
			sumbitbtn.setText("Submit");
			backbtn.setText("Back");
			title.setText("Add Meal");
			
        
			
		}
		 if(Main.savelangmanager.equals("Hebrew")) {
			  name2.setText("שם");
			  path2.setText("נָתִיב");
			  sumbitbtn.setText("אישור");
			  backbtn.setText("חזור");
			  title.setText("הוספת ארוחה");
		
		// TODO Auto-generated method stub
		
	}
	}
	
	
	
	
	
	public void submitaddMusic (ActionEvent event) throws IOException {
			
		music music = new music(name.getText(),path.getText());
		
		
		checkid(music);
		if(Main.gym.addMusic(music)) {
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully add");
			aler.showAndWait();	
			
				}
			
		}
	
	
	public void checkid(music music) {
		int x=0;
		for(int c : Main.gym.getMusic().keySet()) {
			if(c>x)
				x=c;
		}
		music.setId(x+1);
		return;
	}
	
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("ManageMusic.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("ManageMusic");
		    primaryStage.show();
	 }


	

}
