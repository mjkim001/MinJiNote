package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest06_1 {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Scanner sc = new Scanner(System.in);
	
	//시작 메서드
	public void startMember() {
		while(true) {
			int input = printMenu();
			
			
		}
	}
	
	//메뉴를 출력하고 선택한 작업번호를 반환하는 메소드
	private int printMenu() {
		System.out.println("-------------------------");
		System.out.println("      == 작업 예시 ==      ");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 수정");
		System.out.println("3. 자료 삭제");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("-------------------------");
		System.out.print("메뉴를 선택해주세요. ");
		
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
		new JDBCTest06_1().startMember();
	}
	
}
