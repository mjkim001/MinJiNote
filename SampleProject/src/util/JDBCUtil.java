package util;

import java.sql.*;
import java.util.*;

public class JDBCUtil {
//art+shift+a 여러줄 한번에 작성 할 수 있는 모드
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";  
	private static String user = "MJ00"; 
	private static String password = "java";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	/*
	 * Map<String, Object> selectOne(String sql)
	 * Map<String, Object> selectOne(String sql, List<Object> param)
	 * List<Map<String, Object>> selectList(String sql)
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * int update(String sql)
	 * int update(String sql, List<Object> param)
	 */
	
	public static Map<String, Object> selectOne(String sql){
		HashMap<String, Object> map = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			if(rs.next()) {
				map = new HashMap<String, Object>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try{ rs.close(); } catch(Exception e) {}
			if(ps != null) try{ ps.close(); } catch(Exception e) {}
			if(con != null) try{ con.close(); } catch(Exception e) {}
		}
		
				
		return map;
		
		
		
	}
	
	public static Map<String, Object> selectOne(String sql, List<Object> param){
		HashMap<String, Object> map = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			rs = ps.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			if(rs.next()) {  //행이 존재할 때만 실행가능하도록 하기위함 & 행은 무조건 1개
				map = new HashMap<String, Object>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try{ rs.close(); } catch(Exception e) {}
			if(ps != null) try{ ps.close(); } catch(Exception e) {}
			if(con != null) try{ con.close(); } catch(Exception e) {}
		}
		
				
		return map;
		
		
		
	}
	
	
	
	public static List<Map<String, Object>> selectList(String sql){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();


			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try{ rs.close(); } catch(Exception e) {}
			if(ps != null) try{ ps.close(); } catch(Exception e) {}
			if(con != null) try{ con.close(); } catch(Exception e) {}
		}
		
				
		return list;
	}
	
	public static List<Map<String, Object>> selectList(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{ rs.close(); } catch(Exception e) {}
			if(ps != null) try{ ps.close(); } catch(Exception e) {}
			if(con != null) try{ con.close(); } catch(Exception e) {}
		}
		
		return list;
	}
	
	public static int update(String sql) {
		
		int result = 0;
		
		try {
			
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
		
			result = ps.executeUpdate();
			
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try{ rs.close(); } catch(Exception e) {}
			if(ps != null) try{ ps.close(); } catch(Exception e) {}
			if(con != null) try{ con.close(); } catch(Exception e) {}
			
		}
		
		return result; 
		
		
	}
	
	
	public static int update(String sql, List<Object> param) {
		int result = 0;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i+1, param.get(i));
			}
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{ rs.close(); } catch(Exception e) {}
			if(ps != null) try{ ps.close(); } catch(Exception e) {}
			if(con != null) try{ con.close(); } catch(Exception e) {}
		}
		
		return result; 
	}
}
