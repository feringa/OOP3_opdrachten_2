package controller;

import view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Model;

public class Controller 
{
	private View view;
	private Model model;
	
	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
		
		
		view.startBtn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	model.GenerateBoard();
		    	view.SetScene(view.board.GetScene(model.GenerateBoard()));
		    }
		});
		
		view.board.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //view.SetScene(view.board.GetScene(model.Start()));
            	model.Start();
            }
        });
	 
	}
}
