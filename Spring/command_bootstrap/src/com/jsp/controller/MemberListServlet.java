/*
 * 	작성자 : 예현의
 * 	작성일 : 2022-05-11
 * 
 * 	get방식으로 통신시 데이터 베이스에 등록된 회원 정보를 받아와 출력해주는 servlet
 * 
 * 
 */

package com.jsp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;


@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
    
	private MemberService memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/list.jsp";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		
		Criteria cri = new Criteria();
		
		
		// 누적 boolean
		// pageParam과 perPageNumParam이 널이 아니거나 비어있지 않은 경우에만 True
		boolean criFlag = true;
		criFlag = criFlag && pageParam != null
						  && !pageParam.isEmpty()
						  && perPageNumParam != null
						  && !perPageNumParam.isEmpty();
		
		if(criFlag) {
			try {
				cri.setPage(Integer.parseInt(pageParam));
				cri.setPerPageNum(Integer.parseInt(perPageNumParam));
				
				//DAO에게 cri를 전달
			} catch (Exception e) {
				// 문자가 오는 경우 에러가 발생
				
				// 400 에러페이지를 사용자에게 보내줌
				// response.SC_INTERNAL_SERVER_ERROR 는 500
				response.sendError(response.SC_BAD_REQUEST);
				
				//메소드 종료
				return;
			}
		}
		
		
		try {
//			List<MemberVO> memberList = memberService.getMemberList(cri);
			Map<String, Object> dataMap = memberService.getMemberListForPage(cri);
			
			request.setAttribute("dataMap", dataMap);
		} catch (Exception e) {
			url = "/WEB-INF/views/error/500.jsp";
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
