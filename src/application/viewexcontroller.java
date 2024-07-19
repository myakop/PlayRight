package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class viewexcontroller implements Initializable {
	
	
	 @FXML
	    private MediaView ex1;
		
		MediaPlayer player;
	
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Media media = new Media(getClass().getResource("/exercises/"+ Main.saveexercise.getPath() ).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);


	   
	          
	
	}
	
	
	
	
	 

}
