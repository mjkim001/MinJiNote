package kr.or.ddit.member.service;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	//dao에 접근 - dao객체가 필요하다
	//service객체 생성 리턴 - controller가 사용
	
	private static IMemberDao dao;
	private static IMemberService service;

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDaoInstance();
	}
	public static IMemberService getServiceInstance() {
		if(service==null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		list = dao.selectAll();
		
		return list;
	}

}
