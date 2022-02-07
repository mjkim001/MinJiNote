package k_jdbc;

import java.sql.*;
import java.util.*;

public class JDBCUtil {

	private static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // @호스트이름:포트:SID
	private static String user = "MJ00";
	private static String password = "java";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	//map<String, Object> selectOne(String sql) //?가 없을 때
	//map<String, Object> selectOne(String sql, List<Object> param) //?가 있을때
	//List<map<String, Object> > selectList(String sql) //?가 없을 때
	//List<map<String, Object> > selectList(String sql, List<Object> param) //?가 있을때
	//int update(String sql) //?가 없을 때
	//int update(String sql, List<Object> param) //?가 있을때

	public static int update(String sql) {
		int result = 0;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //순서 주의 (연 순서의 반대로) //null이 아닐때는 객체가 생성되지 않았을때를 의미한다. 
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(ps != null) try {ps.close();} catch (Exception e) {}
			if(con != null) try {con.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
	public static int update(String sql, List<Object> param) {
int result = 0;
		
		try {
			con = DriverManager.getConnection(url,user,password);
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //순서 주의 (연 순서의 반대로) //null이 아닐때는 객체가 생성되지 않았을때를 의미한다. 
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(ps != null) try {ps.close();} catch (Exception e) {}
			if(con != null) try {con.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
	public static HashMap<String, Object> selectOne(String sql){
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				for(int i = 1; i<=map.size();i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(ps != null) try {ps.close();} catch (Exception e) {}
			if(con != null) try {con.close();} catch (Exception e) {}
		}
		
		return map;
	}
	
	
	public static HashMap<String, Object> selectOne(String sql,List<Object> param){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(sql);
			
			for(int i =0; i<param.size();i++) {
				ps.setObject(i+1, param.get(i));
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				for(int i = 1; i<=columnCount;i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(ps != null) try {ps.close();} catch (Exception e) {}
			if(con != null) try {con.close();} catch (Exception e) {}
		}
		
		
		return map;
	}
	
	public static List<Map<String, Object>> selectList(String sql){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for(int i = 1; i<=columnCount;i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(ps != null) try {ps.close();} catch (Exception e) {}
			if(con != null) try {con.close();} catch (Exception e) {}
		}
		
		
		return list;
	}
	public static List<Map<String, Object>> selectList(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			con = DriverManager.getConnection(url,user,password);
			
			ps = con.prepareStatement(sql);
			
			for(int i =0; i<param.size();i++) {
				ps.setObject(i+1, param.get(i));
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for(int i = 1; i<=columnCount;i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try {rs.close();} catch (Exception e) {}
			if(ps != null) try {ps.close();} catch (Exception e) {}
			if(con != null) try {con.close();} catch (Exception e) {}
		}
		
		
		return list;
	}
}
