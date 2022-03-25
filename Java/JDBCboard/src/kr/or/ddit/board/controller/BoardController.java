package kr.or.ddit.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
	private Scanner scan = new Scanner(System.in);
	private IBoardService service;
	
	//생성자
	public BoardController() {
		service = BoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardController().start();
	}
	
	// 시작 메서드
	private void start() {
		String title = null;
		int input = -1;
		while(true) {
			if(input != 3) title = null;
			
			input = displayMenu(title);
			
			switch (input) {
			case 1:
				insertboard(); break;
			case 2:	//게시글보기
				selectBoard(); break;
			case 3: //검색
				title = searchBoard(); break;
			case 0: //작업끝
				System.out.println();
				System.out.println("게시판 프로그램 종료....");
				System.exit(0);
				
			default:
				System.out.println("번호를 잘못 입력했습니다");
				break;
			}
		}
	}

	private String searchBoard() {
		scan.nextLine();
		System.out.println();
		System.out.println("검색작업");
		System.out.print("- 검색할 제목 입력 : ");
		String word = scan.nextLine();
		
		return word;
		
	}
	
	// 게시글 내용을 보여주는 메서드
	private void selectBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		int no = scan.nextInt();
		
		BoardVO vo = service.getBoard(no);
		
		System.out.println();
		System.out.println(no + "번글 내용");
		System.out.println("------------------------------------------------------------");
		System.out.println("- 제  목 : " + vo.getBoard_title());
		System.out.println("- 작성자  : " + vo.getBoard_writer());
		System.out.println("- 내  용 : " + vo.getBoard_content());
		System.out.println("- 작성일 : " + vo.getBoard_date());
		System.out.println("- 조회수 : " + vo.getBoard_cnt());
		System.out.println("------------------------------------------------------------");
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		
		int input = scan.nextInt();
		
		switch (input) {
		case 1:
			updateBoard(no);
			break;
		case 2:
			service.deleteBoard(no);
			break;
		case 3:
			return;
		}
		
		
	}

	private void updateBoard(int no) {
		scan.nextLine();
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		String title = scan.nextLine();
		
		System.out.print("- 내  용 : ");
		String content = scan.nextLine();
		
		BoardVO vo = new BoardVO();
		vo.setBoard_no(no);
		vo.setBoard_title(title);
		vo.setBoard_content(content);
		
		int cnt = service.updateBoard(vo);
		if(cnt > 0) {
			System.out.println();
			System.out.println(no + "번글이 수정되었습니다.");
		}else {
			System.out.println("게시판 수정에 실패하였습니다");
		}
		
	}
	
	// 새글을 작성하는 메서드
	private void insertboard() {
		scan.nextLine(); //버퍼비우기
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		
		System.out.print("- 제  목 : ");
		String title = scan.nextLine();
		
		System.out.print("- 작성자 : ");
		String writer = scan.nextLine();
		
		System.out.print("- 내  용 : ");
		String content = scan.nextLine();
		System.out.println();
		
		
		// 입력받은 데이터를 VO에 저장한다
		BoardVO vo = new BoardVO();
		vo.setBoard_title(title);
		vo.setBoard_writer(writer);
		vo.setBoard_content(content);
		
		int cnt = service.insertBoard(vo);
		
		if(cnt > 0) {
			System.out.println("새글이 추가되었습니다.");
		}else {
			System.out.println("새글등록에 실패하였습니다");
		}
		
	}
	
	// 게시글 목록을 보여주고 메뉴를 나타내며
	// 사용자가 입력한 메뉴 번호를 반환하는 메서드
	
	private int displayMenu(String title) {
		List<BoardVO> list = null;
		if(title == null || "".equals(title)) {
			list = service.getAllBoards(); 
		}else {
			list = service.getSearchBoardList(title);
		}
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("No	        제 목            작성자 	조회수 ");
		System.out.println("-------------------------------------------------------------");
		if(list == null || list.size() == 0) {
			System.out.println("출력할 게시글이 하나도 없습니다...");
		}else {
			for(BoardVO vo : list) {
				System.out.println(" " + vo.getBoard_no() 
					+ "\t" + vo.getBoard_title() 
					+ "\t" + vo.getBoard_writer() 
					+ "\t" + vo.getBoard_cnt());
			}
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택>>");
		int input = scan.nextInt();
		
		return input;
	}

}