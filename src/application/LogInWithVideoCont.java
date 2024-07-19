package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
public class LogInWithVideoCont implements Initializable {
	
	@FXML
	private MediaView mediaView;
	
	@FXML 
	private Label lblStatus;
	
	@FXML 
	private TextField userNameText;
	
	@FXML 
	private PasswordField passwordText;
	
	@FXML 
	private Slider controlVolume;

	/* adding a video to be a background for login page */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Main.saveCustomer=null;
		
		if(Main.saveMediaPlayer != null) {
			Main.saveMediaPlayer.stop();
		}
		
		Media media = new Media(getClass().getResource("/Images/videoBackgroundGym2.mp4").toString());
		MediaPlayer player = new MediaPlayer(media);
		Main.saveMediaPlayer = player;
		mediaView.setMediaPlayer(Main.saveMediaPlayer);
		Main.saveMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		Main.saveMediaPlayer.setVolume(0.1);
		Main.saveMediaPlayer.play();
		controlVolume.setValue(Main.saveMediaPlayer.getVolume() * 100);
		controlVolume.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				
				Main.saveMediaPlayer.setVolume(controlVolume.getValue() / 100);
				
			}
			
			
		});
		
	}
	
	
	/* Check if it's a manager or a client and everything's fine  */
    public void Login(ActionEvent event) throws IOException {
		
    	
		if(userNameText.getText().equals("manager") && passwordText.getText().equals("manager")) {
			lblStatus.setText("Login Success");
			Main.saveMediaPlayer.setVolume(0);
			Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
			Scene scene = new Scene(root,800,466);
			Image icon = new Image("/Images/icon.png");
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manager screen");
			primaryStage.show();
		}
		else {
			for(Customer cust : Main.gym.getCustomers().values()) {
				
				if((userNameText.getText() != "") && (passwordText.getText() != "") && cust.getUserName().equals(userNameText.getText())&&cust.getPassword().equals(passwordText.getText())){
					
					Main.saveCustomer=cust;
					Main.saveMediaPlayer.setVolume(0);
					Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
					Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
					Scene scene = new Scene(root,800,466);
					Image icon = new Image("/Images/icon.png");
					primaryStage.getIcons().add(icon);
					primaryStage.setScene(scene);
					primaryStage.setTitle("Customer screen");
					primaryStage.show();
					long daysBetween = ChronoUnit.DAYS.between(Main.saveCustomer.getDate(),LocalDate.now());
					if(daysBetween >= 1) {
					showpopup();
					}
					
				}
				else {
					lblStatus.setText("Login Failed");
				}
			}
		
		}
		
	}
	
     /* go to sign up screen */
     public void SignUp(ActionEvent event) throws IOException{
    	Main.saveMediaPlayer.setVolume(0);
	    Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
	    Scene scene = new Scene(root,700,620);
	    Image icon = new Image("/Images/icon.png");
	    primaryStage.getIcons().add(icon);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("SignUp");
	    primaryStage.show();
    }
     
     public void showpopup() {
    	    Stage popupStage = new Stage();
    	    popupStage.initModality(Modality.APPLICATION_MODAL); // Block interactions with the parent stage
    	    popupStage.setTitle("Feedback");

    	    // Create input fields and labels
    	    TextField weightInput = new TextField();
    	    weightInput.setPromptText("Enter Weight");

    	    TextField feedbackInput = new TextField();
    	    feedbackInput.setPromptText("Enter Feedback");

    	    // Create a submit button
    	    Button submitButton = new Button("Submit");
    	    submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Green button
    	    submitButton.setAlignment(Pos.CENTER);

    	    submitButton.setOnAction(e -> {
    	        double weight;
    	        weight = Double.parseDouble(weightInput.getText());
    	        Main.saveCustomer.setDiff(weight - Main.saveCustomer.getWieght());
    	        Main.saveCustomer.setFedback(feedbackInput.getText());
    	        Main.saveCustomer.setWieght(weight);
    	        Main.saveCustomer.setDate(LocalDate.now());
    	        Main.saveCustomer.wieghts.add(weight);
    	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	   		Main.saveCustomer.wieghts2.put((LocalDate.now()),weight);
    	        Main.update();
    	        popupStage.close();
    	    });

    	    // Create labels for input fields
    	    Label weightLabel = new Label("Weight:");
    	   
    	    Label feedbackLabel = new Label("Feedback:");

    	    // Set styles for labels
    	    weightLabel.setStyle("-fx-font-size: 14; -fx-font-style: italic;");
    	    feedbackLabel.setStyle("-fx-font-size: 14; -fx-font-style: italic;");


    	 // Create a VBox to arrange components vertically
    	    VBox layout = new VBox(10);
    	    layout.setStyle("-fx-background-color: #F5F5F5; -fx-padding: 10px; -fx-spacing: 10px;"); // Light gray background
    	    layout.setMinWidth(300);
    	    layout.setMinHeight(190);

    	    // Center the VBox content
    	    //layout.setAlignment(Pos.CENTER);


    	    // Add components to the VBox
    	    layout.getChildren().addAll(
    	        weightLabel, weightInput,
    	        feedbackLabel, feedbackInput,
    	        submitButton
    	    );

    	    // Create the scene
    	    Scene popupScene = new Scene(layout);
    	    popupStage.setScene(popupScene);
    	    Image icon = new Image("/Images/icon.png");
    	    popupStage.getIcons().add(icon);
    	    popupStage.showAndWait();
    	    
    	}

	

}
