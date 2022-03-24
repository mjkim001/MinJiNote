package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardServiceImpl implements IBoardService{
	private static BoardServiceImpl boardservice;
	private BoardDaoImpl dao;
	//생성자
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if(boardservice == null) boardservice = new BoardServiceImpl();
		
		return boardservice;
	}
	@Override
	public int insertBoard(Map<String, String> paramMap) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.insertBoard(conn, paramMap);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}
	@Override
	public int deleteBoard(String board_id) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.deleteBoard(conn, board_id);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}
	@Override
	public int updateBoard(Map<String, String> paramMap) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateBoard(conn, paramMap);
		} catch (SQLException e) {
			cnt = 0 ;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}
	@Override
	public BoardVO getBoard(String board_id) {
		Connection conn = null;
		BoardVO vo = null;
		try {
			conn = DBUtil3.getConnection();
			vo = dao.getBoard(conn, board_id);
		} catch (SQLException e) {
			vo = null;
		}
		return vo;
	}
	@Override
	public List<BoardVO> getBoards(String word) {
		Connection conn = null;
		List<BoardVO> boardList = null;
		try {
			conn = DBUtil3.getConnection();
			boardList = dao.getBoards(conn, word);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return boardList;
	}
	@Override
	public List<BoardVO> getAllBoards() {
		Connection conn = null;
		List<BoardVO> boardList = null;
		
		try {
			conn = DBUtil3.getConnection();
			boardList = dao.getAllBoards(conn);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return boardList;
	}
	@Override
	public int upViews(String board_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}