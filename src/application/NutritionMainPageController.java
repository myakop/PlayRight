package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

import Utils.Gender;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NutritionMainPageController implements Initializable {

	  @FXML
	    private Label title;

	    @FXML
	    private Label age2, gender2;

	    @FXML
	    private TextField age;

	    @FXML
	    private TextField height;

	    @FXML
	    private TextField weight;

	    @FXML
	    private Label height2;

	    @FXML
	    private Label weight2;

	    @FXML
	    private RadioButton male;

	    

	    @FXML
	    private RadioButton female;

	    @FXML
	    private Button   submit2;

	    @FXML
	    private Label result;

	    @FXML
	    private VBox vbox;

	    @FXML
	    private Button btnback;

	    @FXML
	    private Label years;

	    @FXML
	    private Label cm;

	    @FXML
	    private Label kg;


   
    private final DropShadow dropShadow = new DropShadow();
   
   
   
    public void calc(ActionEvent event) throws IOException{
   
    double heightCm = Double.parseDouble(height.getText());
        double weightKg = Double.parseDouble(weight.getText());
        int ageYears = Integer.parseInt(age.getText());
       
       
        Main.saveCustomer.setSaveAge(ageYears);
        Main.saveCustomer.setSaveHeight(heightCm);
        Main.saveCustomer.setSaveWeight(weightKg);
       
       
       
        Main.update();

        boolean isMale = male.isSelected();
        boolean isFemale = female.isSelected();

        if (!isMale && !isFemale) {
            result.setText("Please select gender.");
            return;
        }

        // Calculate BMI
        double bmi = weightKg / ((heightCm / 100.0) * (heightCm / 100.0));

        // Calculate recommended calorie intake, protein, and carbohydrates
        double recommendedCalories = calculateRecommendedCalories(weightKg, heightCm, ageYears, isMale);
        double recommendedProtein = calculateRecommendedProtein(weightKg, isMale);
        double recommendedCarbs = calculateRecommendedCarbs(recommendedCalories);

        // Display results in the label
        String resultText = "BMI: " + String.format("%.2f", bmi) + "\n";
        resultText += "Recommended Calories in day: " + String.format("%.2f", recommendedCalories) +
                "\nRecommended Protein in day: " + String.format("%.2f", recommendedProtein) +
                "\nRecommended Carbs in day: " + String.format("%.2f", recommendedCarbs);

        result.setText(resultText);
       
        Main.saveCalories= recommendedCalories;
        Main.saveCarbs= recommendedCarbs;
        Main.saveProtin= recommendedProtein;
       
        Button newButton = new Button("build plan");

        vbox.getChildren().add(newButton);
       
        newButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
    Parent root = null;
try {
root = FXMLLoader.load(getClass().getResource("nutritionbuildplan.fxml"));
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
    Scene scene = new Scene(root,800,466);
    Image icon = new Image("/Images/icon.png");
    primaryStage.getIcons().add(icon);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Manager screen");
    primaryStage.show();
  Alert aler = new Alert(AlertType.INFORMATION);
  String headerText = "We have some Suggestions for you:\n"
                  + "First meal: " + Main.meal1.getName() + "\n"
                  + "Second meal: " + Main.meal2.getName() + "\n"
                  + "Third meal: " + Main.meal3.getName();

          aler.setHeaderText(headerText);
  aler.showAndWait();
               
            }
        });
       
       
       
       
       
       

}
   
    private double calculateRecommendedCalories(double weightKg, double heightCm, int ageYears, boolean isMale) {
        // Implement your calorie calculation logic here
        // This is just a placeholder example
        double baseCalories = isMale ? 66.5 : 655.1;
        double weightFactor = isMale ? 13.75 : 9.56;
        double heightFactor = isMale ? 5.003 : 1.85;
        double ageFactor = isMale ? 6.75 : 4.68;

        return baseCalories + (weightFactor * weightKg) + (heightFactor * heightCm) - (ageFactor * ageYears);
    }

    private double calculateRecommendedProtein(double weightKg, boolean isMale) {
        // Implement your protein calculation logic here
        // This is just a placeholder example
        return isMale ? weightKg * 1.2 : weightKg * 1.1;
    }

    private double calculateRecommendedCarbs(double recommendedCalories) {
        // Implement your carbohydrate calculation logic here
        // This is just a placeholder example
        return recommendedCalories * 0.6;
    }

 

@Override
public void initialize(URL location, ResourceBundle resources) {
	
	if(Main.savelangCustomer.equals("English")) {
		
		btnback.setText("Back");

		title.setText("Calculation of nutritional parameters");

		age2.setText("Age");
		height2.setText("height");
		weight2.setText("weight"); 
		years.setText("(in years)");
		cm.setText("(in cm)");
		kg.setText("(in Kg)");
		gender2.setText("Gender");
		submit2.setText("Submit");
		male.setText("Male");
		female.setText("Female"); 
		
		
	}
	 if(Main.savelangCustomer.equals("Hebrew")) {
			btnback.setText("חזור");

			title.setText("חישוב פרמטרי תזונה");

			age2.setText("גיל");
			height2.setText("גובה");
			weight2.setText("משקל");
			years.setText("(בשנים)");
			cm.setText("(ס'ר)");
			kg.setText("(קג)");
			gender2.setText("מין");
			submit2.setText("אישור"); 
			male.setText("זכר");
			female.setText("נקבה");
		
	}
	 if(Main.savelangCustomer.equals("العربية")) {
			btnback.setText("رجوع");

			title.setText("حساب المعلمات الغذائية");

			age2.setText("عمر");
			height2.setText("طول");
			weight2.setText("وزن");
			years.setText("(سنين)");
			cm.setText("(سم)");
			kg.setText("(كغ)");
			gender2.setText("جنس");
			submit2.setText("موافقه"); 
			male.setText("ذكر");
			female.setText("انثى");
		
	}


if(Main.saveCustomer.getSaveAge() != 0 || Main.saveCustomer.getSaveWeight() != 0 || Main.saveCustomer.getSaveHeight() != 0) {



// Assuming Main.saveCustomer.getSaveAge() returns an int or any other data type
int ageValue = (int) Main.saveCustomer.getSaveAge(); // Replace with the actual data type
double weightValue = (double) Main.saveCustomer.saveWeight;
double heightValue = (double) Main.saveCustomer.saveHeight;


// Convert the ageValue to a String and set it in the TextField
age.setText(String.valueOf(ageValue));
weight.setText(String.valueOf(weightValue));
height.setText(String.valueOf(heightValue));



if (Gender.Male.equals(Main.saveCustomer.getGender())) {
   // Gender is male
    male.setSelected(true);
} else {
   // Gender is not male
female.setSelected(true);
}



}
 dropShadow.setColor(Color.RED);
    dropShadow.setRadius(10);
    dropShadow.setSpread(0.2);
    result.setEffect(dropShadow);

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
