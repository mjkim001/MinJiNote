package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	
	public int insertBoard(Map<String, String> paramMap);
	
	public int deleteBoard(String board_id);
	
	public int updateBoard(Map<String, String> paramMap);
	
	public BoardVO getBoard(String board_id);
	
	public List<BoardVO> getBoards(String word);
	
	public List<BoardVO> getAllBoards();
	
	public int upViews(String board_id);
}