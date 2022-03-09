package kr.or.ddit.basic;

import java.util.*;

public class BaseballTest {
	public static void main(String[] args) {
		// 문제
		// Set을 활용하여 숫자 야구 게임 프로그램을 작성하시오

		// 예시
		// 컴퓨터 난수 ==> 9 5 7
		// 상황예시)
		// 숫자입력 : 3 5 6
		// 3 5 6 ==> 1S 0B
		// 숫자입력 : 7 8 9
		// 7 8 9 ==> 0S 2B
		// 숫자입력 : 9 7 5
		// 9 7 5 ==> 1S 2B
		// 숫자입력 : 9 5 7
		// 9 5 7 ==> 3S

		// 축하합니다...
		// 당신은 4번째만에 맞췄습니다.

		Random r = new Random();
		HashSet num = new HashSet();
		Scanner sc = new Scanner(System.in);

		// 중복되지 않는 난수 3개를 생성
		while (true) {
			if (num.size() != 3) {
				num.add(r.nextInt(9) + 1); // 1 ~ 9 사이의 랜덤한 숫자
			} else
				break;
		}

		ArrayList<Integer> numList = new ArrayList<Integer>(num);
		Collections.shuffle(numList);
		System.out.println("컴퓨터 난수 : " + numList);

		ArrayList<Integer> player = new ArrayList<Integer>();

		int n = 0;

		while (true) {
			int s = 0;
			int b = 0;
			int o = 0;
			player.clear();
			
			System.out.print("숫자입력 : ");
			player.add(sc.nextInt());
			player.add(sc.nextInt());
			player.add(sc.nextInt());

			for (int i = 0; i < player.size(); i++) {
				if (numList.contains(player.get(i))) {
					if (numList.indexOf(player.get(i)) == i) {
						s++;
						continue;
					} else {
						b++;
						continue;
					}	
				} else
					o++;
			}
			n++;
			System.out.println( player.get(0) + " " + player.get(1) + " " + player.get(2) + " ==> " 
								+ s + "S " + b + "B " + o + "O ");

			if (s == 3) {
				System.out.println("축하합니다...");
				System.out.println("당신은" + n + "번째만에 맞췄습니다.");
				break;
			}

		}

	}
}
