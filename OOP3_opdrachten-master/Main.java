import view.View;
import model.Model;
import controller.Controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{	
	private Stage primaryStage;
	
    @Override 
    public void start(Stage primaryStage)
    {     
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox, 200, 200);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		View view = new view.View(primaryStage);
		Model model = new model.Model();
		Controller controller = new controller.Controller(view, model);
    }
    
	public static void main(String[] args)
	{
		launch(args);
	}
	

}
