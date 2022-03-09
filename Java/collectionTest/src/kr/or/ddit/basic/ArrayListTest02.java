package kr.or.ddit.basic;

import java.util.*;

public class ArrayListTest02 {
	public static void main(String[] args) {
		//문제 5명의 사람이름을 입력받아 ArrayList에 저장한 후 이들 중
		//'김'씨 성의 이름을 가진 이름을 모두 출력하시오
		
		ArrayList<String> name = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5명의 이름을 입력해 주세요");
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		
		
		//ver.1
		for(String a : name) {
			if(a.indexOf("김") == 0) {
				System.out.println(a);
			}
		}
		
		
		/*ver.2
		for(String a : name) {
			if(a.substring(0,1) == "김") {
				System.out.println(a);
			}
		}
		*/
		
		/*ver.3
		for(String a : name) {
			if(a.charAt(0) == '김') {
				System.out.println(a);
			}
		}
		*/
		/*ver.4
		for(String a : name) {
			if(a.startsWith("김")) {
				System.out.println(a);
			}
		}
		*/
		
		
		
		
		
		
	}
}
