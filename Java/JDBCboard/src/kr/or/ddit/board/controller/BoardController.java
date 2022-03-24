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

	private void start() {
		while(true) {
			int input = displayMenu();
			switch (input) {
			case 1:
				insertboard(); break;
			case 2:	//게시글보기
				selectBoard(); break;
			case 3: //검색
				researchBoard(); break;
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

	private void researchBoard() {
		System.out.println();
		System.out.println("검색작업");
		System.out.print("- 검색할 제목 입력 : ");
		String word = scan.next();
		
		if(word.equals("")) {
			return;
		}
		
		List<BoardVO> list = service.getBoards(word);
		while(true) {
		System.out.println("-------------------------------------------------------------");
		System.out.println("No	        제 목            작성자 	조회수");
		System.out.println("-------------------------------------------------------------");
		for(BoardVO vo : list) {
			System.out.println(" " + vo.getBoard_no() + "         " 
								   + vo.getBoard_title() + "        "
								   + vo.getBoard_writer() +"            "
								   + vo.getBoard_cnt());
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택>>");
		int input = scan.nextInt();
		
			switch (input) {
			case 1:
				insertboard(); break;
			case 2:	//게시글보기
				selectBoard(); break;
			case 3: //검색
				researchBoard(); break;
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

	private void selectBoard() {
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		String id = scan.next();
		//조회수 up
		//service.upView(id);
		BoardVO vo = service.getBoard(id);
		
		System.out.println();
		System.out.println(vo.getBoard_no() + "번글 내용");
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
			updateBoard(id);
			break;
		case 2:
			service.deleteBoard(id);
			break;
		case 3:
			return;
		}
		
		
	}

	private void updateBoard(String id) {
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		scan.nextLine();
		String title = scan.nextLine();
		
		System.out.print("- 내  용 : ");
		String content = scan.nextLine();
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		paramMap.put("title", title);
		paramMap.put("content", content);
		
		int cnt = service.updateBoard(paramMap);
		if(cnt > 0) {
			System.out.println();
			System.out.println(id + "번글이 수정되었습니다.");
		}else {
			System.out.println("게시판 수정에 실패하였습니다");
		}
		
	}

	private void insertboard() {
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		
		System.out.print("- 제  목 : ");
		scan.nextLine(); //버퍼비우기
		String title = scan.nextLine();
		
		System.out.print("- 작성자 : ");
		String writer = scan.next();
		
		System.out.print("- 내  용 : ");
		scan.nextLine(); //버퍼비우기
		String content = scan.nextLine();
		System.out.println();
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("title", title);
		paramMap.put("writer", writer);
		paramMap.put("content", content);
		
		int cnt = service.insertBoard(paramMap);
		
		if(cnt > 0) {
			System.out.println("새글이 추가되었습니다.");
		}else {
			System.out.println("새글등록에 실패하였습니다");
		}
		
	}

	private int displayMenu() {
		List<BoardVO> list = service.getAllBoards(); 
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("No	        제 목            작성자 	조회수 ");
		System.out.println("-------------------------------------------------------------");
		for(BoardVO vo : list) {
			System.out.println(" " + vo.getBoard_no() + "         " 
								   + vo.getBoard_title() + "        "
								   + vo.getBoard_writer() +"            "
								   + vo.getBoard_cnt());
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택>>");
		int input = scan.nextInt();
		
		return input;
	}

}