package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class musicControll implements Initializable {
	
	@FXML
	private MediaView mediaView;
	
	@FXML 
	private Slider controlVolume;
	@FXML
    private Button sort;

	@FXML
	private ListView<music> music;
	


	

    @FXML
    private Label title;

    @FXML
    private Button btnback;


    @FXML
    private Button play;

    @FXML
    private Button stop;

  

	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(Main.savelangCustomer.equals("English")) {
			title.setText("Music as you like");
			btnback.setText("Back");

			play.setText("Play");

			stop.setText("Stop");
			
			
			
		}
		 if(Main.savelangCustomer.equals("Hebrew")) {
			 title.setText("מתאמנים עם מוזיקה ברקע");
				btnback.setText("חזור");

				play.setText("הפעל");

				stop.setText("עצור");
			
		}
		 if(Main.savelangCustomer.equals("العربية")) {
			 title.setText("ممارسة الرياضة مع الموسيقى ");
				btnback.setText("رجوع");

				play.setText("شغل");

				stop.setText("اوقف");
			
		}
		
		 if(Main.savelangCustomer.equals("English")) {
			 sort.setText("Favorites"); 
		 }
		 
		 if(Main.savelangCustomer.equals("Hebrew")) {
			 sort.setText("מועדפים"); 
		 }
		 if(Main.savelangCustomer.equals("العربية")) {
			 sort.setText("المفضلة"); 
		 }
		
		
		System.out.println(Main.saveCustomer.getSongs());
		// TODO Auto-generated method stub
		
		music.setStyle("-fx-control-inner-background: lightgray;");
		music.getItems().addAll(Main.gym.getMusic().values());
		controlVolume.setValue(Main.saveMediaPlayer.getVolume() * 100);
		controlVolume.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				
				Main.saveMediaPlayer.setVolume(controlVolume.getValue() / 100);
				
			}
			
			
		});
		 Image iconImage = new Image(getClass().getResourceAsStream("/Images/image.png"));
	     Image iconImage2 = new Image(getClass().getResourceAsStream("/Images/image2.png"));

	        // Store the clicked state for each item
	        boolean[] clickedState = new boolean[music.getItems().size()];
	        
	        
	        	
	        
		
		
	        music.setCellFactory(new Callback<ListView<music>, ListCell<music>>() {
	            @Override
	            public ListCell<music> call(ListView<music> param) {
	                return new ListCell<music>() {
	                    @Override
	                    protected void updateItem(music item, boolean empty) {
	                        super.updateItem(item, empty);

	                        if (item == null || empty) {
	                            setGraphic(null);
	                        } else {
	                            int index = getIndex();
	                            // Create an ImageView to display the icon image
	                            ImageView starImageView = new ImageView(iconImage);

	                            if (Main.saveCustomer.getSongs().contains(item)) {
	                                starImageView.setImage(iconImage2);
	                            }

	                            starImageView.setFitWidth(16); // Set the width of the icon
	                            starImageView.setFitHeight(16);

	                            // Add an event handler to toggle the image when clicked
	                            starImageView.setOnMouseClicked((MouseEvent event) -> {
	                                if (Main.saveCustomer.getSongs().contains(item)) {
	                                    // If the item is in Main.saveCustomer.getSongs(), remove it and set the default icon
	                                    Main.saveCustomer.getSongs().remove(item);
	                                    starImageView.setImage(iconImage);
	                                    Main.update();
	                                } else {
	                                    // If the item is not in Main.saveCustomer.getSongs(), add it and set the alternate icon
	                                    Main.saveCustomer.getSongs().add(item);
	                                    starImageView.setImage(iconImage2);
	                                    Main.update();
	                                }
	                            });

	                            HBox cellLayout = new HBox(10, new javafx.scene.text.Text(item.getName()), starImageView);
	                            // Set the layout as the cell's graphic
	                            setGraphic(cellLayout);
	                        }
	                    }
	                };
	            }
	        });
		
	}
	public void sortbyfav(ActionEvent event) throws IOException{
		if(sort.getText().equals("Favorites") || sort.getText().equals("מועדפים") || sort.getText().equals("المفضلة")   ) {
		
			if(sort.getText().equals("Favorites")) {
				sort.setText("All");
			}
			if(sort.getText().equals("מועדפים")) {
				sort.setText("הכל");
			}
			if(sort.getText().equals("المفضلة")) {
				sort.setText("الكل");
			}
			
		music.getItems().clear();
		ObservableList<music> list = FXCollections.observableArrayList();
		list.addAll(Main.saveCustomer.getSongs());
		music.getItems().addAll(list);
		
		}
		else if(sort.getText().equals("All") || sort.getText().equals("הכל") || sort.getText().equals("الكل")) {
			
			if(sort.getText().equals("All")){
				sort.setText("Favorites");
			}
			if(sort.getText().equals("הכל")){
				sort.setText("מועדפים");
			}
			if(sort.getText().equals("الكل")){
				sort.setText("المفضلة");
			}
			
			
			music.getItems().clear();
			music.getItems().addAll(Main.gym.getMusic().values());
			
		}
		
	}
	
	 public void playMusic(ActionEvent event) throws IOException{
		 
		     int Select = music.getSelectionModel().getSelectedIndex(); 
		 
		    Media media = new Media(getClass().getResource(music.getItems().get(Select).getPath()).toString());
			MediaPlayer player = new MediaPlayer(media);
			Main.saveMediaPlayer = player;
			mediaView.setMediaPlayer(Main.saveMediaPlayer);
			Main.saveMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			Main.saveMediaPlayer.setVolume(0.2);
			Main.saveMediaPlayer.play();
			controlVolume.setValue(Main.saveMediaPlayer.getVolume() * 100);
			controlVolume.valueProperty().addListener(new InvalidationListener() {

				@Override
				public void invalidated(Observable observable) {
					
					Main.saveMediaPlayer.setVolume(controlVolume.getValue() / 100);
					
				}
				
				
			});
	 }
	 
	 public void stopMusic(ActionEvent event) throws IOException{
		 Main.saveMediaPlayer.stop();
	 }
	
	
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("CustomerMainPage");
		    primaryStage.show();
	 }

}
