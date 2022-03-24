package kr.or.ddit.basic.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;
import kr.or.ddit.basic.mvc.dao.IMemberDao;
import kr.or.ddit.basic.mvc.dao.MemberDaoImpl;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl memservice;
	private IMemberDao dao;
	//생성자
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(memservice == null) memservice = new MemberServiceImpl();
		
		return memservice;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.insertMember(conn, memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.deleteMember(conn, memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateMember(conn, memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		List<MemberVO> memVo = null;
		
		try {
			conn = DBUtil3.getConnection();
			memVo = dao.getAllMember(conn);
		} catch (SQLException e) {
			memVo = null;
			e.printStackTrace();
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return memVo;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		int count = 0;
		try {
			conn = DBUtil3.getConnection();
			count = dao.getMemberCount(conn, memId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			cnt = dao.updateMember2(conn, paramMap);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}