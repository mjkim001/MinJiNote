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
	}
}
