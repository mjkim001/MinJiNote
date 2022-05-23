package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.command.MemberRegistCommand;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.SearchMemberServiceImpl;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet{

	private MemberService memberService = new SearchMemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/member/regist.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면
		String url = request.getContextPath()+"/member/list";
		
		//입력
		try {
			MemberRegistCommand command = (MemberRegistCommand) HttpRequestParameterAdapter.execute(request, MemberRegistCommand.class);
			MemberVO member = command.toMemberVO();
			
			//처리
			memberService.regist(member);
			
			//출력
			response.sendRedirect(url);
			
		}catch (Exception e) {
			e.printStackTrace();
			//Exception 처리....
			url = "";
		}
		
	}

}
