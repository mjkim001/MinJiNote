package kr.or.ddit.board.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardServiceImpl implements IBoardService{
	private static BoardServiceImpl service;
	private IBoardDao dao;
	//생성자
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}
	@Override
	public int insertBoard(BoardVO jBoardVo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.insertBoard(conn, jBoardVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}
	@Override
	public int deleteBoard(int boardNo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.deleteBoard(conn, boardNo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}
	@Override
	public int updateBoard(BoardVO jBoardVo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateBoard(conn, jBoardVo);
		} catch (SQLException e) {
			cnt = 0 ;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}
	@Override
	public BoardVO getBoard(int boardNo) {
		Connection conn = null;
		BoardVO vo = null;
		try {
			
			conn = DBUtil3.getConnection();
			
			//조회수 증가
			int cnt = service.setCountIncrement(boardNo); 
			if(cnt==0) {
				return null;
			}
			vo = dao.getBoard(conn, boardNo);
		} catch (SQLException e) {
			vo = null;
		}
		return vo;
	}
	@Override
	public List<BoardVO> getSearchBoardList(String jBoardTitle) {
		Connection conn = null;
		List<BoardVO> boardList = null;
		try {
			conn = DBUtil3.getConnection();
			boardList = dao.getSearchBoardList(conn, jBoardTitle);
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
	public int setCountIncrement(int boardNo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.setCountIncrement(conn, boardNo);
		
		} catch (SQLException e) {
			cnt = 0 ;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}
	
	
	
	
	
}