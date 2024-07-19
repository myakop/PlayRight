package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class AddMeal  implements Initializable  {
	

	@FXML
    private Label name2;

    @FXML
    private TextField name;

    @FXML
    private TextField cal;

    @FXML
    private Label cal2;

    @FXML
    private Button sumbitbtn;

    @FXML
    private Label protin2;

    @FXML
    private TextField protin;

    @FXML
    private TextField carbs;

    @FXML
    private Label carbs2;

    @FXML
    private Button backbtn;
    @FXML
    private Label title;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Main.savelangmanager.equals("English")) {
			name2.setText("Name");
			cal2.setText("Calories");

			protin2.setText("Protin");

			carbs2.setText("Carbs");
			sumbitbtn.setText("Submit");
			backbtn.setText("Back");
			title.setText("Add Meal");
        
			
		}
		 if(Main.savelangmanager.equals("Hebrew")) {
			 name2.setText("שם");
				cal2.setText("קאלוריות");

				protin2.setText("חלבון");

				carbs2.setText("פחמימות");
				sumbitbtn.setText("אישור");
				backbtn.setText("חזור");
				title.setText("הוספת ארוחה");
			
		}
		// TODO Auto-generated method stub
		
	}
	
	
	public void submitaddcomp (ActionEvent event) throws IOException {
		String cals = cal.getText();
		double cal =  Double.parseDouble(cals);
		String carbs1 = carbs.getText();
		double carb =  Double.parseDouble(carbs1);
		String protin1 = protin.getText();
		double protin2 =  Double.parseDouble(protin1);

		
				
		Meal meal = new Meal(name.getText(),cal,carb,protin2);
		
		
		checkcompid(meal);
		if(Main.gym.addnewmeal(meal)) {
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully add");
			aler.showAndWait();	
			
				}
			
		}
    
      

	public void checkcompid(Meal comp) {
		int x=0;
		for(int c : Main.gym.getMeals().keySet()) {
			if(c>x)
				x=c;
		}
		comp.setId(x+1);
		return;
	}
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("ManageMeals.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("ManageMeals");
		    primaryStage.show();
	 }




	
	

	

}
