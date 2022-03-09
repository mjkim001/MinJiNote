package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터와 가위 바위 보는 난수를 이용해서 구하고, 
	사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
	
	입력 시간은 5초로 제안하고 카운트 다운을 진행한다.
 	5초 안에 입력이 없으면 게임에 진것으로 처리한다.
 	
 	5초 안에 입력이 있으면 승패를 구해서 출력한다.
 	
 	결과 예시) 
 	1) 5초 안에 입력이 없을 때
 	- 결 과 -
 	시간 초과로 당신이 졌습니다.
 	
    2) 5초 안에 입력이 있을 때
    - 결 과 -
    컴퓨터 : 가위
    당 신 : 바위
    결 과 : 당신이 이겼습니다.
 */
public class ThreadTest07 {
	
	public static void main(String[] args) {
		CountTime th = new CountTime();
		Thread th2 = new Thread(new InputData());
		th.start();
		th2.start();
		
	}

}
class InputData implements Runnable{
	public static boolean inputCheck = false;
	@Override
	public void run() {
		String player = JOptionPane.showInputDialog("가위, 바위, 보를 입력 하세요");
		inputCheck = true;
		int r = (int)Math.random() * 3;
		String computer = r == 0 ? "가위" : r == 1 ? "바위" : "보";   
		System.out.println("- 결 과 -");
		System.out.println("컴퓨터 : " + computer);
		System.out.println("당 신 : " + player);
		System.out.print  ("결 과 : ");
		switch (player) {
		case "가위":
			switch (computer) {
			case "가위": System.out.println("비겼습니다."); break;
			case "바위": System.out.println("당신이 이겼습니다."); break;
			case "보": System.out.println("당신이 졌습니다."); break;
			}
			break;
		case "바위":
			switch (computer) {
			case "가위": System.out.println("당신이 이겼습니다."); break;
			case "바위": System.out.println("비겼습니다."); break;
			case "보": System.out.println("당신이 졌습니다."); break;
			}
			break;
		case "보":
			switch (computer) {
			case "가위": System.out.println("당신이 졌습니다."); break;
			case "바위": System.out.println("당신이 이겼습니다."); break;
			case "보": System.out.println("비겼습니다."); break;
			}
			break;
		}
	}
	
}
class CountTime extends Thread{
	@Override
	public void run() {
		for(int i = 5; i >= 1; i--) {
			if(InputData.inputCheck) {
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			
			
		}
		if (InputData.inputCheck == false) {
			System.out.println("- 결 과 -");
			System.out.println("시간초과로 당신이 졌습니다.");
			System.exit(0);
		}

	}
}