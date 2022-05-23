/*	
 	작성자 : 예현의
	작성일 : 2022-05-12
	
	MemberDAO를 만들기 위한 interface
	
	1. member의 전체리스트를 가져오는 메서드 구현을위한 interface
	2. member의 전체 리스트(일반) 갯수를 가져오는 메서드 구현을 위한 interface
*/
package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.MemberVO;

public interface MemberDAO {
	
	//1. member의 전체리스트를 가져오는 메서드 구현을위한 interface
	List<MemberVO> selectMemberList(SqlSession session) throws Exception;
	//1-1. overloading : Criteria객체를 통해 일정 멤버리스트를 가져오는 메서드 구현을 위한 interface
	List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws Exception;

	
	//일반 리스트 전체 개수
	int selectMemberListCount(SqlSession session) throws Exception;
	
	//회원 정보 조회
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
	
	//회원추가
	void insertMember(SqlSession session, MemberVO member) throws SQLException;
	
	//회원 수정
	void updateMember(SqlSession session, MemberVO member) throws SQLException;
	
	//회원 석재
	void deleteMember(SqlSession session, String id) throws SQLException;
	
	void enabledMember(SqlSession session, String id, int enabled) throws SQLException;
	
	
	
}
