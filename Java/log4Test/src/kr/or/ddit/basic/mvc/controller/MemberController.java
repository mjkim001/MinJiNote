package kr.or.ddit.basic.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.basic.mvc.service.IMemberService;
import kr.or.ddit.basic.mvc.service.MemberServiceImpl;
import kr.or.ddit.basic.mvc.vo.MemberVO;

public class MemberController {
	private Scanner scan = new Scanner(System.in);
	private IMemberService service;
	
	//생성자
	public MemberController() {
		service = MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new MemberController().start();
	}
	
	
	private void start() {
		while(true) {
			int input = displayMenu();
			switch (input) {
			case 1: 
				insertMember(); break;	// 추가
			case 2: 
				updateMember(); break;	// 수정
			case 3: 
				deleteMember(); break;	// 삭제
			case 4: 
				printAllMember(); break;	// 전체 출력
			case 5: 
				updateMember2(); break;	// 수정2
			case 0:	// 작업 끝
				System.out.println("프로그램이 종료됩니다");
				System.exit(0);

			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요");
				break;
			}
		}
	}
	

	

	private void updateMember2() {
		System.out.println("자료를 수정할 아이디를 입력해주세요");
		String id  = scan.next();
		
		int count = service.getMemberCount(id);
		if(count == 0) {
			System.out.println(id + "은(는) 없는 회원ID입니다.");
			return;
		}
		
		int num;
		String updateField = null;
		String updateTittle = null;
		do {
			System.out.println();
			System.out.println("수정할 항목을 입력하세요");
			System.out.println("1. 비밀번호  2. 회원이름  3. 전화번호  4. 회원주소");
			System.out.println("------------------------------------");
			System.out.print("수정항목 선택 >> ");
			num = scan.nextInt();
			
			switch (num) {
			case 1: updateField = "mem_pass";
					updateTittle = "비밀번호"; break;
			case 2: updateField = "mem_name";
					updateTittle = "회원이름"; break;
			case 3: updateField = "mem_tel";
					updateTittle = "전화번호"; break;
			case 4: updateField = "mem_addr";
					updateTittle = "회원주소"; break;
			default:
				System.out.println("수정 항목을 잘못 선택했습니다");
				System.out.println("다시 선택하세요");
				break;
			}
		}while(num < 1 || num > 5);
		
		System.out.println();
		System.out.print("새로운 " + updateTittle + " >> ");
		scan.nextLine();	//버퍼 비우기
		String updateData = scan.nextLine();
		
		// key값 정보 ==> 회원ID(memid), 수정할컬럼명(field), 수정할데이터(data)
		Map<String, String> paramMap = new HashMap<String, String>();
		
		paramMap.put("memid", id);			// 회원ID
		paramMap.put("field", updateField);	// 수정할 컬럼명
		paramMap.put("data", updateData);	// 수정할 데이터
		
		int cnt = service.updateMember2(paramMap);
		
		if(cnt > 0) {
			System.out.println("회원정보 수정 성공");
		}else {
			System.out.println("회원정보 수정 실패");
		}
		
		
	}

	private void printAllMember() {
		
		List<MemberVO> memList = service.getAllMember();
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println(" ID\t비밀번호\t이름\t전화번호\t주소");
		System.out.println("-----------------------------");
		if(memList == null || memList.size()==0) {
			System.out.println(" 출력한 자료가 하나도 없습니다." );
		}else {
			for(MemberVO memVo : memList) {
				System.out.println(memVo.getMem_id() + "\t" + memVo.getMem_pass() + "\t" + memVo.getMem_name() + "\t" +
						memVo.getMem_tel() + "\t" + memVo.getMem_addr());
			}
 		}
		
	}

	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원정보를 입력하세요");
		System.out.println("삭제할 회원ID >> ");
		String id = scan.next();
		
		int cnt = service.deleteMember(id);
		
		if(cnt > 0) {
			System.out.println("회원 삭제 성공");
		}else {
			System.out.println("회원이 없는 회원이거나 삭제 실패");
		}
		
	}

	private void updateMember() {
		System.out.println("자료를 수정할 아이디를 입력해주세요");
		String id  = scan.next();
		
		int count = service.getMemberCount(id);
		if(count == 0) {
			System.out.println(id + "은(는) 없는 회원ID입니다.");
			return;
		}
		
		System.out.println("수정할 내용을 입력하세요");
	
		System.out.print("새로운 비밀번호 >> ");
		String pw = scan.next();
		
		System.out.print("새로운 이름 >> ");
		String name = scan.next();
		
		System.out.print("새로운 전화번호 >>");
		String tel = scan.next();

		scan.nextLine();
		System.out.print("새로운 주소 >>");
		String addr = scan.nextLine();
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(id);
		memVo.setMem_pass(pw);
		memVo.setMem_name(name);
		memVo.setMem_tel(tel);
		memVo.setMem_addr(addr);
		
		int cnt = service.updateMember(memVo);
		
		if(cnt > 0) {
			System.out.println("회원정보 수정 성공");
		}else {
			System.out.println("회원정보 수정 실패");
		}
	}

	//회원 정보를 추가(입력)하는 메서드
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요");
		
		int count = 0;	// 입력한 회원ID의 개수가 저장될 변수
		String memId = "";	// 회원ID가 저장될 변수
		
		do {
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			// 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
			count = service.getMemberCount(memId);
			if(count>0) {
				System.out.println(memId + "는 이미 등록된 ID입니다.");
				System.out.println("다른 회원ID를 입력하세요");
			}
			
		}while(count > 0);
		
		System.out.print("비밀번호 >>");
		String pw = scan.next();
		
		System.out.print("회원이름 >>");
		String name = scan.next();
		
		
		System.out.print("전화번호 >>");
		String tel = scan.next();
		
		scan.nextLine();  //입력버퍼 비우기
		System.out.print("주소 >>");
		String addr = scan.nextLine();
		
		// 입력한 데이터를 VO객체에 저장한다
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(pw);
		memVo.setMem_name(name);
		memVo.setMem_tel(tel);
		memVo.setMem_addr(addr);
		
		int cnt = service.insertMember(memVo);
		
		if(cnt > 0) {
			System.out.println("회원정보 추가 성공");
		}else {
			System.out.println("회원정보 추가 실패");
		}
		
	}
	
	
	private int displayMenu() {
		System.out.println("---------------------------");
		System.out.println("	== 작업 선택 ==");
		System.out.println("  1. 자 료 추 가");
		System.out.println("  2. 자 료 수 정");
		System.out.println("  3. 자 료 삭 제");
		System.out.println("  4. 전 체 자 료 출 력");
		System.out.println("  5. 자 료 수 정 2");
		System.out.println("  0. 작 업 끝...");
		System.out.println("---------------------------");
		System.out.print("원하는 작업번호 >> ");
		return scan.nextInt();
	}
}
