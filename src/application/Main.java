package application;
	
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Utils.Gender;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;


public class Main extends Application implements Serializable {
	public static String category;
	
	public static Gym gym;
	public static String saveperviospage;
	private static final long serialVersionUID = 1L;
	public static MediaPlayer saveMediaPlayer; /* to mute with sound after going to another page */
	public static Customer saveCustomer;   /* to know who is the customer now */
	public static double saveCarbs;
	public static double saveCalories;
	public static double saveProtin;
	public static Meal meal1;
	public static Meal meal2;
	public static Meal meal3;
	public static exercise saveexercise;
	public static String savelangmanager = "English";
	public static String savelangCustomer = "English";
	
	public static String saveAnswer;
	public static Question saveQuestion;
	public static Customer savecustomerforplan;
	public static Customer savecustomerfortrack;
	public static int savetheday;
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
	
			Parent root = FXMLLoader.load(getClass().getResource("/application/LoginWithVideo.fxml"));
			Scene scene = new Scene(root,800,466);
			
			Image icon = new Image("/Images/icon.png");
			primaryStage.getIcons().add(icon);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Welcome to PlayRight !");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		
		deSerialize();
		 if(gym==null) {
			serialize();
		} 
		launch(args);
		
	
	
	}
	
	
	/* methods for serialization */
	
	public static void serialize() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Gym.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			gym=Gym.getInstance();
			out.writeObject(gym);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in Gym.ser");
		}catch(EOFException ignoredFirstTime) {
			
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public static void deSerialize() {
		try {
			FileInputStream fileIn = new FileInputStream("Gym.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			gym=(Gym) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Successfully deSerialized the data");
		}catch(IOException i) {
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c) {
			System.out.println("class not found");
			c.printStackTrace();
			return;
		}
	}
	
	/* use it for save the new changes */
	public static void update() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Gym.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Main.gym);
			out.close();
			fileOut.close();
		}catch(IOException i) {
			i.printStackTrace();
			return;
		}
	}
}
