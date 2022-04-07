package kr.or.ddit.basic.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil3;

public class LprodDao {
	
	private static LprodDao dao;
	
	private LprodDao() {}
	
	public static LprodDao getInstance() {
		if(dao == null) dao = new LprodDao();
		
		return dao;
	}
	
	public List<LprodVO> getLprodList(){
		List<LprodVO> list = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from lprod";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<LprodVO>();
			
			while(rs.next()) {
				LprodVO vo  = new LprodVO();
				
				vo.setLprod_id(rs.getInt("lprod_id"));
				vo.setLprod_gu(rs.getString("lprod_gu"));
				vo.setLprod_nm(rs.getString("lprod_nm"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(rs!=null)try {pstmt.close();}catch(SQLException e) {}
			if(rs!=null)try {conn.close();}catch(SQLException e) {}
		}
		/*
		 	select * from mymember
			 where mem_id='입력한 id' and mem_pass='입력한 pass';
			
			위의 쿼리문을 처리한 결과를 반환하도록 구현한다.
		 */
		return list;
		
	}
	
}
