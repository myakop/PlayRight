package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Random;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class joinFreinds implements Initializable {
	
	
	    @FXML
	    private TextField fullName;

	    @FXML
	    private TextField phone;

	    @FXML
	    private ComboBox<String> location;

	    @FXML
	    private ListView<interestedjoin> joinfreindsview;
	    
	    @FXML
	    private Label phone1;

	    @FXML
	    private Label fullname, title, location1;


	    @FXML
	    private Button submit;
	    

	    @FXML
	    private Button btnback;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		if(Main.savelangCustomer.equals("English")) {
			title.setText("Training with friends");
			btnback.setText("Back");

			fullname.setText("Full name");

			phone1.setText("Phone");
			location1.setText("Location");
			submit.setText("Submit");
			
			
		}
		 if(Main.savelangCustomer.equals("Hebrew")) {
				title.setText("להתאמן עם חברים");
				btnback.setText("חזור");

				fullname.setText("שם מלא");

				phone1.setText("טלפון");
				location1.setText("אזור");
				submit.setText("אישור");
			
		}
		 if(Main.savelangCustomer.equals("العربية")) {
				title.setText("التدرب مع الاصدقاء");
				btnback.setText("رجوع");

				fullname.setText("الاسم كامل");

				phone1.setText("هاتف");
				location1.setText("منطقه");
				submit.setText("موافقه");
			
		}
		
		ObservableList<String> list = FXCollections.observableArrayList("Haifa","Tel aviv","Hedira","Raanana");
		location.setItems(list);
		joinfreindsview.getItems().addAll(Main.gym.getinterestedjoin().values());
		joinfreindsview.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: blue;");
		
	}
	 ArrayList<interestedjoin> items = new ArrayList<interestedjoin>();
	 
	 
	 public void add(MouseEvent event) throws IOException{
		 interestedjoin newcust = new interestedjoin(fullName.getText() , phone.getText() , location.getValue());
		 checkid(newcust);
		 Main.gym.addinterestedjoin(newcust);
		 Main.update();
		 for(interestedjoin cust : joinfreindsview.getItems()) {
			 if(cust.getArea().equals(newcust.getArea())) {
				 items.add(cust);  
			 }
		 }
		 
		 if(!items.isEmpty()) {
		 Random random = new Random();
		 int number = random.nextInt(items.size());
		 interestedjoin randomcust = items.get(number);
		// Alert aler = new Alert(AlertType.CONFIRMATION);
		 
		 
		 if(Main.savelangCustomer.equals("English")) {
			 Alert aler = new Alert(AlertType.CONFIRMATION);
			 aler.setHeaderText(randomcust.getFullname() + " is in the same area, its will be great to collaborate with" ); 
			 aler.showAndWait();
		 }
		 if(Main.savelangCustomer.equals("Hebrew")) {
			 Alert aler = new Alert(AlertType.CONFIRMATION);
			 aler.setHeaderText(randomcust.getFullname() + " באזור שלך, נעים להתאמן יחד" ); 
			 aler.showAndWait();
		 }
			//aler.showAndWait();
		 }
		 
		 
		 
		 
		
		 joinfreindsview.getItems().add(newcust);
		
	   
	    }
	 
	 public void checkid (interestedjoin c) {
			int x=0;
			for(int max : Main.gym.getinterestedjoin().keySet()) {
			if(max>x)
				x=max;
				
			}
			c.setId(x+1);
			return ;
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
