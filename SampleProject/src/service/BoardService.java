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
		case 1:
		case 2:
		case 0:
			MemberService.LoginMember = null;
			return View.HOME;
		}
    	
    	return View.BOARD_LIST;
    }

	public int boardInsert() {
		return View.BOARD_INSERT;
	}

	public int boardRead() { return View.BOARD_READ;
	}
}
