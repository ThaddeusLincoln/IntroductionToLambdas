package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

	@FXML
	private Button clickMeButton;
		
	public void initialize(){
		
		// 1. set an action to a button without lambdas
		/*clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("You have clicked the button");
			}
		});*/
		
		// 2. doing the same as before with lambdas
		clickMeButton.setOnAction(event -> System.out.println("Has hecho click en el boton! Lambdas, oh yeah!"));
		
		
	}
	
	
	
	
	
	
	
}
