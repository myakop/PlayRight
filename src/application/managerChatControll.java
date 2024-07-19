package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalTime;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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

public class managerChatControll implements Initializable {
   

    @FXML
    private TextField managerMessage;
    
    @FXML
    private VBox vbox;

    @FXML
    private Button sendbtn;
    
    @FXML
    private Button backbtn;

    @FXML
    private Label title;

    private static final DatagramSocket socket;
    static {
        try {
            socket = new DatagramSocket(); // init to any available port
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    private static final InetAddress address;

    static {
        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String identifier = "Admin";

    private static final int SERVER_PORT = 8000;
    
    public void send(MouseEvent Action) throws IOException{
    	 String temp = identifier + ": " + managerMessage.getText();
      
    	
    	 Label newLabel = new Label("Me: "+managerMessage.getText());
    	 
    	 Text timeText = new Text(getCurrentTime()); // Implement the getCurrentTime() method to get the current time

         // Style the time text with a smaller font size
         timeText.setStyle("-fx-font-size: 8px; -fx-font-family: 'Arial';");
    	
    	 newLabel.setStyle("-fx-font-size: 16px; -fx-font-family: 'Arial';");
    	 HBox messageContainer = new HBox(timeText, newLabel);

         // Add the new label to the container
         vbox.getChildren().add(messageContainer);
         // Add the new label to the container
    
    	  // update messages on screen
         byte[] msg = temp.getBytes(); // convert to bytes
         managerMessage.setText(""); // remove text from input box

         // create a packet & send
         DatagramPacket send = new DatagramPacket(msg, msg.length, address, SERVER_PORT);
         try {
             socket.send(send);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         
         
     }
    	
    
    
    public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
if(Main.savelangmanager.equals("English")) {
			
			backbtn.setText("Back");
			title.setText("Chat");
			
        
			
		}
		 if(Main.savelangmanager.equals("Hebrew")) {
			 
				backbtn.setText("חזור");
				title.setText("צ'אט");
				
			
		}
		 if(Main.savelangmanager.equals("العربية")) {
			 
				backbtn.setText("رجوع");
				title.setText("محادثة");
				
			
		}
		
      
		
        managerMessage.setStyle("-fx-control-inner-background: lightgray;");
		    ClientThread clientThread = new ClientThread(socket, vbox);
	        clientThread.start();

	        // send initialization message to the server
	        byte[] uuid = ("init;" + identifier).getBytes();
	        DatagramPacket initialize = new DatagramPacket(uuid, uuid.length, address, SERVER_PORT);
	        try {
				socket.send(initialize);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private String getCurrentTime() {
        // Get the current time
        LocalTime time = LocalTime.now();

        // Format the time as a string with a specific pattern (e.g., HH:mm:ss)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
}

