package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07_1 {
	public static boolean inputCheck;
	
	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		//난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		
		String[] data = {"가위","바위","보"};
		int index = (int)(Math.random()*3); //0~2사이의 난수 만들기
		
		//난수를 이용해서 컴퓨터의 가위바위보를 정한다.
		String com = data[index];
		
		//사용자의 가위바위보 정하기
		gt.start();//카운트다운시작
		
		String user = null;
		do {
			user = JOptionPane.showInputDialog("가위바위보를 입력하시오");
		}while(!(user.equals("가위")||user.equals("바위")||user.equals("보")));
		
		inputCheck = true;
		
		//결과 판정하기
		String result = "";
		if(com.equals(user)) {
			result = "비겼습니다.";
		}else if(com.equals("가위")&&user.equals("보")
				|| com.equals("바위")&&user.equals("가위")
				|| com.equals("보")&&user.equals("바위")) {
			result = "당신이 졌습니다.";
		}else {
			result = "당신이 이겼습니다.";
		}
		
		//결과 출력하기
		System.out.println("- 결 과 -");
		System.out.println("컴퓨터 : " + com);
		System.out.println("당 신 : " + user);
		System.out.print  ("결 과 : " + result);
		
	}
}

class GameTimer extends Thread{
	@Override
	public void run() {
		System.out.println("카운트다운을 시작합니다...");
		for(int i = 5; i >= 1; i--) {

			if(ThreadTest07_1.inputCheck) {
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

		}

		System.out.println("- 결 과 -");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);

	}
}