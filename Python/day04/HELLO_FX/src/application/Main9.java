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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Main9 extends Application {
	TextField tf_mine;
	TextField tf_com;
	TextField tf_result;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main9.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = (Button) scene.lookup("#btn");
		
		tf_mine = (TextField) scene.lookup("#tf_mine");
		tf_com = (TextField) scene.lookup("#tf_com");
		tf_result = (TextField) scene.lookup("#tf_result");
		
		btn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				myClick();
			}
		});
		
		tf_mine.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.ENTER)) {
					myClick();
				}
				
			}
		});
		
		primaryStage.setScene(scene);
		primaryStage.show(); // 창 띄우기
		

	}
	
	public void myClick() {
		String arr[] = {"가위","바위","보"};
		
		int a = (int) (Math.random()*3);
		
		tf_com.setText(arr[a]);
		
		String mine = tf_mine.getText();
		String com = tf_com.getText();
		
		if(mine.equals(com)) {
			tf_result.setText("비겼습니다.");
		}
		if(mine.equals("가위")&&com.equals("바위")) {
			tf_result.setText("졌습니다.");
		}
		if(mine.equals("가위")&&com.equals("보")) {
			tf_result.setText("이겼습니다.");
		}
		if(mine.equals("바위")&&com.equals("보")) {
			tf_result.setText("졌습니다.");
		}
		if(mine.equals("바위")&&com.equals("가위")) {
			tf_result.setText("이겼습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
