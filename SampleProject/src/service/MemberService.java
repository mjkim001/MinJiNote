package service;

import java.util.*;

import dao.MemberDao;
import util.ScanUtil;
import util.View;

public class MemberService {
	//싱글톤 패턴 : 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private MemberService() {
		
	}
	private static MemberService instanse;
	public static MemberService getinstanse() {
		if(instanse == null) {
			instanse = new MemberService();
		}
		return instanse;
	}
	
	public static Map<String, Object> LoginMember;
	
	private MemberDao memberDao = MemberDao.getinstanse();
	
	public int join() {
		System.out.println("============= 회원가입 =============");
		System.err.println("아이디 > ");
		String memId = ScanUtil.nextLine();
		System.err.println("비밀번호 > ");
		String password = ScanUtil.nextLine();
		System.err.println("이름 > ");
		String memName = ScanUtil.nextLine();
		
		//아이디 중복확인 
		//비밀번호 확인
		//유효성 검사(정규표현식)
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("MEM_ID",memId);
		param.put("PASSWORD",password);
		param.put("MEM_NAME",memName);
		
		int result = memberDao.insertMember(param);
		
		if(0 < result) {
			System.out.println("회원가입 성공");
		}
		else
			System.out.println("회원가입 실패");
		return View.HOME;
	}

	public int login() {
		
		System.out.println("============= 로그인 ==============");
		System.err.println("아이디 > ");
		String memId = ScanUtil.nextLine();
		System.err.println("비밀번호 > ");
		String password = ScanUtil.nextLine();
		
		Map<String, Object> member = memberDao.selectMember(memId,password);
		//데이터가 존재하면 return값이 있고 데이터가 존재하지 않으면 null을 반환
		if(member == null) {
			System.out.println("아이디 또는 비밀번호를 잘못입력하셨습니다");
		}
		else { 
			System.out.println("로그인 성공");
			LoginMember = member; //입력받은 사용자 정보를 LoginMember에 저장
			return View.BOARD_LIST; //게시판 출력
		}
			
		return View.HOME; //아이디&비밀번호 데이터가 존재하지 않으면 다시 로그인을 할 수 있도록 login을 return한다.
		
	}
	
}
