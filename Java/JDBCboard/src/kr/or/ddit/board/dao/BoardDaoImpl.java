package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	//싱글톤
	private static BoardDaoImpl boardDao;
	private BoardDaoImpl() {}
	public static BoardDaoImpl getInstance() {
		if(boardDao == null) boardDao = new BoardDaoImpl();
		return boardDao;
	}

	@Override
	public int insertBoard(Connection conn, Map<String, String> paramMap) throws SQLException {
		String sql = "insert into jdbc_board(board_no,board_title,board_writer,board_date,board_content)"
				+ " values(board_seq.nextVal, ? , ? , sysdate, ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, paramMap.get("title"));
		pstmt.setString(2, paramMap.get("writer"));
		pstmt.setString(3, paramMap.get("content"));
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}

	@Override
	public int deleteBoard(Connection conn, String board_id) throws SQLException {
		String sql = "delete from jdbc_board where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, board_id);
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}
	
	@Override
	public int updateBoard(Connection conn, Map<String, String> paramMap) throws SQLException {
		String sql = "update jdbc_board set "
				+ "BOARD_TITLE = ?, "
				+ "BOARD_CONTENT = ? "
				+ "where BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, paramMap.get("title"));
		pstmt.setString(2, paramMap.get("content"));
		pstmt.setString(3, paramMap.get("id"));
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}

	@Override
	public BoardVO getBoard(Connection conn, String board_id) throws SQLException {
		String sql = "select * from jdbc_board where BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board_id);

		ResultSet rs = pstmt.executeQuery();
		BoardVO boardVo = new BoardVO();
		if(rs.next()) {
			boardVo.setBoard_no(rs.getInt("board_no"));
			boardVo.setBoard_title(rs.getString("board_title"));
			boardVo.setBoard_writer(rs.getString("board_writer"));
			boardVo.setBoard_date(rs.getString("board_date"));
			boardVo.setBoard_cnt(rs.getInt("board_cnt"));
			boardVo.setBoard_content(rs.getString("board_content"));
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		return boardVo;
	}

	@Override
	public List<BoardVO> getBoards(Connection conn, String word) throws SQLException {
		List<BoardVO> boardList = null;
		String sql = "select * from jdbc_board where board_title like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, word);
		
		ResultSet rs = pstmt.executeQuery();
		boardList = new ArrayList<BoardVO>();
		while(rs.next()) {
			BoardVO boardVo = new BoardVO();
			boardVo.setBoard_no(rs.getInt("board_no"));
			boardVo.setBoard_title(rs.getString("board_title"));
			boardVo.setBoard_writer(rs.getString("board_writer"));
			boardVo.setBoard_date(rs.getString("board_date"));
			boardVo.setBoard_cnt(rs.getInt("board_cnt"));
			boardVo.setBoard_content(rs.getString("board_content"));
			
			boardList.add(boardVo);
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		
		return boardList;
	}

	@Override
	public List<BoardVO> getAllBoards(Connection conn) throws SQLException {
		List<BoardVO> boardList = null;
		String sql = "select * from jdbc_board";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		boardList = new ArrayList<BoardVO>();
		
		while(rs.next()) {
			BoardVO boardVo = new BoardVO();
			boardVo.setBoard_no(rs.getInt("board_no"));
			boardVo.setBoard_title(rs.getString("board_title"));
			boardVo.setBoard_writer(rs.getString("board_writer"));
			boardVo.setBoard_date(rs.getString("board_date"));
			boardVo.setBoard_cnt(rs.getInt("board_cnt"));
			boardVo.setBoard_content(rs.getString("board_content"));
			
			boardList.add(boardVo);
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		
		return boardList;
	}
	
	@Override
	public int upViews(Connection conn, String board_id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}