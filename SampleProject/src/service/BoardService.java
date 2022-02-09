package service;

import java.util.*;

import dao.BoardDao;
import util.*;

public class BoardService {

	private BoardService() {

	}

	private static BoardService instanse;

	public static BoardService getinstanse() {
		if (instanse == null) {
			instanse = new BoardService();
		}
		return instanse;
	}

	private BoardDao boardDao = BoardDao.getinstanse();

	public int boardList() {
    	List<Map<String,Object>> boardList = boardDao.selectBoardList();
    	
    	System.out.println("==============================");
    	System.out.println("번호\t제목\t작성자\t작성일");
    	System.out.println("-----------------------------------------------");
    	for(Map<String,Object>board:boardList) {
    		System.out.println(board.get("BOARD_NO")
    				+"\t: " + board.get("MEM_NAME")
    				+"\t: " + board.get("REG_DATE")
    				+"\t: " + board.get("TITLE")
    				+"\t: " + board.get("CONTENT"));
    	}
		int input =ScanUtil.nextInt();
		
		switch(input) {
		case 1: return View.BOARD_READ;
		case 2: return View.BOARD_INSERT;
		case 0:
			MemberService.LoginMember = null;
			return View.HOME;
		}
    	
    	return View.BOARD_LIST;
    }

	public int boardInsert() {
		System.out.println("=======================================");
		System.out.print("제목>");
		String tittle = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("MEM_ID", MemberService.LoginMember.get("MEM_ID"));
		param.put("TITTLE", tittle);
		param.put("CONTENT", content);
		
		
		int result = BoardDao.insertBoard(param);
		
		if(0 < result) {
			System.out.println("게시글 등록 성공");
		}else {
			System.out.println("게시글 등록 실패");
		}
		
		return View.BOARD_LIST;

	}

	public int boardRead() {
		System.out.print("게시글 번호>");
		boardNo = ScanUtil.nextInt();		
		
		//추가 필요) boardNo가 존재하는지 확인

		Map<String, Object> board = BoardDao.selectBoard(boardNo);
		
		System.out.println("------------------------------------");
		System.out.println("번호\t:" + board.get("BOARD_NO"));
		System.out.println("작성자\t:" + board.get("MEM_NAME"));
		System.out.println("작성일\t:" + board.get("REG_DATE"));
		System.out.println("제목\t:" + board.get("TITTLE"));
		System.out.println("내용\t:" + board.get("CONTENT"));
		System.out.println("------------------------------------");
		
		System.out.print("1.수정   2.삭제   0.목록>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.BOARD_UPDATE;
		case 2: return View.BOARD_DELETE;
		case 0:
			boardNo = 0;
			return View.BOARD_LIST;
		}
	
		//잘못입력하면 HOME화면
		boardNo = 0;
		return View.HOME;
	}

	public int boardUpdate() {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		
		int result = BoardDao.updateBoard(param);
		
		if(0 < result) {
			System.out.println("게시글 수정 성공");
		}else {
			System.out.println("게시글 수정 실패");
		}
		
		return View.BOARD_READ;
	}

	public int boardDelete() {
		System.out.print("정말 삭제하시겠습니까?>");
		String ans = ScanUtil.nextLine();
		
		if(ans.equals("Y")||ans.equals("y")) {
			List<Object> param = new ArrayList<Object>();
			param.add(boardNo);
			
			int result = BoardDao.deleteBoard(param);			
			
			if(0 < result) {
				System.out.println("게시글 삭제 성공");
			}else {
				System.out.println("게시글 삭제 실패");
			}
		}
		
		
		return View.BOARD_LIST;
	}
}
