package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {
	public static void main(String[] args) {
		//사용자로부터 데이터 입력받기
		
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		System.out.println("입력값 : " +str);
		
		for(int i=10; i>=1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
