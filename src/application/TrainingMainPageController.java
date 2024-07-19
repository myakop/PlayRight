package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TrainingMainPageController implements Initializable {
	
	 
	 @FXML
	    private Label title;

	    @FXML
	    private Label goal;


	    @FXML
	    private Label days;

	    @FXML
	    private Button plan;

	    @FXML
	    private Button btnback;

	    @FXML
	    private TextField height;

	    @FXML
	    private TextField weight;


	 @FXML
	    private ComboBox<String> BudyGoal;
	 @FXML
	    private ComboBox<String> howManyDays;
	
	 
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(Main.savelangCustomer.equals("English")) {
			title.setText("What is your goal ?");
			btnback.setText("Back");

			goal.setText("your goal");

			days.setText("How many days");
			plan.setText("workout plan");
			
			
		}
		 if(Main.savelangCustomer.equals("Hebrew")) {
			 title.setText("מה המטרה שלך ?");
				btnback.setText("חזור");

				goal.setText("המטרה שלך");

				days.setText("כמה ימים בשבוע");
				plan.setText("תן תוכנית");
			
		}
		
		
		ObservableList<String> list = FXCollections.observableArrayList("Muscle Building","Weight Loss");
		BudyGoal.setItems(list);
		ObservableList<String> list2 = FXCollections.observableArrayList("3 Days","4 Days","5 Days");
		howManyDays.setItems(list2);
	   
	}
	
	
	public void goToPlan(ActionEvent event) throws IOException {
		
		Main.saveCustomer.goal = BudyGoal.getValue();
		Main.saveCustomer.howmanydays = howManyDays.getValue();
		Main.saveCustomer.saveHeight = Double.parseDouble(height.getText());
		Main.saveCustomer.saveWeight = Double.parseDouble(weight.getText());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Main.saveCustomer.wieghts2.put(LocalDate.now(), Double.parseDouble(weight.getText()));
		Main.saveCustomer.wieghts.add(Double.parseDouble(weight.getText()));
		
		
		Main.gym.getWaitingcustomers().add(Main.saveCustomer);
		 Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("Your application has been successfully registered, it is forwarded to the coach so that he can build you a suitable program");
			aler.showAndWait();	
		Main.update();
		Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
	    Scene scene = new Scene(root,800,466);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}
	
	
	
	/*
	public void goToPlan(ActionEvent event) throws IOException {
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "3 Days") {
			Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("MuscleBuilding3Days.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setTitle("Time To Training");
		    primaryStage.setScene(scene);
		    primaryStage.show();
			
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days") {
			Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("MuscleBuilding4Days.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setTitle("Time To Training");
		    primaryStage.setScene(scene);
		    primaryStage.show();
			
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days") {
			
				Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
			    Parent root = FXMLLoader.load(getClass().getResource("MuscleBuilding5Days.fxml"));
			    Scene scene = new Scene(root,800,466);
			    Image icon = new Image("/Images/icon.png");
			    primaryStage.getIcons().add(icon);
			    primaryStage.setTitle("Time To Training");
			    primaryStage.setScene(scene);
			    primaryStage.show();
			
			
		}
		
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days") {
			
				
				Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
			    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3Days.fxml"));
			    Scene scene = new Scene(root,800,466);
			    Image icon = new Image("/Images/icon.png");
			    primaryStage.getIcons().add(icon);
			    primaryStage.setTitle("Time To Training");
			    primaryStage.setScene(scene);
			    primaryStage.show();
			
		}	
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days") {
			
				
				Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
			    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose4Days.fxml"));
			    Scene scene = new Scene(root,800,466);
			    Image icon = new Image("/Images/icon.png");
			    primaryStage.getIcons().add(icon);
			    primaryStage.setTitle("Time To Training");
			    primaryStage.setScene(scene);
			    primaryStage.show();	
			
		}	
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days") {
		
				Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
			    Parent root = FXMLLoader.load(getClass().getResource("wieghtLose5Days.fxml"));
			    Scene scene = new Scene(root,800,466);
			    Image icon = new Image("/Images/icon.png");
			    primaryStage.getIcons().add(icon);
			    primaryStage.setTitle("Time To Training");
			    primaryStage.setScene(scene);
			    primaryStage.show();
			
		}	
	}
	*/
	
	public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }
	
	
	
	
	
	}
	
	
	
	


