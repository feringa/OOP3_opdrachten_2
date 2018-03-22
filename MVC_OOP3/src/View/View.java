package View;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View
{
	private Stage primaryStage;
	public Button quickSortBtn;
	public Button bubbleSortBtn;
	public Button insertSortBtn;
	
	public QuickView quick;
	public InsertView insert;
	public BubbleView bubble;
	
	public View(Stage stage)
	{
		this.primaryStage = stage;
		
        bubbleSortBtn = new Button("Bubble Sort");
        quickSortBtn = new Button("Quick Sort");
        insertSortBtn = new Button("Insertion Sort");
        
		quick = new QuickView();
		insert = new InsertView();
		bubble = new BubbleView();
		SetScene(MainMenu());
	}
    
    public Scene MainMenu()
    {
        VBox vbox = new VBox();
        vbox.getChildren().addAll(bubbleSortBtn, quickSortBtn, insertSortBtn);
        Scene scene = new Scene(vbox, 700, 200);

        return scene;
    }
	
    public void SetScene(Scene scene)
    {
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
