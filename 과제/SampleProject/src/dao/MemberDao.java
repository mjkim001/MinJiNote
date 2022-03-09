package dao;

import java.util.*;

import util.JDBCUtil;

//data access object 

public class MemberDao {

	private MemberDao() {

	}

	private static MemberDao instanse;

	public static MemberDao getinstanse() {
		if (instanse == null) {
			instanse = new MemberDao();
		}
		return instanse;
	}
	
	public int insertMember(Map<String,Object> param) { //TB_JDBC_MEMBER테이블에 데이터 추가하기 (회원가입하기)
		String sql = "INSERT INTO TB_JDBC_MEMBER"
				+ "	  VALUES (?,?,?)";
		List<Object> _param = new ArrayList<Object>();
		_param.add(param.get("MEM_ID"));
		_param.add(param.get("PASSWORD"));
		_param.add(param.get("MEM_NAME"));
		
		return JDBCUtil.update(sql,_param);
	}
	
	public Map<String, Object> selectMember(String memId, String password){ 
		//입력받은 ID와 비밀번호가 TB_JDBC_MEMBER테이블에 일치하는 데이터가 있는지 판단 
		
		String sql = "SELECT MEM_ID"
				+ " 		,PASSWORD"
				+ "			,MEM_NAME"
				+ "		FROM TB_JDBC_MEMBER"
				+ "	   WHERE MEM_ID = ?"
				+ "		 AND PASSWORD = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(memId);
		param.add(password);
		
		return JDBCUtil.selectOne(sql, param);
	}
	
	
	
}
