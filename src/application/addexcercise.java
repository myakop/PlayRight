package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class addexcercise implements Initializable {
	
	@FXML
	TextField name, path , desc;
	
	    
	    @FXML
	    private Label path2;
	    @FXML
	    private Label name2;
	    @FXML
	    private Button backbtn;
	    @FXML
	    private Label title;
	    @FXML
	    private Button sumbitbtn;
	    @FXML
	    private Label desc2;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(Main.savelangmanager.equals("English")) {
			name2.setText("Name");
			path2.setText("path");
			desc2.setText("Desc");
			sumbitbtn.setText("Submit");
			backbtn.setText("Back");
			title.setText("Add excercise");
			
			
        
			
		}
		 if(Main.savelangmanager.equals("Hebrew")) {
			  name2.setText("שם");
			  path2.setText("נָתִיב");
			  desc2.setText("תיאור");
			  sumbitbtn.setText("אישור");
			  backbtn.setText("חזור");
			  title.setText("הוספת תרגיל");
			 
	
		
	}
		 if(Main.savelangmanager.equals("العربية")) {
			  name2.setText("اسم");
			  path2.setText("مسار");
			  desc2.setText("وصف");
			  sumbitbtn.setText("موافقة");
			  backbtn.setText("رجوع");
			  title.setText("اضافه التمرين");
			 
	
		
	}
		
		
		
	}
	
	
	
	
	
	
	
	public void submitaddex (ActionEvent event) throws IOException {
			
		exercise ex = new exercise(name.getText(),path.getText() , desc.getText());
		Main.savecustomerforplan.getPalntrainer().get(Main.savetheday).add(ex);
		Main.update();
	//	Main.gym.addex(ex, type.getValue(),day.getValue());
		
	//System.out.println(Main.gym.mb3.values());
		Main.update();
		
			
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
		    Parent root = FXMLLoader.load(getClass().getResource("ManageTraining3.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }


	

}
