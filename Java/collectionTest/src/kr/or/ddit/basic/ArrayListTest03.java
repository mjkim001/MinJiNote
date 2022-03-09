package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {
	public static void main(String[] args) {
		// 5명의 별명을 입력받아 ArrayList에 저장하고 제일긴 별명을 반환

		// 별명의 길이가 같은 것이 있을 경우를 처리하시오

		ArrayList<String> name = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		System.out.println("5명의 이름을 입력해 주세요");
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		
		String result = "";
		
		for(String a : name) {
			if(a.length() > result.length()) {
				result = a;
			}
		}
		for(String a : name) {
			if(a.length() == result.length()) {
				System.out.println(a);
			}
		}
		
		

	}
}
