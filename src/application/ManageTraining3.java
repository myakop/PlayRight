package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
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

public class ManageTraining3 implements Initializable {
	 @FXML
	 ListView<exercise> training;
	 
	 HashMap<String,exercise> exat;
	 @FXML
	 ComboBox<Integer> days;

	    @FXML
	    private ComboBox<String> ex2;
	 
	 
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
		
		
		public void fillcombobox (ActionEvent event) throws IOException {
			if(days.getValue() == 1) {
				training.getItems().clear();
				training.getItems().addAll(Main.savecustomerforplan.getPalntrainer().get(1));
			}
			if(days.getValue() == 2) {
				training.getItems().clear();
				training.getItems().addAll(Main.savecustomerforplan.getPalntrainer().get(2));
			}
			if(days.getValue() == 3) {
				training.getItems().clear();
				training.getItems().addAll(Main.savecustomerforplan.getPalntrainer().get(3));
			}
			if(days.getValue() == 4) {
				training.getItems().clear();
				training.getItems().addAll(Main.savecustomerforplan.getPalntrainer().get(4));
			}
			if(days.getValue() == 5) {
				training.getItems().clear();
				training.getItems().addAll(Main.savecustomerforplan.getPalntrainer().get(5));
			}
			
			
		}
		
		
		public void pop (ActionEvent event) throws IOException {
			if(ex2.getValue().equals("Loss")) {
				exat = new HashMap<>();
				 exercise ex1 = new exercise("plank","loss1.mp4","12X5"); 
				 exercise ex2 = new exercise("climbers","loss10.mp4","12X5"); 
				 exercise ex3 = new exercise("lungers","loss11.mp4","12X5"); 
				 exercise ex4 = new exercise("skipping","loss12.mp4","12X5"); 
				 exercise ex5 = new exercise("burpees","loss13.mp4","12X5"); 
				 exercise ex6 = new exercise("cycling","loss14.mp4","12X5"); 
				 exat.put("plank", ex1);
				 exat.put("climbers", ex2);
				 exat.put("lungers", ex3);
				 exat.put("skipping", ex4);
				 exat.put("burpees", ex5);
				 exat.put("cycling", ex6);
				
			}
			if(ex2.getValue().equals("Chest")) {
				exat = new HashMap<>();
				 exercise ex1 = new exercise("chessOpen","chessOpen1.mp4","12X5"); 
				 exercise ex2 = new exercise("chestLow","chestLow.mp4","12X5"); 
				 exercise ex3 = new exercise("chestLow2","chestLow2.mp4","12X5"); 
				 exercise ex4 = new exercise("chestPress1","chestPress1.mp4","12X5"); 
				 exercise ex5 = new exercise("chestPress2","chestPress2.mp4","12X5"); 
				 exercise ex6 = new exercise("chestReg","chestReg.mp4","12X5"); 
				 exat.put("chessOpen", ex1);
				 exat.put("chestLow", ex2);
				 exat.put("chestLow2", ex3);
				 exat.put("chestPress1", ex4);
				 exat.put("chestPress2", ex5);
				 exat.put("chestReg", ex6);
				
				
			}
			
			if(ex2.getValue().equals("Bi")) {
				exat = new HashMap<>();
				 exercise ex1 = new exercise("long bi","bi1.mp4","12X5"); 
				 exercise ex2 = new exercise("short bi","bi2.mp4","12X5"); 
				 exercise ex3 = new exercise("over bi","bi3.mp4","12X5"); 
				 exercise ex4 = new exercise("dambels bi","bi4.mp4","12X5"); 
				 exercise ex5 = new exercise("bar bi","bi5.mp4","12X5"); 
				 exercise ex6 = new exercise("Wbar bi","bi6.mp4","12X5"); 
				 exat.put("long bi", ex1);
				 exat.put("short bi", ex2);
				 exat.put("over bi", ex3);
				 exat.put("dambels bi", ex4);
				 exat.put("bar bi", ex5);
				 exat.put("Wbar bi", ex6);
			}
			if(ex2.getValue().equals("Back")) {
				exat = new HashMap<>();
				 exercise ex1 = new exercise("7tera","back2.mp4","12X5"); 
				 exercise ex2 = new exercise("pull up","back3.mp4","12X5"); 
				 exercise ex3 = new exercise("meth","back4.mp4","12X5"); 
				 exercise ex4 = new exercise("down lats","back5.mp4","12X5"); 
				 exercise ex5 = new exercise("pull over","back6.mp4","12X5"); 
				 exercise ex6 = new exercise("up lats","back7.mp4","12X5"); 
				 exat.put("pull up2", ex1);
				 exat.put("pull up", ex2);
				 exat.put("meth", ex3);
				 exat.put("down lats", ex4);
				 exat.put("pull over", ex5);
				 exat.put("up lats", ex6);
				
			}
			if(ex2.getValue().equals("Leg")) {
				exat = new HashMap<>();
				
				 exercise ex1 = new exercise("squat","leg1.mp4","12X5"); 
				 exercise ex2 = new exercise("squat bar","leg10.mp4","12X5"); 
				 exercise ex3 = new exercise("hamstreng","leg2.mp4","12X5"); 
				 exercise ex4 = new exercise("hamstreng2","leg3.mp4","12X5"); 
				 exercise ex5 = new exercise("leg press","leg4.mp4","12X5"); 
				 exercise ex6 = new exercise("leg press2","leg5.mp4","12X5"); 
				 exat.put("squat", ex1);
				 exat.put("squat bar", ex2);
				 exat.put("hamstreng", ex3);
				 exat.put("hamstreng2", ex4);
				 exat.put("leg press", ex5);
				 exat.put("leg press2", ex6);	
				
			}
			if(ex2.getValue().equals("shoulder")) {
				exat = new HashMap<>();
				
				exercise ex1 = new exercise("front shoulder","sh1.mp4","12X5"); 
				 exercise ex2 = new exercise("side shoulder","sh2.mp4","12X5"); 
				 exercise ex3 = new exercise("back shoulder","sh3.mp4","12X5"); 
				 exercise ex4 = new exercise("trapies","sh4.mp4","12X5"); 
				 exercise ex5 = new exercise("over shoulder","sh5.mp4","12X5"); 
				 exercise ex6 = new exercise("burber","sh6.mp4","12X5"); 
				 exat.put("front shoulder", ex1);
				 exat.put("side shoulder", ex2);
				 exat.put("back shoulder", ex3);
				 exat.put("trapies", ex4);
				 exat.put("over shoulder", ex5);
				 exat.put("burber", ex6);	
				
			}
			if(ex2.getValue().equals("tri")) {
				exat = new HashMap<>();
				
				exercise ex1 = new exercise("short head","tri1.mp4","12X5"); 
				 exercise ex2 = new exercise("long head","tri2.mp4","12X5"); 
				 exercise ex3 = new exercise("dambels","tri3.mp4","12X5"); 
				 exercise ex4 = new exercise("bar","tri4.mp4","12X5"); 
				 exercise ex5 = new exercise("bench","tri5.mp4","12X5"); 
				 exercise ex6 = new exercise("bar2","tri6.mp4","12X5"); 
				 exat.put("short head", ex1);
				 exat.put("long head", ex2);
				 exat.put("dambels", ex3);
				 exat.put("bar", ex4);
				 exat.put("bench", ex5);
				 exat.put("bar2", ex6);
	
			}
			
			
			
			if(days.getValue() == null) {
				 Alert aler = new Alert(AlertType.CONFIRMATION);
					aler.setHeaderText("First choose the day");
					aler.showAndWait();	
					return;
			}
			Main.savetheday = days.getValue();
			Dialog<ButtonType> dialog = new Dialog<>();
	        dialog.setTitle("Custom Dialog");
	        dialog.setHeaderText("add exercise");

	        // Create ToggleGroup for radio buttons
	        
	        GridPane grid = new GridPane();
	        int i =0;
	        int row = 0;
	        for (String s : exat.keySet()) {
	            CheckBox checkBox = new CheckBox(s);
	            grid.add(checkBox, 0, row);
	            row++;
	        }


	        dialog.getDialogPane().setContent(grid);

	        // Add OK and Cancel buttons
	        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
	        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
	        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

	        // Handle OK button action
	        dialog.setResultConverter(buttonType -> {
	            if (buttonType == okButton) {
	                // Handle the selected radio button
	            	processSelectedOptions(grid);
	            	try {
						fillcombobox(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	                
	            }
	            return null;
	        });

	        dialog.showAndWait();

			
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> list = FXCollections.observableArrayList("Leg","Back" ,"Bi","Chest","Loss" ,"shoulder", "tri");
		ex2.setItems(list);
		
		
		
		 
		if(Main.savelangmanager.equals("English")) {
			title.setText(Main.savecustomerforplan.getUserName() + " paln");
			backbtn.setText("back");
			addbtn.setText("add");
			removebtn.setText("remove");
			showbtn.setText("Show");
			days.setPromptText("Day number");
		}
        if(Main.savelangmanager.equals("Hebrew")) {
        	title.setText("ניהול אימונים");
			backbtn.setText("חזור");
			addbtn.setText("הוספה");
			removebtn.setText("מחיקה");
			days.setPromptText("איזה יום");
			showbtn.setText("הצגה");
		}
        if(Main.savelangmanager.equals("العربية")) {
        	title.setText("اداره التدريبات");
			backbtn.setText("رجوع");
			addbtn.setText("اضافه");
			removebtn.setText("محي");
			days.setPromptText("اليوم");
			showbtn.setText("عرض");
		}
        
        if(Main.savecustomerforplan.howmanydays.equals("3 Days")) {
        	for(int i=1 ; i<4 ; i++ ) {
        		 ArrayList<exercise> exerciseList = Main.savecustomerforplan.getPalntrainer().get(i);
        		 if (exerciseList == null) {
        		     exerciseList = new ArrayList<>();
        		     Main.savecustomerforplan.getPalntrainer().put(i, exerciseList);
        		
        	}
        	}
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3);
			days.setItems(list3);
		
        }
		if(Main.savecustomerforplan.howmanydays.equals("4 Days")) {
			for(int i=1 ; i<5 ; i++ ) {
       		 ArrayList<exercise> exerciseList = Main.savecustomerforplan.getPalntrainer().get(i);
       		 if (exerciseList == null) {
       		     exerciseList = new ArrayList<>();
       		     Main.savecustomerforplan.getPalntrainer().put(i, exerciseList);
       		
       		 }
			}
		
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3,4);
			days.setItems(list3);
			
		}
		if(Main.savecustomerforplan.howmanydays.equals("5 Days")) {
			
			for(int i=1 ; i<6 ; i++ ) {
	       		 ArrayList<exercise> exerciseList = Main.savecustomerforplan.getPalntrainer().get(i);
	       		 if (exerciseList == null) {
	       		     exerciseList = new ArrayList<>();
	       		     Main.savecustomerforplan.getPalntrainer().put(i, exerciseList);
	       		
	       		 }
				}
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3,4,5);
			days.setItems(list3);
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
		
		  
	}
	
