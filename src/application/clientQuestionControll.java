package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class clientQuestionControll implements Initializable {
    @FXML
    private TextArea viewChat;

    @FXML
    private TextField clientMessage;

    @FXML
    private Button sendbtn;
    
    @FXML
    private VBox labelContainer;


    
    @FXML
    private void sendMessage(ActionEvent event) {
        String text = clientMessage.getText();
        
        String name;
        if(Main.saveCustomer!=null) {
        	name= Main.saveCustomer.getUserName();
        }
        else {
        	name= "manager";
        }

        // Create a new label with the entered text
        Label newLabel = new Label(name+": "+ text);
        

        Question q= new Question(text, name);
        Main.gym.addQuestion(q);
        Main.update();
        Main.saveQuestion=q;
        newLabel.setOnMouseClicked(e -> {
        	Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("showAnswers.fxml"));
				Scene scene = new Scene(root,800,466);
			    Image icon = new Image("/Images/icon.png");
			    primaryStage.getIcons().add(icon);
			    primaryStage.setScene(scene);
			    primaryStage.setTitle("manager");
			    primaryStage.show();
			    
			    
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
        	
        });

        // Add the new label to the container
        labelContainer.getChildren().add(newLabel);
        
        newLabel.setStyle("-fx-font-size: 16; -fx-underline: true; -fx-font-weight: bold; -fx-text-fill: blue; -fx-font-style: italic;");
       
        // Add a horizontal line (separator) between the labels
        Separator separator = new Separator();
        separator.setPrefWidth(200); // Set the desired width for the separator
        labelContainer.getChildren().add(separator);
        
        newLabel.setWrapText(true);
       

        // Clear the text field
        clientMessage.clear();
    }
    	
    
    
    public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		 
		 if(Main.saveCustomer == null) {
			   Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
			    Scene scene = new Scene(root,800,466);
			    Image icon = new Image("/Images/icon.png");
			    primaryStage.getIcons().add(icon);
			    primaryStage.setScene(scene);
			    primaryStage.setTitle("manager");
			    primaryStage.show();
		 }else {
			  Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
			    Scene scene = new Scene(root,800,466);
			    Image icon = new Image("/Images/icon.png");
			    primaryStage.getIcons().add(icon);
			    primaryStage.setScene(scene);
			   
			    primaryStage.show();
		 }
		  
	 }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	
		clientMessage.setStyle("-fx-control-inner-background: lightgray;");
		
		
		
        for (Question q : Main.gym.getQuestions()) {
            // Create a final variable to capture the current Question
            final Question currentQuestion = q;
            
          
            
            

            // Create a new label with the entered text
            Label newLabel = new Label(q.getAsker() + ": " + q.getQuestionText());

            // Add the new label to the container
            labelContainer.getChildren().add(newLabel);
            
            // Apply CSS styling to the label to set the font size, underline, bold, and text color
            newLabel.setStyle("-fx-font-size: 16; -fx-underline: true; -fx-font-weight: bold; -fx-text-fill: blue; -fx-font-style: italic;");
            
            newLabel.setWrapText(true);

         // Set a preferred width for the label (optional)
           // newLabel.setPrefWidth(200);‏
            
            // Add a horizontal line (separator) between the labels
            Separator separator = new Separator();
            separator.setPrefWidth(200); // Set the desired width for the separator
            labelContainer.getChildren().add(separator);

            // Attach the event handler to each label within the loop
            newLabel.setOnMouseClicked(e -> {
                try {
                    Main.saveQuestion = currentQuestion; // Use the captured Question
                    Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("showAnswers.fxml"));
                    Scene scene = new Scene(root, 800, 466);
                    Image icon = new Image("/Images/icon.png");
                    primaryStage.getIcons().add(icon);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
    }


	}
	
	


