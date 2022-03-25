package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {
	
	public int insertBoard(Connection conn, BoardVO jBoardVo) throws SQLException;
	
	public int deleteBoard(Connection conn, int boardNo) throws SQLException;

	public int updateBoard(Connection conn, BoardVO jBoardVo) throws SQLException;
	
	public BoardVO getBoard(Connection conn, int boardNo) throws SQLException;
	
	public List<BoardVO> getSearchBoardList(Connection conn, String jBoardTitle) throws SQLException;
	
	public List<BoardVO> getAllBoards(Connection conn) throws SQLException;
	
	public int setCountIncrement(Connection conn, int boardNo) throws SQLException; 
}