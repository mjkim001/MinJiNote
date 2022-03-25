package kr.or.ddit.basic.mvc.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;
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
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.insertMember(smc, memVo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.deleteMember(smc, memId);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.updateMember(smc, memVo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlMapClient smc = null;
		List<MemberVO> memVo = null;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			memVo = dao.getAllMember(smc);
			
		} catch (SQLException e) {
			memVo = null;
			e.printStackTrace();
		}
		
		return memVo;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlMapClient smc = null;
		int count = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			count = dao.getMemberCount(smc, memId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		SqlMapClient smc = null;
		int cnt = 0;
		try {
			smc = SqlMapClientFactory.getClientFactory();
			cnt = dao.updateMember2(smc, paramMap);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	
}