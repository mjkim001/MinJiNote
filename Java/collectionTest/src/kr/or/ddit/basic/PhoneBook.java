package kr.or.ddit.basic;

import java.util.*;

public class PhoneBook {
    private Scanner sc = new Scanner(System.in);
    private HashMap<String, Phone> phoneBook = new HashMap<String, Phone>();

    public static void main(String[] args) {
        new PhoneBook().start();
    }

    public void start(){
        while(true) {

            int input = printMenu();

            switch(input){
                case 1: // 등록
                    input();
                    break;
                case 2: // 수정
                    update();
                    break;
                case 3: // 삭제
                    delete();
                    break;
                case 4: // 검색
                    search();
                    break;
                case 5:
                    printAll();
                    break;
                case 0:
                    System.exit(0);
                default :
                    System.out.println("번호를 다시 선택해 주세요.");
            }
        }
    }
    private int printMenu() {
        System.out.println();
        System.out.print("1. 전화번호 등록\n"
                + "2. 전화번호 수정\n"
                + "3. 전화번호 삭제\n"
                + "4. 전화번호 검색\n"
                + "5. 전화번호 전체 출력\n"
                + "0. 프로그램 종료\n"
                + "------------------\n"
                + "번호입력 >>");
        int num = sc.nextInt();
        return num;
    }
    void input() {
        sc.nextLine(); //이전 버퍼를 지워주기위해
        System.out.println();
        System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
        System.out.print("이름 >> ");
        String name = sc.nextLine();

        if(phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'은 이미 등록된 사람입니다.");
            return;
        }
        System.out.print("전화번호 >> ");
        String tel = sc.nextLine();
        System.out.print("주소 >> ");
        String addr = sc.nextLine();

        phoneBook.put(name, new Phone(name, tel, addr));
        System.out.println();
        System.out.println("'" + name + "'전화번호 정보 등록 완료!!");

    }

    private void update() {
        sc.nextLine();
        System.out.println();
        System.out.println("수정할 전화번호 정보를 입력하세요.");
        System.out.print("이름 >> ");
        String name = sc.nextLine();

        if(!phoneBook.containsKey(name)) {
            System.out.println("등록되지 않은 사람입니다.");
            return;
        }
        System.out.print("전화번호 >> ");
        String tel = sc.nextLine();

        System.out.print("주소 >> ");
        String addr = sc.nextLine();

        phoneBook.put(name, new Phone(name, tel, addr));
        System.out.println();
        System.out.println("'" + name + "'전화번호 정보 수정 완료!!");

    }

    private void delete() {
        sc.nextLine();
        System.out.println();
        System.out.println("삭제할 전화번호 정보를 입력하세요.");
        System.out.print("이름 >> ");
        String name = sc.nextLine();
        if(!phoneBook.containsKey(name)) {
            System.out.println("등록되지 않은 사람입니다.");
            return;
        }

        phoneBook.remove(name);
        System.out.println();
        System.out.println("'" + name + "'전화번호 정보 삭제 완료!!");
    }

    private void search() {
        sc.nextLine();
        System.out.println();
        System.out.println("검색할 전화번호 정보를 입력하세요.");
        System.out.print("이름 >> ");
        String name = sc.nextLine();

        if(!phoneBook.containsKey(name)) {
            System.out.println();
            System.out.println("등록되지 않은 사람입니다.");
            return;
        }
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("이 름    전 화 번 호      주    소");
        System.out.println("-----------------------------------");
        System.out.println(phoneBook.get(name).toString());
        System.out.println("-----------------------------------");
        System.out.println("검색 완료...");

    }

    private void printAll() {
        int num = 1;
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("번호    이 름    전 화 번 호      주    소");
        System.out.println("-----------------------------------------");

        for(Phone phone : phoneBook.values()) {
            System.out.println(" "+ num + "     " + phone.toString());
            num++;
        }
        System.out.println("-----------------------------------------");
        System.out.println("출력 완료...");
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

    @Override
    public String toString() {
        return  name + "  " + tel + " " + addr ;
    }
}