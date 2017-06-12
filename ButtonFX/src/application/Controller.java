package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

	@FXML
	private Button clickMeButton;
	
	// set an action to a button without lambdas
	public void initialize(){
		
		clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("You have clicked the button");
			}
		});
		
	}
	
}
