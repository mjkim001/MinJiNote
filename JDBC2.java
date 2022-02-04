package k_jdbc;

import java.sql.*;

public class JDBC2 {

	public static void main(String[] args) {

		// 데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // @호스트이름:포트:SID
		String user = "MJ00";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			String sql = "select * " //cart테이블에서 회원 아이디가 a001이고 매입수량이 5개 이상인 것을 조회하시오
				    + " from cart "
				    + " where cart_member = ? "
					+ " and cart_qty > ?";//값을 ?로 대체하고 나중에 넣어준다.
			
			//mem_add1 like '%' || ? || '%';
			
			ps = con.prepareStatement(sql);
			ps.setString(1,"a001"); //첫번째 ? 자리를 "a001"로 대체
			ps.setInt(2, 5); //두번째 ?자리를 5로 대체한다.
			//ps.setObject(0, sql);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			//메타데이터: 데이터에 대한 데이터
	
			int columnCount = metaData.getColumnCount(); //행의 갯수 카운트
			
			while(rs.next()) {
				for(int i = 1; i<=columnCount;i++) {
					System.out.println(rs.getObject(i)+"\t"); //행의 갯수 만큼 반복문을 돌면서 한줄씩 출력
				}
				//System.out.println();
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
