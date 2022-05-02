package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;

import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Main8 extends Application {
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btn0;
	TextField tf;
	
	String str = "";
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main8.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button btn = (Button) scene.lookup("#btn");
		tf = (TextField) scene.lookup("#tf");
				
		btn1 = (Button) scene.lookup("#btn1");
		btn2 = (Button) scene.lookup("#btn2");
		btn3 = (Button) scene.lookup("#btn3");
		btn4 = (Button) scene.lookup("#btn4");
		btn5 = (Button) scene.lookup("#btn5");
		btn6 = (Button) scene.lookup("#btn6");
		btn7 = (Button) scene.lookup("#btn7");
		btn8 = (Button) scene.lookup("#btn8");
		btn9 = (Button) scene.lookup("#btn9");
		btn0 = (Button) scene.lookup("#btn0");
		
		btn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				myClick();
			}
		});
		btn1.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn1.getText();
				tf.setText(str);
			}
		});
		btn2.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn2.getText();
				tf.setText(str);
			}
		});
		btn3.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn3.getText();
				tf.setText(str);
			}
		});
		btn4.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn4.getText();
				tf.setText(str);
			}
		});
		btn5.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn5.getText();
				tf.setText(str);
			}
		});
		btn6.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn6.getText();
				tf.setText(str);
			}
		});
		btn7.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn7.getText();
				tf.setText(str);
			}
		});
		btn8.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn8.getText();
				tf.setText(str);
			}
		});
		btn9.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn9.getText();
				tf.setText(str);
			}
		});
		btn0.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				str += btn0.getText();
				tf.setText(str);
			}
		});
		
		
		primaryStage.setScene(scene);
		primaryStage.show(); // 창 띄우기
		

	}
	
	//추가) handle 안에 내용 함수 
	public void onclick(Event event) {
		Button imsi = (Button) event.getSource();
		String str_new = imsi.getText();
		String str_old = tf.getText();
		tf.setText(str_old + str_new);
	}
	
	
	public void myClick() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("전화번호");
		alert.setHeaderText(null);
		alert.setContentText(str);
		
		alert.showAndWait();
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
