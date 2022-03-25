package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	//싱글톤
	private static BoardDaoImpl dao;
	private BoardDaoImpl() {}
	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public int insertBoard(Connection conn, BoardVO jBoardVo) throws SQLException {
		String sql = "insert into jdbc_board(board_no,board_title,board_writer,board_date,board_cnt,board_content)"
				+ " values(board_seq.nextVal, ? , ? , sysdate, 0, ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, jBoardVo.getBoard_title());
		pstmt.setString(2, jBoardVo.getBoard_writer());
		pstmt.setString(3, jBoardVo.getBoard_content());
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}

	@Override
	public int deleteBoard(Connection conn, int boardNo) throws SQLException {
		String sql = "delete from jdbc_board where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, boardNo);
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}
	
	@Override
	public int updateBoard(Connection conn, BoardVO jBoardVo) throws SQLException {
		String sql = "update jdbc_board set "
				+ "BOARD_TITLE = ?, "
				+ "BOARD_CONTENT = ? ,"
				+ "BOARD_DATE = sysdate "
				+ "where BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, jBoardVo.getBoard_title());
		pstmt.setString(2, jBoardVo.getBoard_content());
		pstmt.setInt(3, jBoardVo.getBoard_no());
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}

	@Override
	public BoardVO getBoard(Connection conn, int boardNo) throws SQLException {
		String sql = "select board_no"
				+ ",  board_title"
				+ ",  board_writer"
				+ ",  to_char(board_date, 'YYYY-MM-DD') as board_date"
				+ ",  board_cnt"
				+ ",  board_content"
				+ " from jdbc_board where BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);

		ResultSet rs = pstmt.executeQuery();
		
		BoardVO boardVo = null;
		if(rs.next()) {
			boardVo = new BoardVO();
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
	public List<BoardVO> getSearchBoardList(Connection conn, String jBoardTitle) throws SQLException {
		List<BoardVO> boardList = null;
		String sql = "select board_no, board_title, board_writer, to_char(board_date, 'YYYY-MM-DD') board_date, "
					     + " board_cnt, board_content "
					     + " from jdbc_board"
					     + " where board_title like '%' || ? || '%' "
					     + " order by board_no desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, jBoardTitle);
		
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
		String sql = "select board_no"
					   + ",  board_title"
					   + ",  board_writer"
					   + ",  to_char(board_date, 'YYYY-MM-DD') board_date"
					   + ",  board_cnt"
					   + ",  board_content"
				    + " from jdbc_board "
				    + " order by board_no desc";
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
	public int setCountIncrement(Connection conn, int boardNo) throws SQLException {
		String sql = "update jdbc_board set "
				+ " board_cnt = board_cnt + 1 "
				+ " where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		
		int cnt = pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		
		return cnt;
	}

}