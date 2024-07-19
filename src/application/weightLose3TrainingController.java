package application;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class weightLose3TrainingController implements Initializable {
	
	/**
	 * 
	 */

	
	@FXML
    private Label numberOfEx;
	 @FXML
	    private Label desc;
	int x=0;
	int y=0;
	
	
	
	
	ArrayList<exercise> workedone = new ArrayList<exercise>();
	
	@FXML
    private MediaView ex1;
	
	MediaPlayer player;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	numberOfEx.setText("excercise 0/" );
		
		
		
		

		
	if(Main.saveperviospage == "MB3day1") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(1));	
	}
	if(Main.saveperviospage == "MB3day2") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(2));	
	}
	if(Main.saveperviospage == "MB3day3") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(3));	
	}
	
	
	
	if(Main.saveperviospage == "MB4day1") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(1));	
	}
	if(Main.saveperviospage == "MB4day2") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(2));	
	}
	if(Main.saveperviospage == "MB4day3") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(3));	
	}
	if(Main.saveperviospage == "MB4day4") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(4));	
	}
	
	
	
	if(Main.saveperviospage == "MB5day1") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(1));	
	}
	if(Main.saveperviospage == "MB5day2") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(2));	
	}
	if(Main.saveperviospage == "MB5day3") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(3));	
	}
	if(Main.saveperviospage == "MB5day4") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(4));	
	}
	if(Main.saveperviospage == "MB5day5") {
		workedone.clear();
		workedone.addAll(Main.saveCustomer.palntrainer.get(5));	
	}
	
	
	
	/*
	if(Main.saveperviospage == "WL3day1") {
		workedone.clear();
		workedone.addAll(Main.gym.wl3.get(1));
	}
	if(Main.saveperviospage == "WL3day2") {
		workedone.clear();
		workedone.addAll(Main.gym.wl3.get(2));
	}
	if(Main.saveperviospage == "WL3day3") {
		workedone.clear();
		workedone.addAll(Main.gym.wl3.get(3));
	}
	
	
	if(Main.saveperviospage == "WL4day1") {
		workedone.clear();
		workedone.addAll(Main.gym.wl4.get(1));
	}
	if(Main.saveperviospage == "WL4day2") {
		workedone.clear();
		workedone.addAll(Main.gym.wl4.get(2));
	}
	if(Main.saveperviospage == "WL4day3") {
		workedone.clear();
		workedone.addAll(Main.gym.wl4.get(3));
	}
	if(Main.saveperviospage == "WL4day4") {
		workedone.clear();
		workedone.addAll(Main.gym.wl4.get(3));
	}
	
	
	
	
	
	
	if(Main.saveperviospage == "WL5day1") {
		workedone.clear();
		workedone.addAll(Main.gym.wl5.get(1));
	}
	if(Main.saveperviospage == "WL5day2") {
		workedone.clear();
		workedone.addAll(Main.gym.wl5.get(2));
	}
	if(Main.saveperviospage == "WL5day3") {
		workedone.clear();
		workedone.addAll(Main.gym.wl5.get(3));
	}
	if(Main.saveperviospage == "WL5day4") {
		workedone.clear();
		workedone.addAll(Main.gym.wl5.get(4));
	}
	if(Main.saveperviospage == "WL5day5") {
		workedone.clear();
		workedone.addAll(Main.gym.wl5.get(5));
	}
	
	*/
	
	 y = x+1;
	
	 numberOfEx.setText("excercise "+ y + "/" + workedone.size());
	
	  String firstone = workedone.get(0).path;
	    desc.setText(workedone.get(0).desc);
	    
		Media media = new Media(getClass().getResource("/exercises/"+firstone ).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);
		
		
	
		
	
	}
	
	public void next(ActionEvent event) throws IOException {
		

		x++;
		if(x == workedone.size()) {
			x=0;
		}
		y=x+1;
		 numberOfEx.setText("excercise "+ y + "/" + workedone.size());
		String worked = workedone.get(x).path;
		
		desc.setText(workedone.get(x).desc);
		Media media = new Media(getClass().getResource("/exercises/" +worked).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);
	}
public void back1(ActionEvent event) throws IOException {
	
	if(x>0) {
		x--;
		y=x+1;
	}
	 numberOfEx.setText("excercise "+ y + "/" + workedone.size());

	   String worked = workedone.get(x).path;
	   desc.setText(workedone.get(x).desc);
		Media media = new Media(getClass().getResource("/exercises/"+worked).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);
	}


public void back(ActionEvent event) throws IOException{
	String page ="";
	
	if(Main.category == "WL3") {
		page="wieghtLose3Days.fxml";
	}
	if(Main.category == "WL4") {
		page="wieghtLose4Days.fxml";
	}
	if(Main.category == "WL5") {
		page="wieghtLose5Days.fxml";
	}
	if(Main.category == "MB3") {
		page="MuscleBuilding3Days.fxml";
	}
	if(Main.category == "MB4") {
		page="MuscleBuilding4Days.fxml";
	}
	if(Main.category == "MB5") {
		page="MuscleBuilding5Days.fxml";
	}
	 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource(page));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	   
	    primaryStage.show();
}
	
	
	

}
