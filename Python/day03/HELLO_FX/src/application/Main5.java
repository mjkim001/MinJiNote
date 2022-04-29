package application;
	
import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Main5 extends Application {
	TextField tfDan;
	TextArea ta;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main5.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = (Button) scene.lookup("#btn");
		
		tfDan = (TextField) scene.lookup("#tfDan");
		ta = (TextArea) scene.lookup("#ta");
		
		btn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				myClick();
			}
		});
		
		primaryStage.setScene(scene);
		primaryStage.show(); // 창 띄우기
		

	}
	
	public void myClick() {
		
		int a = Integer.parseInt(tfDan.getText());
		String str="";
		for(int i = 1; i<=9; i++) {
			str += a + " * " + i + " = " + a*i + "\n";
		}
		ta.setText(str);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
