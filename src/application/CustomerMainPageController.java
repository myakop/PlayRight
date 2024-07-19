package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerMainPageController implements Initializable {
	
	 private final DropShadow dropShadow = new DropShadow();
	
	@FXML
	Label welcome;
	
	@FXML
	Button training;
	@FXML
	Button nutrition;
	
	@FXML
	Button findFriends;
	
	@FXML
	Button music, chat, questions;
	
	@FXML
    private ComboBox<String> lang;
	
	 @FXML
	 private Button btnback;
	

	
	
	 @FXML
	    private void onButtonMouseEntered(MouseEvent event) {
		 
		 Button button = (Button) event.getSource();
		 button.setStyle("-fx-background-color: black; -fx-text-fill: red;");
		 button.setEffect(dropShadow);
	    }
	    @FXML
	    private void onButtonMouseExited(MouseEvent event) {
	     Button button = (Button) event.getSource();
	     button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     button.setEffect(null);
	    }
	
	
	   public void gonutrition(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("nutritionMainPage.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   public void goTraining(ActionEvent event) throws IOException{
		   if(Main.saveCustomer.howmanydays == null) {
			 Parent root = FXMLLoader.load(getClass().getResource("TrainingMainPage.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		   }
		   else {
		   if(Main.saveCustomer.howmanydays.equals("3 Days")) {
				 Parent root = FXMLLoader.load(getClass().getResource("MuscleBuilding3Days.fxml"));
				 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
					Scene cn = new Scene(root);
					st.setScene(cn);
					st.show();
			   }
		   if(Main.saveCustomer.howmanydays.equals("4 Days")) {
				 Parent root = FXMLLoader.load(getClass().getResource("MuscleBuilding4Days.fxml"));
				 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
					Scene cn = new Scene(root);
					st.setScene(cn);
					st.show();
			   }
		   if(Main.saveCustomer.howmanydays.equals("5 Days")) {
				 Parent root = FXMLLoader.load(getClass().getResource("MuscleBuilding5Days.fxml"));
				 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
					Scene cn = new Scene(root);
					st.setScene(cn);
					st.show();
			   }
		   }
		}
	   public void findFreinds(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("joinFreinds.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
				
				if(Main.savelangCustomer.equals("English")) {
					Alert a=new Alert(AlertType.INFORMATION);
				       a.setHeaderText("The details you enter are shown to others for the purpose of finding partners");
				       a.showAndWait();
				}
				if(Main.savelangCustomer.equals("Hebrew")) {
					Alert a=new Alert(AlertType.INFORMATION);
				       a.setHeaderText("הפרטים שאתה מזין מוצגים לאחרים לצורך מציאת שותפים");
				       a.showAndWait();
				}
				 
		}
	   
	   public void viewMusic(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("viewMusic.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   
	   public void chat(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("clientChat.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   
	   public void QuestionsAndAnswers(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("QuestionsAndAnswers.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(Main.gym.getWaitingcustomers().toString());
		ObservableList<String> list = FXCollections.observableArrayList("English","Hebrew","العربية");
		lang.setItems(list);
		
		if(Main.savelangCustomer.equals("English")) {
			training.setText("Training");
			music.setText("Music");

			chat.setText("Chat");

			nutrition.setText("Nutrition");
			findFriends.setText("JoinFriends");
			questions.setText("Questions&Answers");
         welcome.setText("Welcome");
         btnback.setText("Back");
         lang.setValue("English");
			
		}
		 if(Main.savelangCustomer.equals("Hebrew")) {
			 training.setText("אימונים");
				music.setText("מוזיקה");

				chat.setText("צ'אט");

				nutrition.setText("תזונה");
				findFriends.setText("עם חברים");
				questions.setText("שאלות ותשובות");
	         welcome.setText("ברוך הבא");
	         btnback.setText("חזור");
	         lang.setValue("Hebrew");
			
		}
		 if(Main.savelangCustomer.equals("العربية")) {
			 training.setText("تدريبات");
				music.setText("اغاني");

				chat.setText("محادثه");

				nutrition.setText("وجبات واكل");
				findFriends.setText("مع الاصدقاء");
				questions.setText("أسئلة وأجوبة");
	         welcome.setText("اهلا وسهلا");
	         btnback.setText("رجوع");
	         lang.setValue("العربية");
			
		}


	     training.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     nutrition.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     findFriends.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     music.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     chat.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	     questions.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	          
	
	}
	
public void changelang(ActionEvent event) throws IOException {
		
		Main.savelangCustomer = lang.getValue();
		
		if(Main.savelangCustomer.equals("English")) {
			training.setText("Training");
			music.setText("Music");

			chat.setText("Chat");

			nutrition.setText("Nutrition");
			findFriends.setText("JoinFriends");
			questions.setText("Questions&Answers");
         welcome.setText("Welcome");
         btnback.setText("back");
         lang.setValue("English");
			
		}
		 if(Main.savelangCustomer.equals("Hebrew")) {
			 training.setText("אימונים");
				music.setText("מוזיקה");

				chat.setText("צ'אט");

				nutrition.setText("תזונה");
				findFriends.setText("עם חברים");
				questions.setText("שאלות ותשובות");
	         welcome.setText("ברוך הבא");
	         btnback.setText("חזור");
	         lang.setValue("Hebrew");
			
		}
		 if(Main.savelangCustomer.equals("العربية")) {
			 training.setText("تدريبات");
				music.setText("اغاني");

				chat.setText("محادثه");

				nutrition.setText("وجبات واكل");
				findFriends.setText("مع الاصدقاء");
				questions.setText("أسئلة وأجوبة");
	         welcome.setText("اهلا وسهلا");
	         btnback.setText("رجوع");
	         lang.setValue("العربية");
			
		}
	
	
}
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("LogInWithVideo.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("LogIn");
		    primaryStage.show();
	 }

}
