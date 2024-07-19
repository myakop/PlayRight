package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Utils.Gender;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SignupController implements Initializable {
	
	@FXML
	private Label lblNeigh, lblNote;
	
	@FXML
	private ComboBox<String> gender;
	
	@FXML
	private TextField firstName, lastName, userName;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private DatePicker birthday;
	
	
	@FXML
	private ProgressBar progressBar;
	
	
	@FXML
	void SelectNeighberhood(ActionEvent event) {

	}
	
	@FXML
	void SelectGender(ActionEvent event) {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> listGender=FXCollections.observableArrayList("Male", "Female", "Unknown");
		if(gender!=null) {
			for(int i=0;i<3;i++) {
				gender.getItems().add(listGender.get(i));   /* fill in the gender compobox */
			}
		}
	}
	
	/* for back to login page */
	public void BackToLoginPage(ActionEvent event) throws IOException {
		Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("LoginWithVideo.fxml"));
		Scene scene = new Scene(root,800,465);
		Image icon = new Image("/Images/icon.png");
		primaryStage.getIcons().add(icon);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome to PlayRight !");
		primaryStage.show();
    }
	
	
	/* this part from the bonus  that show to the customer the strength of his password that he choose by colors and ProgressBar,
	 * the password must be 8 characters and contains one uppercase at least to be strong password with green color
	 * if 1/2 is done it be medium password with yellow color 
	 * if anything is done it be weak password with red color */
	
	@FXML
	void passwordPower(KeyEvent event) {
		
		password.setOnKeyReleased((KeyEvent e) -> {
			
			double passwordLength = password.getText().length();
			progressBar.setProgress(passwordLength/10);
			
			int UperCase = 0;
			char[] p = password.getText().toCharArray();
			
			for(int i=0;i<passwordLength;i++) {
				if(Character.isUpperCase(p[i])) {
					UperCase = 1;
				}
			}
			
			if(passwordLength<3) 
				if(UperCase==1) { 
					progressBar.setStyle("-fx-accent: yellow; -fx-text-box-border: transparent;");
				}
				else{
					progressBar.setStyle("-fx-accent: red; -fx-text-box-border: transparent;");
				}
			if(UperCase==1) {
				if(passwordLength<3) {
					progressBar.setStyle("-fx-accent: yellow; -fx-text-box-border: transparent;");
				}
			}
			
			if(passwordLength>=3 && UperCase==1) {
				if(passwordLength>=8) {
					progressBar.setStyle("-fx-accent: green; -fx-text-box-border: transparent;");
				}
				else{
					progressBar.setStyle("-fx-accent: yellow; -fx-text-box-border: transparent;");
				}
			}
			
			if(passwordLength >=8 && UperCase==1) {
				progressBar.setStyle("-fx-accent: green; -fx-text-box-border: transparent;");
			}
			else if(passwordLength >=8 && UperCase!=1) {
				progressBar.setStyle("-fx-accent: yellow; -fx-text-box-border: transparent;");
			}
		});
	}
	
	
	/* for performing a sign up and adding customer */
	public void SubmitSignUp(ActionEvent event) throws IOException {
		
		try {
			 
			 if(firstName.getText().equals("") || lastName.getText().equals("") || birthday.getValue().equals(null)
		    		   || userName.getText().equals("") || password.getText().equals("")) {
		    	        	throw new NullPointerException();
		    	}
		
		boolean isCheck=true;
		Customer customer = new Customer(firstName.getText(), lastName.getText(), birthday.getValue(), Gender.valueOf(gender.getValue()), userName.getText(), password.getText());
		int max=-1;
		
		for(int x : Main.gym.getCustomers().keySet()) {
			if(x>max) {
				max=x;
			}
		}
		customer.setId(max+1);
		for(Customer cust :Main.gym.getCustomers().values()) {
			if(cust.getUserName().equals(userName.getText())) {
			lblNote.setText("This Username is used, please try another one !");
			isCheck=false;
		  }
		}
		if(isCheck) { 
		    if(Main.gym.addCustomer(customer)) {
		       Main.update();
		       Alert a=new Alert(AlertType.CONFIRMATION);
		       a.setHeaderText("Successfully added customer!");
		       a.showAndWait();
			   Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
			   Parent root = FXMLLoader.load(getClass().getResource("LoginWithVideo.fxml"));
			   Scene scene = new Scene(root,800,466);
			   Image icon = new Image("/Images/icon.png");
			   primaryStage.getIcons().add(icon);
			   primaryStage.setScene(scene);
			   primaryStage.setTitle("Manager screen");
			   primaryStage.show();
		    }
		    else {
		    	Alert a=new Alert(AlertType.CONFIRMATION);
			       a.setHeaderText("Failed to add customer!");
			       a.showAndWait();
		    }
		}
		
    }catch(NullPointerException n) {
		Alert a3=new Alert(AlertType.WARNING);
	    a3.setHeaderText("You must fill in all the fields !");
	    a3.showAndWait();
	 }
		
	}
}
