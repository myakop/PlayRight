package application;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClientThread extends Thread {

    private DatagramSocket socket;
    private byte[] incoming = new byte[256];

    private VBox vbox;

    public ClientThread(DatagramSocket socket, VBox vbox) {
        this.socket = socket;
        this.vbox = vbox;
    }

    @Override
    public void run() {
        System.out.println("starting thread");
        while (true) {
            DatagramPacket packet = new DatagramPacket(incoming, incoming.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String message = new String(packet.getData(), 0, packet.getLength());

            // Use Platform.runLater to update the JavaFX UI from this thread
            Platform.runLater(() -> {
                // Create a label to display the message
                Label label = new Label(message);
                label.setStyle("-fx-font-size: 16px; -fx-font-family: 'Arial';");
                BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTBLUE, null, null);
              
                
                // Create a Background using the BackgroundFill
                Background background = new Background(backgroundFill);
                label.setBackground(background);
                Text timeText = new Text(getCurrentTime()); // Implement the getCurrentTime() method to get the current time

                // Style the time text with a smaller font size
                timeText.setStyle("-fx-font-size: 8px; -fx-font-family: 'Arial';");
                HBox messageContainer = new HBox(timeText, label);

                // Add the label to the VBox
                vbox.getChildren().add(messageContainer);
            });
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


