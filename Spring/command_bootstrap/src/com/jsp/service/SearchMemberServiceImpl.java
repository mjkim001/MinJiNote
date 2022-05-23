package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dao.SearchMemberDAO;
import com.jsp.dao.SearchMemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;
import com.jsp.exception.NotMatchSearchCriteria;

public class SearchMemberServiceImpl extends MemberServiceImpl{
	
	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SearchMemberDAO memberDAO = new SearchMemberDAOImpl();
	
	@Override
	public Map<String, Object> getMemberListForPage(Criteria cri) throws Exception{

		if(cri instanceof SearchCriteria) {
			SearchCriteria searchCri = (SearchCriteria)cri;
			
			
			SqlSession session = sqlSessionFactory.openSession(false);
			Map<String, Object> dataMap = null;
			
			try {
				//	처리..........
				//	1) member 리스트를 가져온다
				List<MemberVO> memberList = memberDAO.selectSearchMemberList(session, searchCri);
				
				//	2) 페이지 메이커
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(memberDAO.selectSearchMemberListCount(session, searchCri));
				
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
			
		}else {
			throw new NotMatchSearchCriteria();
		}
		
		
	}
	

}
