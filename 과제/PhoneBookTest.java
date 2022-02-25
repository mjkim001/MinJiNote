package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {
	public static void main(String[] args) {
		/*
		 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고,
			  Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
		
		전화번호 정보는 Map에 저장하여 관리한다.
		(key값은 입력받은 사람의 '이름'으로 하고,
		 value값은 'Phone클래스의 인스턴스'로 한다.)
		
		아래 메뉴의 기능을 모두 작성하시오.
		(삭제, 검색 기능은 '이름'을 입력 받아 처리한다.)
		
		메뉴 예시)
		1. 전화번호 등록
		2. 전화번호 수정    
		3. 전화번호 삭제	
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
	----------------------------
	실행예시)
		1. 전화번호 등록
		2. 전화번호 수정    
		3. 전화번호 삭제	
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
	   ------------------
		번호입력 >> 1
		
	   새롭게 등록할 전화번호 정보를 입력하세요.
	   이름 >> 홍길동
	   전화번호 >> 010-1111-1111
	   주소 >> 대전시 중구 오류동
	   
	   '홍길동'전화번호 정보 등록 완료!!

		1. 전화번호 등록
		2. 전화번호 수정    
		3. 전화번호 삭제	
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
	   ------------------
		번호입력 >> 1
			   
	   새롭게 등록할 전화번호 정보를 입력하세요.
	   이름 >> 홍길동
	   
	   '홍길동'은 이미 등록된 사람입니다.

		1. 전화번호 등록
		2. 전화번호 수정    
		3. 전화번호 삭제	
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
	   ------------------
		번호입력 >> 5
			   
	-----------------------------------------
	번호   이 름    전 화 번 호      주   소	
	------------------------------------------
	 1    홍길동  010-1111-1111 대전시 중고 오류동
	 ~~~
	 ~~~
	------------------------------------------
	출력 완료...
	
		1. 전화번호 등록
		2. 전화번호 수정    
		3. 전화번호 삭제	
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
	   ------------------
		번호입력 >> 0
		
	  프로그램을 종료합니다. 
		 */
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 전화번호 등록\n" 
		                     + "2. 전화번호 수정\n" 
		                     + "3. 전화번호 삭제\n" 
		                     + "4. 전화번호 검색\n" 
		                     + "5. 전화번호 전체 출력\n"
		                     + "0. 프로그램 종료\n" 
		                     + "------------------\n" 
		                     + "번호입력 >>");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				System.exit(0);
			}
		}
	}

	void showMenu() {
		System.out.println("1. 전화번호 등록\n" 
                + "2. 전화번호 수정\n" 
                + "3. 전화번호 삭제\n" 
                + "4. 전화번호 검색\n" 
                + "5. 전화번호 전체 출력\n"
                + "0. 프로그램 종료\n" 
                + "------------------\n" 
                + "번호입력 >>");
	}
	void add() {
		HashMap<String, Phone> map = new HashMap<String, Phone>();
		Scanner sc = new Scanner(System.in);
		
		String name;
		String tel;
		String addr;

		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		
		System.out.print("이름 >> ");
		name = sc.nextLine();
		
		System.out.print("전화번호 >> ");
		tel = sc.nextLine();
		
		System.out.println("주소 >> ");
		addr = sc.nextLine();
		
		Phone p = new Phone(name, tel, addr);
		if(!map.containsKey(name)) {
			map.put(name, p);
		}
		
	
	
	}
}
class Phone{
	String name;
	String tel;
	String addr;
	
	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	
}