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
import javafx.scene.control.TextField;

public class Main3 extends Application {
	TextField tf1;
	TextField tf2;
	TextField tf3;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main3.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = (Button) scene.lookup("#btn");
		
		tf1 = (TextField) scene.lookup("#tf1");
		tf2 = (TextField) scene.lookup("#tf2");
		tf3 = (TextField) scene.lookup("#tf3");
		
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
		int a = Integer.parseInt(tf1.getText());
		int b = Integer.parseInt(tf2.getText());
		int c = a+b;
		tf3.setText(""+c);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
