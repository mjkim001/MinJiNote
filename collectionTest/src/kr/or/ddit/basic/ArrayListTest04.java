package kr.or.ddit.basic;

import java.util.*;

public class ArrayListTest04 {
	public static void main(String[] args) {
		// 별명의 길이가 같은 것이 있을 경우를 처리하시오
		// 별명의 길이가 같은 것중 먼저 입력된 것을 출력
		
		ArrayList<String> name = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);

		System.out.println("5명의 이름을 입력해 주세요");
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());
		name.add(sc.nextLine());

		String result = "";

		for (String a : name) {
			if (a.length() > result.length()) {
				result = a;
			}
		}
		System.out.println(result);

	}
}
