package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.HashMap;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageTraining implements Initializable {
	
	 
 

	 @FXML
	    private ComboBox<String> BudyGoal;
	 @FXML
	    private ComboBox<String> howManyDays;
	 @FXML
	 ListView<exercise> training;
	 @FXML
	 ComboBox<Integer> days;
	 
	 
	 @FXML
	    private Button backbtn;

	    @FXML
	    private Button addbtn;

	    @FXML
	    private Button removebtn;
	    @FXML
	    private Button showbtn;
	    @FXML
	    private Label title;

	 
	 @FXML
	    private MediaView ex1;
		
		MediaPlayer player;
	
	
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
		
		
		if(Main.savelangmanager.equals("English")) {
			title.setText("Manage Training");
			backbtn.setText("back");
			addbtn.setText("add");
			removebtn.setText("remove");
			showbtn.setText("Show");
			BudyGoal.setPromptText("Plan Type");
			howManyDays.setPromptText("howManyDays");
			days.setPromptText("Day number");
		}
        if(Main.savelangmanager.equals("Hebrew")) {
        	title.setText("ניהול אימונים");
			backbtn.setText("חזור");
			addbtn.setText("הוספה");
			removebtn.setText("מחיקה");
			BudyGoal.setPromptText("תוכנית");
			howManyDays.setPromptText("כמה ימים");
			days.setPromptText("איזה יום");
			showbtn.setText("הצגה");
		}
		
		
		
		
		training.setOnMouseClicked(event -> {
		    if (event.getClickCount() == 2) { // Check for double-click
		        exercise selectedExercise = training.getSelectionModel().getSelectedItem();
		        if (selectedExercise != null) {
		        	int Select = training.getSelectionModel().getSelectedIndex();
		    		exercise s= training.getItems().get(Select);
		    		Main.saveexercise =s;
		    		
		    		Stage newStage = new Stage();
		    	    Parent root;
		    	    try {
		    	        root = FXMLLoader.load(getClass().getResource("viewonetraining.fxml"));
		    	        Scene scene = new Scene(root, 300, 170);
		    	        Image icon = new Image("/Images/icon.png");
		    	        newStage.getIcons().add(icon);
		    	        newStage.setScene(scene);
		    	        newStage.show();
		    	    } catch (IOException e) {
		    	        e.printStackTrace();
		    	    }
		    	}
				   
		    		
		    	    
		        }
		    
		});
		
		
		training.setStyle("-fx-control-inner-background: lightgray;");
		
		ObservableList<String> list = FXCollections.observableArrayList("Muscle Building","Weight Loss");
		BudyGoal.setItems(list);
		ObservableList<String> list2 = FXCollections.observableArrayList("3 Days","4 Days","5 Days");
		howManyDays.setItems(list2);
		  
	}
	public void fillcombobox (ActionEvent event) throws IOException {
		if(howManyDays.getValue() == "3 Days") {
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3);
			days.setItems(list3);
		}
		if(howManyDays.getValue() == "4 Days") {
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3,4);
			days.setItems(list3);
		}
		if(howManyDays.getValue() == "5 Days") {
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3,4,5);
			days.setItems(list3);
		}
		
		
	}
	
	
	
	
	public void show(ActionEvent event) throws IOException {
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "3 Days" && days.getValue() ==1 ) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb3.get(1));
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "3 Days" && days.getValue() ==2 ) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb3.get(2));
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "3 Days" && days.getValue() ==3 ) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb3.get(3));
		}
		
		
		
		
		
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(1));	
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(2));	
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(3));	
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(4));	
		}
		
		
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(1));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(2));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(3));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(4));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==5) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(5));
				
		}
		
		
		
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl3.get(1));	
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl3.get(2));	
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl3.get(3));	
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(1));
		}	
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(2));
			
			
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(3));
			
			
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(4));
			
			
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(1));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(2));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(3));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(4));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==5) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(5));
		
		}
	}
	
	public void add(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("addexercise.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }
	public void remove(ActionEvent event) throws IOException{
		int Select = training.getSelectionModel().getSelectedIndex();
		 if(Main.gym.removeex((exercise)training.getItems().get(Select) ,BudyGoal.getValue() ,howManyDays.getValue() , days.getValue())) {
			 training.getItems().remove(Select);
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully remove");
			aler.showAndWait();
			}
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
	
	public void showEx(ActionEvent event) throws IOException{
		
		int Select = training.getSelectionModel().getSelectedIndex();
		
		
		exercise s= training.getItems().get(Select);
		
		Media media = new Media(getClass().getResource("/exercises/"+ s.getPath() ).toString());
		player = new MediaPlayer(media);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.setVolume(0.0);
		player.play();
		ex1.setMediaPlayer(player);
	 }
	

	
	
	
	
	}
	
	
	
	


