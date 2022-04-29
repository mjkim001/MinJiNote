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
import javafx.scene.control.TextField;

public class Main4 extends Application {
	TextField tfMine;
	TextField tfCom;
	TextField tfResult;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main4.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = (Button) scene.lookup("#btn");
		
		tfMine = (TextField) scene.lookup("#tfMine");
		tfCom = (TextField) scene.lookup("#tfCom");
		tfResult = (TextField) scene.lookup("#tfResult");
		
		btn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				myClick();
			}
		});
		
		primaryStage.setTitle("창 제목"); 
		primaryStage.setScene(scene);
		primaryStage.show(); // 창 띄우기
		

	}
	
	public void myClick() {
		
		int a = (int) (Math.random()*2);
		
		if(a == 1) {
			tfCom.setText("짝");
		}else {
			tfCom.setText("홀");
		}
		
		if(tfCom.getText().equals(tfMine.getText())) {
			tfResult.setText("맞췄습니다.");
		}else {
			tfResult.setText("틀렸습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
