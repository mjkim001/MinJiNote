package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		
		//JDBC(Java Database Connectivity)
		// - 자바와 데이터베이스를 연결해주는 라이브러리
		// - ojdbc : 오라클  JDBC
		// JDBC 작성단계
		// 1. Connection 생성(DB연결)
		// 2. Statement 생성(쿼리 작성)
		// 3. Query 실행
		// 4. ResultSet에서 결과 추출(select인 경우)
		// 5. ResultSet, Statement, Connection
		
		//데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //@호스트이름:포트:SID
		String user = "MJ00";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		//DriverManager : 데이터베이스에 접속하기 위한 드라이버를 관리해주는 클래스
		try {
			con = DriverManager.getConnection(url,user,password);
			
			String sql = "select * from member";
			ps = con.prepareStatement(sql);
			
			//select인 경우
			rs = ps.executeQuery();
			
			//insert,update, delete
			//int result = ps.executeUpdate();
			//result : 영향을 받은 행의 수
			
			//next()를 처음 호출할 때 첫번째 줄을 가리킨다.
			while(rs.next()) {//다음 행이 존재하는가?
				String memId = rs.getString(1);
				String memPass = rs.getString("MEM_PASS");
				
				System.out.println("MEM_ID : "+ memId + " / MEM_PASS : " + memPass);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //순서 주의 (연 순서의 반대로) //null이 아닐때는 객체가 생성되지 않았을때를 의미한다. 
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(ps != null) try {ps.close();} catch (Exception e) {}
			if(con != null) try {con.close();} catch (Exception e) {}
		}
	}

}