	public void add(ActionEvent event) throws IOException{
	 	Main.savetheday = days.getValue();
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("addexercise.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }
	
	public void show(ActionEvent event) throws IOException{
		if(days.getValue() == null) {
			 Alert aler = new Alert(AlertType.CONFIRMATION);
				aler.setHeaderText("First choose the day");
				aler.showAndWait();	
				return;
		}
		Main.savetheday = days.getValue();
		Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Custom Dialog");
        dialog.setHeaderText("add exercise");

        // Create ToggleGroup for radio buttons
        
        GridPane grid = new GridPane();
        int i =0;
        int row = 0;
        for (String s : exat.keySet()) {
            CheckBox checkBox = new CheckBox(s);
            grid.add(checkBox, 0, row);
            row++;
        }


        dialog.getDialogPane().setContent(grid);

        // Add OK and Cancel buttons
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

        // Handle OK button action
        dialog.setResultConverter(buttonType -> {
            if (buttonType == okButton) {
                // Handle the selected radio button
            	processSelectedOptions(grid);
            	try {
					fillcombobox(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
                
            }
            return null;
        });

        dialog.showAndWait();
	 }
	
	
	private void processSelectedOptions(GridPane grid) {
        for (int i = 0; i < grid.getChildren().size(); i++) {
            if (grid.getChildren().get(i) instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) grid.getChildren().get(i);
                if (checkBox.isSelected()) {
                	exercise ex1 = exat.get(checkBox.getText());
                	Main.savecustomerforplan.getPalntrainer().get(Main.savetheday).add(ex1);
                	Main.update();
                    // You can perform any action based on the selected options here
                }
            }
        }
    }
	
	
	public void remove(ActionEvent event) throws IOException{
		int Select = training.getSelectionModel().getSelectedIndex();
		training.getItems().remove(Select);
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully remove");
			aler.showAndWait();
			
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
	
	
	
	


