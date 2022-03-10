package k_jdbc;

import java.util.*;

public class JDBCTest {
	public static void main(String[] args) {
		String sql = "select *"
				+ " from cart"
				+ " where cart_member = ?"
				+ " and cart_qty > ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add("a001");
		param.add(5);
		
		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);
		
		System.out.println(list);
		
		
		String sql1 = "select *"
				+ " from cart"
				+ " where cart_member = a001"
				+ " and cart_qty > 5";
		
		List<Map<String, Object>> list1 = JDBCUtil.selectList(sql1);
		
		System.out.println(list1);
		
		//
		
		String sql2 = "select *"
				+ " from cart"
				+ " where cart_member = a001"
				+ " and cart_qty > 5";
		
		HashMap<String, Object> map = JDBCUtil.selectOne(sql2);
		
		System.out.println(map);
		
		//
		
		String sql3 = "select *"
				+ " from cart"
				+ " where cart_member = ?"
				+ " and cart_qty > ?";
		
		ArrayList<Object> param1 = new ArrayList<Object>();
		param.add("a001");
		param.add(5);
		
		HashMap<String, Object> map1 = JDBCUtil.selectOne(sql3, param1);
		
		System.out.println(map1);
		
		//
		
		String sql4 = "select *"
				+ " from cart"
				+ " where cart_member = a001"
				+ " and cart_qty > 5";
		
		int update = JDBCUtil.update(sql4);
		
		System.out.println(update);
		
		//
		
		String sql5 = "select *"
				+ " from cart"
				+ " where cart_member = ?"
				+ " and cart_qty > ?";
		
		ArrayList<Object> param2 = new ArrayList<Object>();
		param.add("a001");
		param.add(5);
		
		int update2 = JDBCUtil.update(sql4,param2);
		
		System.out.println(update2);
		
		
	}
}
