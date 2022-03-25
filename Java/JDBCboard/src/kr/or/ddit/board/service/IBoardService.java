package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	
	public int insertBoard(BoardVO jBoardVo);
	
	public int deleteBoard(int boardNo);
	
	public int updateBoard(BoardVO jBoardVo);
	
	public BoardVO getBoard(int boardNo);
	
	public List<BoardVO> getSearchBoardList(String jBoardTitle);
	
	public List<BoardVO> getAllBoards();
	
	public int setCountIncrement(int boardNo);
}