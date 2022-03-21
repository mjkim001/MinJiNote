package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * lprod테이블에 새로운 데이터 추가하기
 * lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 * lprod_id는 현재의 lprod_id에서 제일 큰 값보다 1 크게 한다.
 * 
 * 그리고 lprod_gu가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 * */
public class JDBCTest05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MJ00", "java");
			conn = DBUtil.getConnection();
			while (true) {
				System.out.println("lprod 추가하기");

				System.out.println("상품 카테고리 번호 : ");
				String lprodGu = scan.next();

				System.out.println("상품 카테고리명 : ");
				String lprodNm = scan.next();
				
				stmt = conn.createStatement();
				String sql = "SELECT count(*)"
						+ "  	from LPROD "
						+ "    where LPROD_GU = '" + lprodGu +"'";
				
				rs = stmt.executeQuery(sql);
				
				String temp = "";
				while (rs.next()) {
					temp = rs.getString(1);
				}
				
				if(temp == "1") {
					continue;
				}
				
				String sql2 = "insert INTO lprod"
						+ "    (LPROD_ID, LPROD_GU, LPROD_NM)"
						+ "		values((select MAX(lprod_id) FROM lprod)+1,?,?)";
				
				pstmt = conn.prepareStatement(sql2);
				
				pstmt.setString(1, lprodGu);
				pstmt.setString(2, lprodNm);
				
				int cnt = pstmt.executeUpdate();
				
				System.out.println("반환값 : " + cnt);
				break;
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
//		} catch (ClassNotFoundException e) {
//			// TODO: handle exception
		}finally {
			try {if(rs==null) {rs.close();}} catch (Exception e2) {}
			try {if(stmt==null) {stmt.close();}} catch (Exception e2) {}
			try {if(pstmt==null) {pstmt.close();}} catch (Exception e2) {}
			try {if(conn==null) {conn.close();}} catch (Exception e2) {}
		}
	}
}
