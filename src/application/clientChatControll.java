package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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

public class clientChatControll implements Initializable {
    

    @FXML
    private TextField clientMessage;

    @FXML
    private Button sendbtn;
    
    
    @FXML
    private Button btnback;

    @FXML
    private Label title;


    @FXML
    private VBox vbox;
    
   

   

  


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
    
    static String name = Main.saveCustomer.getUserName();

    private static final String identifier = name ;

    private static final int SERVER_PORT = 8000;
    
    public void send(MouseEvent Action) throws IOException {
        String temp = identifier + ": " + clientMessage.getText();

        // Create a Text object for the time
        Text timeText = new Text(getCurrentTime()); // Implement the getCurrentTime() method to get the current time

        // Style the time text with a smaller font size
        timeText.setStyle("-fx-font-size: 8px; -fx-font-family: 'Arial';");

        // Create a Label for the message
        Label messageLabel = new Label("Me: " + clientMessage.getText());

        // Style the message text with a larger font size
        messageLabel.setStyle("-fx-font-size: 16px; -fx-font-family: 'Arial';");

        // Create an HBox to contain both the time and message
        HBox messageContainer = new HBox(timeText, messageLabel);

        // Add the new label to the container
        vbox.getChildren().add(messageContainer);

        byte[] msg = temp.getBytes(); // convert to bytes
        clientMessage.setText(""); // remove text from the input box

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
		    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(Main.savelangCustomer.equals("English")) {
			title.setText("Chat");
			btnback.setText("Back");
	
		}
		 if(Main.savelangCustomer.equals("Hebrew")) {
			 title.setText("צ'אט");
				btnback.setText("חזור");

		}
		 if(Main.savelangCustomer.equals("العربية")) {
			 title.setText("محادثة");
				btnback.setText("رجوع");

		}
		
		clientMessage.setStyle("-fx-control-inner-background: lightgray;");
		
		 
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

