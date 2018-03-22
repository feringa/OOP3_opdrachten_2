package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View
{
	private Stage primaryStage;
	public Button startBtn;
	public BoardView board;
	
	public View(Stage stage)
	{
		this.primaryStage = stage;
		
        startBtn = new Button("start");
        
        board = new BoardView();
        
		init(stage);
	}
    
    public void init(Stage primaryStage)
    {
        VBox vbox = new VBox();
        vbox.getChildren().addAll(startBtn);
        Scene scene = new Scene(vbox, 700, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
    public void SetScene(Scene scene)
    {
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}