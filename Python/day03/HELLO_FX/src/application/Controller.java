package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class Controller {

	@FXML private Button btn;
    @FXML private Label lbl;

	public void handleBtn1Action(ActionEvent event) {
		lbl.setText("Good Night");
    }
	
}
