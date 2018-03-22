package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BoardView {
	public Button nextBtn = new Button("Find words");
		
		public Scene GetScene(char[][] cs)
	    {
			
			GridPane grid = new GridPane();
			char a;
			
			for( int i=0; i < 4; i++) {
	            for( int j=0; j < 4; j++) {
	            	a = cs[i][j];	
	            	System.out.print(a); 
            }
	            System.out.println(); 
			}
			
			/*Todo laat het board via javaFX zien*/
			
	        VBox vbox = new VBox();
	        vbox.getChildren().addAll(nextBtn);
	        Scene scene = new Scene(vbox, 700, 700);
	        return scene;
	    }
}
