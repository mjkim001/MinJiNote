package kr.or.ddit.basic.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.basic.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl memDao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(memDao == null) memDao = new MemberDaoImpl();
		
		return memDao;
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		Object obj = smc.insert("member.insertMember",memVo);
	
		if(obj == null) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		int cnt = smc.delete("member.deleteMember", memId);
		
		return cnt;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO memVo) throws SQLException {
		int cnt = smc.update("member.updateMember", memVo);
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember(SqlMapClient smc) throws SQLException {
		List<MemberVO> list = smc.queryForList("member.getAllMember");
		
		return list;
	}

	@Override
	public int getMemberCount(SqlMapClient smc, String memId) throws SQLException {
		int count = (int) smc.queryForObject("member.getMemberCount",memId);
		
		return count;
	}

	@Override
	public int updateMember2(SqlMapClient smc, Map<String, String> paramMap) throws SQLException {
		int cnt = smc.update("member.updateMember2", paramMap);
		return cnt;
	}
	
}