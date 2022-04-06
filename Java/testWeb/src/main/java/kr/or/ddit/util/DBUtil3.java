package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 * JDBC드라이버를 로딩하고 
 * Connection객체를 생성하여 반환하는 메소드로 구성된 class
 * (ResourceBundle객체로 properties파일 내용을 읽어와 설정하기)
 */
public class DBUtil3 {
	static ResourceBundle bundle;
	
	// static 초기화 블럭
	static {
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.getStackTrace();
		}
	}

	// ------------------------
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
	public static void main(String[] args) {
	}
}