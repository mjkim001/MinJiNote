package kr.or.ddlt.basic;

import java.util.Arrays;

/*
 * 10마리의 말들이 경주하는 경마 프로그램 작성하기
 * 
 * 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데, 이 클래스는 말 이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
 * 그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
 * 
 * 경기 구간은 1~50 구간으로 되어있다.
 * 
 * 경기가 끝나면 등수 순으로 출력한다.
 * 
 * 경기가 진행 중일때 중간 중간에 말들의 위치를 아래와 같이 나타낸다.
 * 에)
 * 		01번말 : --->--------------------------
 * 		02번말 : ------->----------------------
 * 		...
 * 		10번말 : ---------->-------------------
 */
public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horses = new Horse[] {
				new Horse("01번말"),
				new Horse("02번말"),
				new Horse("03번말"),
				new Horse("04번말"),
				new Horse("05번말"),
				new Horse("06번말"),
				new Horse("07번말"),
				new Horse("08번말")
		};
		
		ViewCurrent viewCurrent = new ViewCurrent(horses);
		
		System.out.println("경기가 시작됐습니다.");
		for(Horse horse : horses) {
			horse.start();
		}
		viewCurrent.start();
		
		
		for(Horse horse : horses) {
			try {
				horse.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			viewCurrent.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("경기가 끝났습니다.");
		Arrays.sort(horses);
		System.out.println("----- 결과 -----");
		for(Horse hs : horses) {
			System.out.println(hs.rank + "등 : " + hs.name);
		}
	}

}

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;
	public String name;
	int rank;
	int current = 1;
	
	public Horse(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		for(int i = 1; i <= 50; i++) {
			current = i;
			try {
				Thread.sleep((int)(Math.random() * 300 + 201));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		rank = ++currentRank;
	}

	@Override
	public int compareTo(Horse o) {
		return Integer.compare(rank, o.rank);
	}
}


class ViewCurrent extends Thread{
	Horse[] horses;

	public ViewCurrent(Horse[] horses) {
		super();
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while(true) {
			if(Horse.currentRank == horses.length) break;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			for(Horse horse : horses) {
				System.out.print(horse.name + "의 현재위치 : ");
				for(int i = 1; i <= 50; i++) {
					if(horse.current == i) {
						System.out.print("▶");
					}else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
}
