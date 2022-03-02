package kr.or.ddit.basic;

import java.util.*;

public class Hotel {

	private static Map<Integer, Room> roomMap = new HashMap<Integer, Room>();
	private Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		new Hotel().start();
	}

	private void init() {
		int single = 201;
		int dou = 301;
		int sweet = 401;

		for (int i = 0; i < 9; i++) {
			roomMap.put(single, new Room(single, "싱글룸"));
			roomMap.put(dou, new Room(dou, "더블룸"));
			roomMap.put(sweet, new Room(sweet, "스위트룸"));
			single++;
			dou++;
			sweet++;
		}
	}

	private void start() {
		init();
		System.out.println("======================================");
		System.out.println("\t호텔문을 열었습니다. 어서오세요.");
		System.out.println("======================================");
		System.out.println();

		while (true) {
			int input = printMenu();

			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				viewRoom();
				break;
			case 4:
				System.out.println();
				System.out.println("==================================");
				System.out.println("\t호텔문을 닫았습니다.");
				System.out.println("==================================");
				System.exit(0);
			default :
                System.out.println("번호를 다시 선택해 주세요.");
			}
		}
	}

	private int printMenu() {
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("----------------------------------");
		System.out.print("하실 업무를 입력해주세요 > ");
		int num = s.nextInt();
		
		return num;
	}

	private void checkOut() {
		System.out.println("------------------------------");
		System.out.println("체크아웃 작업");
		System.out.println("------------------------------");
		System.out.println("201~209 : 싱글룸");
		System.out.println("301~309 : 더블룸");
		System.out.println("401~409 : 스위트룸");
		System.out.println("------------------------------");
		System.out.print("방 번호 입력 => ");
		int roomNum = s.nextInt();
		s.nextLine();
		if (!roomMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
		} else {
			if (roomMap.get(roomNum).getUser().equals("-")) {
				System.out.println(roomNum + "호 객실은 체크인 한 사람이 없습니다. ");
			} else {
				System.out.println(roomNum + "호 객실의 " + roomMap.get(roomNum).getUser() + "님 체크아웃을 완료하였습니다.");
				roomMap.remove(roomNum);
			}
		}
	}

	private void checkIn() {
		System.out.println("------------------------------");
		System.out.println("체크인 작업");
		System.out.println("------------------------------");
		System.out.println("201~209 : 싱글룸");
		System.out.println("301~309 : 더블룸");
		System.out.println("401~409 : 스위트룸");
		System.out.println("------------------------------");
		System.out.print("방 번호 입력 => ");
		int roomNum = s.nextInt();
		s.nextLine();
		if (!roomMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
		} else {
			if (!roomMap.get(roomNum).getUser().equals("-")) {
				System.out.println(roomNum + "호 객실은 이미 손님이 있습니다.");
			} else {
				System.out.print("체크인 하실 고객명을 입력해주세요 > ");
				String user = s.nextLine();
				roomMap.get(roomNum).setUser(user);
				System.out.println(user + "님 체크인이 완료되었습니다.");
			}
		}
	}

	private void viewRoom() {
		Set<Integer> roomSet = roomMap.keySet();
		List<Integer> roomList = new ArrayList<>(roomSet);
		Collections.sort(roomList);

		System.out.println("============================");
		System.out.println("방 번호\t방 종류\t투숙객");
		System.out.println("============================");
		for (Integer roomNum : roomList) {
			Room room = roomMap.get(roomNum);
			System.out.println(room.num + "\t" + room.name + "\t" + room.user);
			System.out.println("----------------------------");
		}
	}

}

class Room {
	int num;
	String name;
	String user = "-";

	public Room(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}