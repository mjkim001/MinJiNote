package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Maina extends Application {
	
	TextField tf;
	TextArea ta;
	String com = "";
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Maina.fxml"));
		Scene scene = new Scene(root); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
//		Button btn = (Button) scene.lookup("#btn");
//		tf = (TextField) scene.lookup("#tf");
//		ta = (TextArea) scene.lookup("#ta");
//		
//		setCom();
//		
//		btn.setOnMouseClicked(new EventHandler<Event>() {
//			@Override
//			public void handle(Event event) {
//				onClick();
//				
//			}
//		});
		
		primaryStage.setScene(scene);
		primaryStage.show(); // 창 띄우기
	}
	
	
	public void onClick() {
		String str_old = ta.getText();
		String str_new = getBallStrike();
		ta.setText(str_old + str_new);
		tf.setText(""); //초기화

	}
	
	public String getBallStrike() {
		String mytry = tf.getText();
		
		int strike = 0;
		int ball = 0;
		
		
		String m1 = mytry.substring(0,1);
		String m2 = mytry.substring(1,2);
		String m3 = mytry.substring(2,3);
		
		String c1 = com.substring(0,1);
		String c2 = com.substring(1,2);
		String c3 = com.substring(2,3);
		
		if(m1.equals(c1)) strike++;
		if(m2.equals(c2)) strike++;
		if(m3.equals(c3)) strike++;
		
		
		if(m1.equals(c2)||m1.equals(c3)) ball++;
		if(m2.equals(c1)||m2.equals(c3)) ball++;
		if(m3.equals(c1)||m3.equals(c2)) ball++;
		
		if(strike == 3) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("baseball");
			alert.setHeaderText(null);
			alert.setContentText("Congratulation");
			
			alert.showAndWait();
		}
		
		String ret = mytry + " - " + strike + "S " + ball + "B" + "\n";
		
		return ret;
	}
	
	public void setCom() {
		
		String[] arr9 = {"1","2","3","4","5","6","7","8","9"};
		
		ArrayList<String> arr3 = new ArrayList<String>();
		
		while(arr3.size() < 3) {
			int rnd = (int)Math.random()*9;
			if(!arr9[rnd].equals("-1")) {
				arr3.add(arr9[rnd]);
				arr9[rnd] = "-1";
			}
			
		}
		
		//todo
		com = arr3.get(0) + arr3.get(1) + arr3.get(2);
		System.out.println(com);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
