package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
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

public class data2  implements Initializable  {
	@FXML
    private LineChart<String,Double> linechart;
	

	@FXML
    private Button backs;
	@FXML
    private Label name;

    @FXML
    private Label height;

    @FXML
    private Label goal;

    @FXML
    private Label date;
	

    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	if(Main.savelangmanager.equals("English")) {
			
            backs.setText("back");
           	
   		}
   		 if(Main.savelangmanager.equals("Hebrew")) {
   		
   			 backs.setText("חזור");
   
   		}
   		 /*
   		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   		Main.savecustomerfortrack.joiningdate = LocalDate.parse("15/12/2023" , formatter);
   		LocalDate local1 = LocalDate.parse("15/12/2023" , formatter);
   		LocalDate local2 = LocalDate.parse("18/12/2023" , formatter);
   		LocalDate local3 = LocalDate.parse("25/12/2023" , formatter);
   		LocalDate local4 = LocalDate.parse("31/12/2023" , formatter);
   		LocalDate local5 = LocalDate.parse("05/01/2024" , formatter);
   		
   		Main.savecustomerfortrack.wieghts2 = new HashMap<>();
   		Main.savecustomerfortrack.wieghts2.put(local1, 95.0);
   		Main.savecustomerfortrack.wieghts2.put(local2, 94.0);
   		Main.savecustomerfortrack.wieghts2.put(local3, 91.5);
   		Main.savecustomerfortrack.wieghts2.put(local4, 88.3);
   		Main.savecustomerfortrack.wieghts2.put(local5, 87.2);
   		
   	//	Main.savecustomerfortrack.joiningdate = LocalDate.parse("15/12/2023" , formatter);
   		Main.update();
   		
   		 */
   		name.setText("Full name: "+Main.savecustomerfortrack.getFirstName() + " " +Main.savecustomerfortrack.getLastName());
   		height.setText("Hegiht: " +Double.toString((Main.savecustomerfortrack.getSaveHeight())));
   		goal.setText("Goal: "+Main.savecustomerfortrack.goal);
   		date.setText("JoiningDate: " + Main.savecustomerfortrack.joiningdate);
   		
   		
   		linechart.setTitle("Costomer wieghts");

     // Create data series
     XYChart.Series<String, Double> series = new XYChart.Series<>();
     series.setName("Wieght");

   
  
     List<LocalDate> sortedDates = new ArrayList<>(Main.savecustomerfortrack.wieghts2.keySet());
     Collections.sort(sortedDates);
     // Add data to the series
  // Add data to the series
     for (LocalDate date : sortedDates) {
         series.getData().add(new XYChart.Data<>(date.toString(), Main.savecustomerfortrack.wieghts2.get(date)));
     }

     // Add the series to the line chart
     linechart.getData().add(series);
   // Cast to NumberAxis
     
		
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
