/*
 * 	작성자 : 예현의
 * 	작성일 : 2022-05-11
 * 	
 * 	MemberService interface를 구현하는 MemberServiceImpl객체
 * 	
 * 	1. 모든 멤버 객체를 리스트로 받아와 반환해주는 메서드 구현
 * 	2. 페이징을 위한 정보(MemberList, PageMaker) 값을 리턴해주는 getMemberListForPage
 * 
 */

package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	private SqlSessionFactory sqlSessionFactory;
	
	private MemberDAO memberDAO;
	
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	//1. 모든 멤버 객체를 리스트로 받아와 반환해주는 메서드 구현
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		// 오토 커밋 해제
		SqlSession session = sqlSessionFactory.openSession(false);
		List<MemberVO> memberList = null;
		
		try {
			// 모든 회원 정보에 대한 list를 가져온다
			memberList = memberDAO.selectMemberList(session);
			
			//에러가 발생하지 않았으면 commit
			session.commit();
		} catch (Exception e) {
			//Exception이 발생하였을 경우 rollback
			session.rollback();
			//Exception을 console창에 출력
			e.printStackTrace();
			//Exception을 전달
			throw e;
		}finally {
			if(session!=null) session.close();
		}
		
		//에러가 발생시 null이 반환된다
		return memberList;
	}

	//1-1. overloading : Criteria객체를 통해 일정 멤버리스트를 가져오는 기능
	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws Exception {
		// 오토 커밋 해제
		SqlSession session = sqlSessionFactory.openSession(false);
		List<MemberVO> memberList = null;
				
		try {
			// 모든 회원 정보에 대한 list를 가져온다
			memberList = memberDAO.selectMemberList(session,cri);
			
			//에러가 발생하지 않았으면 commit
			session.commit();
		} catch (Exception e) {
			//Exception이 발생하였을 경우 rollback
			session.rollback();
			//Exception을 console창에 출력
			e.printStackTrace();
			//Exception을 전달
			throw e;
		}finally {
			if(session!=null) session.close();
		}
				
		//에러가 발생시 null이 반환된다
		return memberList;
	}

	
	//2. 페이징을 위한 정보(MemberList, PageMaker) 값을 리턴해주는 getMemberListForPage
	@Override
	public Map<String, Object> getMemberListForPage(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		Map<String, Object> dataMap = null;
		
		try {
			//	처리..........
			//	1) member 리스트를 가져온다
			List<MemberVO> memberList = memberDAO.selectMemberList(session, cri);
			
			//	2) 페이지 메이커
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.selectMemberListCount(session));
			
			//	3) memberList와 PageMaker를 Map에 담는다
			dataMap = new HashMap<String, Object>();
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(session!=null) session.close();
		}
		
		return dataMap;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			return member;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(MemberVO member) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			memberDAO.insertMember(session, member);
		}finally {
			session.close();
		}
	}

	@Override
	public void modify(MemberVO member) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			memberDAO.updateMember(session, member);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			memberDAO.deleteMember(session, id);
		} finally {
			session.close();
		}
		
	}

	@Override
	public void enabled(String id, int enabled) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			memberDAO.enabledMember(session, id, enabled);
		} finally {
			session.close();
		}
		
	}
	
	

}
