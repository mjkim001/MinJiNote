package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;

import java.util.List;

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

public class Main7 extends Application {
	TextField tf1;
	TextField tf2;
	TextArea ta;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main7.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = (Button) scene.lookup("#btn");
		
		tf1 = (TextField) scene.lookup("#tf1");
		tf2 = (TextField) scene.lookup("#tf2");
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
		int a = Integer.parseInt(tf1.getText());
		int b = Integer.parseInt(tf2.getText());
		String str = "";
		
//		for(int i = a; i<=b; i++) {
//			for(int j = 0; j < i; j++) {
//				str += "*";
//			}
//			str += "\n";
//		}
		
		for(int i = a; i<=b; i++) {
			str += drawStar(i);
		}
		
		ta.setText(str);
		
	}
	
	public String drawStar(int cnt) {
		String ret = "";
		for(int i = 0; i < cnt; i++) {
			ret += "*";
		}
		ret+="\n";
		return ret;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
