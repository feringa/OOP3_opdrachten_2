package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class QuickView 
{
	public Button nextBtn = new Button("Quick sort");
	public Button backBtn = new Button("Back");
	
	  public Scene GetScene(int[] arr)
	  {
	        CategoryAxis xAxis = new CategoryAxis();
	        NumberAxis yAxis = new NumberAxis();
	        BarChart barChart = new BarChart(xAxis, yAxis);

	        XYChart.Series Data = new XYChart.Series();
	        for(int j = 0; j < arr.length; j++) {
	           Data.getData().add(new XYChart.Data(Integer.toString(arr[j]), arr[j]));
	        }
	        barChart.getData().add(Data);

	        VBox vbox = new VBox();
	        vbox.getChildren().addAll(nextBtn, backBtn, barChart);
	        Scene scene = new Scene(vbox, 800, 1000);
	        return scene;
	    }
}
