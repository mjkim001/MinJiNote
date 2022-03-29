package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

// JDBC드라이버를 로딩하고 
// Connection객체를 생성하여 반환하는 메서드로 구성된 class
// (ResourceBundle객체로 properties파일 내용을 읽어와 설정하기)
public class DBUtill3 {
	static final Logger logger = Logger.getLogger(DBUtill3.class);
	
	static ResourceBundle bundle;
	
	
	// static 초기화 블럭
	static {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		logger.info("ResourceBundle객체 생성 -> dbinfo.propertis파일읽기");
		
		try {
			Class.forName(bundle.getString("driver"));
			logger.info("DB드라이버 로딩 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			logger.error("드라이버 로딩 실패");
			e.getStackTrace();
		}
	}

	
	// ------------------------
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
//			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","YHE20","java");
			
			conn = DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
			logger.debug("DB에 연결됨...");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			logger.error("DB 연결 실패 : " + e);
			conn = null;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
	}

}
