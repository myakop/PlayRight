package application;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class data implements Initializable {

    @FXML
    private BarChart<String, Integer> barchart;
    @FXML
    private Button backs;

    @FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;
    @FXML
    private BarChart<String, Integer> barchart1;
    

    @FXML
    private CategoryAxis X1;

    @FXML
    private NumberAxis Y1;

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        if (Main.savelangmanager.equals("English")) {
            backs.setText("back");
        }
        if (Main.savelangmanager.equals("Hebrew")) {
            backs.setText("חזור");
        }
        int maleCount = 0;
        int femaleCount = 0;

        for (Customer customer : Main.gym.getCustomers().values()) {
            if ("Male".equals(customer.getGender().toString())) {
                maleCount++;
            } else if ("Female".equals(customer.getGender().toString())) {
                femaleCount++;
            }
        }
        
        int under20 = 0;
        int between20and40 = 0;
        int above40=0;

        // Categorize the data
        for (Customer cust: Main.gym.getCustomers().values()) {
          
            double age = cust.saveAge;

            if (age < 20) {
           	 under20++;
            } else if (age >= 20 && age <= 40) {
           	 between20and40++;
            } else {
           	 above40++;
            }
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Male", maleCount));
        series.getData().add(new XYChart.Data<>("Female", femaleCount));
        // Add the series to the bar chart
        barchart.getData().addAll(series);
        
        
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("<20", under20));
        series1.getData().add(new XYChart.Data<>("20-40", between20and40));
        series1.getData().add(new XYChart.Data<>("40+", above40));
        // Add the series to the bar chart
        barchart1.getData().addAll(series1);

        // Set colors for Male and Female bars
        setBarColors(barchart);

        // Set tick unit and minor tick unit for Y-axis
        Y.setAutoRanging(false);
      //  Y.setLowerBound(0);
     //   Y.setUpperBound(Math.ceil(Math.max(maleCount, femaleCount) / 10) * 10);  // Adjust the range as needed
        Y.setTickUnit(1);
        Y.setUpperBound(30);
        
        Y1.setAutoRanging(false);
        //  Y.setLowerBound(0);
       //   Y.setUpperBound(Math.ceil(Math.max(maleCount, femaleCount) / 10) * 10);  // Adjust the range as needed
          Y1.setTickUnit(1);
          Y1.setUpperBound(30);
    }

    // Method to set colors for Male and Female bars
    private void setBarColors(BarChart<String, Integer> chart) {
        for (XYChart.Series<String, Integer> series : chart.getData()) {
            for (XYChart.Data<String, Integer> data : series.getData()) {
                Node node = data.getNode();
                String gender = data.getXValue();

                // Set color based on gender
                if ("Male".equals(gender)) {
                    node.setStyle("-fx-bar-fill: blue;");
                } else if ("Female".equals(gender)) {
                    node.setStyle("-fx-bar-fill: red;");
                }
            }
        }
    }
    
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("reports.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }
}
