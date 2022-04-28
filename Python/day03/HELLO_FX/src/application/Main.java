package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("hello.fxml"));
		Scene scene = new Scene(root); 
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("창 제목"); 
		primaryStage.setScene(scene);
		primaryStage.show(); // 창 띄우기
		

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
