/*
 * 	작성자 : 예현의
 * 	작성일 : 2022-05-11
 * 
 * 	Member에 대한 기능을 구현하는 MemberService 객체를 위한 interface
 * 
 * 	1. MemberList을 가져오는 getMemberList 구현을 위한 interface
 * 	2. 페이징을 위한 정보(MemberList, PageMaker) 값을 리턴해주는 getMemberListForPage 구현을 위한 interface
 */

package com.jsp.service;

import java.util.List;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberService {
	//1. MemberList을 가져오는 getMemberList 구현을 위한 interface
	public List<MemberVO> getMemberList() throws Exception;
	//1-1. overloading : Criteria객체를 통해 일정 멤버리스트를 가져오는 기능 구현을 위한 interface
	public List<MemberVO> getMemberList(Criteria cri) throws Exception;
	
	//2. 페이징을 위한 정보(MemberList, PageMaker) 값을 리턴해주는 getMemberListForPage 구현을 위한 interface
	public Map<String, Object> getMemberListForPage(Criteria cri) throws Exception;
	
	
	//회원 상세
	public MemberVO getMember(String id) throws Exception;
	
	//회원등록
	public void regist(MemberVO member) throws Exception;
	
	//회원수정
	public void modify(MemberVO member) throws Exception;
	
	//회원탈퇴
	public void remove(String id) throws Exception; 
	
	//회원상태변경 : enabled 1 사용 / 0 사용안함
	public void enabled(String id, int enabled) throws Exception;
	
}
