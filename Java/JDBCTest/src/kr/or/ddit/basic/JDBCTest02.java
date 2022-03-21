package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제) 사용자로부터 lprod_id값을 입력받아서 
//		입력된 값보다 lprod_id가 큰 자료들을 출력하시오
public class JDBCTest02 {
	public static void main(String[] args) {
		// DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB연결 ==> Connection객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MJ00", "java");

			// 3. SQL문 작성하기
			String sql = "select * from lprod";

			// 4. Statement객체 생성 ==> 질의를 처리하는 객체 생성
			stmt = conn.createStatement();

			// 5. SQL문을 DB서버로 보내서 결과를 얻어온다
			// (실행할 SQL문의 select문이기 때문에 결과가 ResultSet에 저장되어 반환한다.)
			rs = stmt.executeQuery(sql);

			// 6. 결과 처리하기 ==> 한 레코드씩 화면에 출력하기
			// ResultSet의 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다.
			System.out.println("== 쿼리문 처리 결과 ==");

			// rs.next() ==> ResultSet객체의 데이터를 가리키는 포인터를 다음번째 위치로
			// 이동시키고 그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.
			System.out.println("Lprod_ID | Lprod_GU | Lprod_NM");
			while (rs.next()) {
				System.out.println(rs.getInt("lprod_id")+ "\t" + rs.getString(2) + "\t" +rs.getString(3));
			}
			System.out.println("---------------------------------------");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("숫자를 입력해주세요");
			int num = sc.nextInt();
			
			String sql2 = "select * "
					+ "		 from lprod"
					+ "		where lprod_id > " + num;
			
			rs = stmt.executeQuery(sql2);
			System.out.println("---------------------------------------");
			System.out.println("Lprod_ID | Lprod_GU | Lprod_NM");
			while (rs.next()) {
				System.out.println(rs.getInt("lprod_id")+ "\t" + rs.getString(2) + "\t" +rs.getString(3));
			}
			System.out.println("---------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. 파일 반납
			try {if(rs==null) {rs.close();}} catch (Exception e2) {}
			try {if(stmt==null) {stmt.close();}} catch (Exception e2) {}
			try {if(conn==null) {conn.close();}} catch (Exception e2) {}

		}
	}
}
