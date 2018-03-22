package Controller;

import View.View;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import Model.Model;

public class Controller 
{
	private View view;
	private Model model;
	private int interval = 100;
	public Controller(View view, Model model)
	{		
		this.view = view;
		this.model = model;
		MainMenuBtnHandler();
		BubblesortBtnHandler();
		QuickSortBtnHandler();
		InsertSortBtnhandler();
	}
	
	
	void MainMenuBtnHandler()
	{
		//To choose what algorithm you want to run
		view.bubbleSortBtn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	model.bubble.SetArray(model.GenerateArray(10));
		    	view.SetScene(view.bubble.GetScene(model.GetRandomArray()));
		    }
		});
		//To choose what algorithm you want to run
		view.quickSortBtn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {		    	
		    	model.quick.SetArray(model.GenerateArray(10));
		    	view.SetScene(view.quick.GetScene(model.GetRandomArray()));
		    }
		});
		
		//To choose what algorithm you want to run
		view.insertSortBtn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {		    	
		    	model.insert.SetArray(model.GenerateArray(10));
		    	view.SetScene(view.insert.GetScene(model.GetRandomArray()));
		    }
		});
	}
	
	void BubblesortBtnHandler()
	{
		//run bubble sort for one step
		view.bubble.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                view.SetScene(view.bubble.GetScene(model.bubble.Sort()));
            }
        });
		
		//run bubble sort automaticly with X interval per step
        view.bubble.autoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                model.bubble.autoSort = true;
                boolean temp = false;
                Runnable runnableTask = () -> {  
            		try {
            			while(model.bubble.autoSort)
            			{
							TimeUnit.MILLISECONDS.sleep(interval);
							view.SetScene(view.bubble.GetScene(model.bubble.Sort()));  
							if(model.bubble.Sorted())
		                    	model.bubble.autoSort = false;
            			}
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
                };
            	Platform.runLater(runnableTask);
            }
        });
        
		//Back to main menu
		view.bubble.backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                view.SetScene(view.MainMenu());
            }
        });
	}
	
	void InsertSortBtnhandler()
	{
		//run insert sort for one step		
        view.insert.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                view.SetScene(view.insert.GetScene(model.insert.Sort()));
            }
        });
        
        //run insert sort automaticly with X interval per step
        view.insert.autoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                model.insert.autoSort = true;
                boolean temp = false;
                Runnable runnableTask = () -> {  
            		try {
            			while(model.insert.autoSort)
            			{
							TimeUnit.MILLISECONDS.sleep(interval);
							view.SetScene(view.insert.GetScene(model.insert.Sort()));  
							if(model.insert.Sorted())
		                    	model.insert.autoSort = false;
            			}
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
                };
            	Platform.runLater(runnableTask);
            } 
        });
        
      //Back to main menu
      		view.insert.backBtn.setOnAction(new EventHandler<ActionEvent>() {
                  @Override public void handle(ActionEvent e) {
                      view.SetScene(view.MainMenu());
                  }
              });
	}
	
	void QuickSortBtnHandler()
	{
		//run quick sort for one step
        view.quick.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                view.SetScene(view.quick.GetScene(model.quick.Sort()));
            }
        });
        
      //Back to main menu
      		view.quick.backBtn.setOnAction(new EventHandler<ActionEvent>() {
                  @Override public void handle(ActionEvent e) {
                      view.SetScene(view.MainMenu());
                  }
              });
	}
    
}
