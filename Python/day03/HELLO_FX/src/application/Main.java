package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("hello.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		
		/*
		Button btn = (Button) scene.lookup("#btn");
		Label lbl = (Label) scene.lookup("#lbl");
		btn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				lbl.setText("Good Enening");
				
			}
		});
		*/
		primaryStage.setTitle("창 제목"); 
		primaryStage.setScene(scene);
		primaryStage.show(); // 창 띄우기
		

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
