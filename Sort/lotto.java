package kr.or.ddit.basic;

import java.util.*;

public class lotto {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashSet numSet = new HashSet();
		Random r = new Random();

		while (true) {
			System.out.println("==========================");
			System.out.println("       LOTTO 프로그램       ");
			System.out.println("--------------------------");
			System.out.println("  1. Lotto 구입            ");
			System.out.println("  2. 프로그램 종료           ");
			System.out.println("==========================");
			System.out.print("메뉴선택 : ");
			int input = sc.nextInt();
			int money = 0;

			int num = 0;
			int re = 0;

			if (input == 1) {
				System.out.println("      Lotto 구입 시작      ");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				while (true) {
					System.out.print("금액 입력 : ");
					money = sc.nextInt();
					if (money < 1000) {
						System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
					} else if (money > 100000) {
						System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
					} else {
						num = money / 1000;
						re = money % 1000;
						
						System.out.println();
						System.out.println("행운의 로또번호는 아래와 같습니다.");
						for (int i = 0; i < num; i++) {
							numSet.clear();
							while (true) {
								if (numSet.size() != 6) {
									numSet.add(r.nextInt(45) + 1); // 1 ~ 45 사이의 랜덤한 숫자
								} else
									break;
							}
							ArrayList<Integer> numList = new ArrayList<Integer>(numSet);
							Collections.shuffle(numList);

							System.out.println("로또번호" + (i + 1) + " : " + numList);

						}
						System.out.println();
						System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + re + "원입니다.");
						System.out.println();
						break;
					}
				}

			}else if(input == 0){
				System.out.println("프로그램 종료");
				System.exit(0);
			}else
				continue;
		}

	}

}
