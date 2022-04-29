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

public class Main6 extends Application {
	Label lbl1;
	Label lbl2;
	Label lbl3;
	Label lbl4;
	Label lbl5;
	Label lbl6;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main6.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = (Button) scene.lookup("#btn");
		
		lbl1 = (Label) scene.lookup("#lbl1");
		lbl2 = (Label) scene.lookup("#lbl2");
		lbl3 = (Label) scene.lookup("#lbl3");
		lbl4 = (Label) scene.lookup("#lbl4");
		lbl5 = (Label) scene.lookup("#lbl5");
		lbl6 = (Label) scene.lookup("#lbl6");
		
		
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
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= 45; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list);
		
		lbl1.setText(""+list.get(0));
		lbl2.setText(""+list.get(1));
		lbl3.setText(""+list.get(2));
		lbl4.setText(""+list.get(3));
		lbl5.setText(""+list.get(4));
		lbl6.setText(""+list.get(5));
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
