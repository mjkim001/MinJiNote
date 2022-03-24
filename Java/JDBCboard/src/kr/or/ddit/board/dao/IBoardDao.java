package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	public int insertBoard(Connection conn, Map<String, String> paramMap) throws SQLException;
	
	public int deleteBoard(Connection conn, String board_id) throws SQLException;

	public int updateBoard(Connection conn, Map<String, String> paramMap) throws SQLException;
	
	public BoardVO getBoard(Connection conn, String board_id) throws SQLException;
	
	public List<BoardVO> getBoards(Connection conn, String word) throws SQLException;
	
	public List<BoardVO> getAllBoards(Connection conn) throws SQLException;
	
	public int upViews(Connection conn, String board_id) throws SQLException; 
}