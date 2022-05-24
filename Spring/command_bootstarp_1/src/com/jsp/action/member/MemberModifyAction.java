package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.MemberRegistCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberModifyAction implements Action {

	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/modify_success";
		try {
			request.setCharacterEncoding("utf-8");

			MemberRegistCommand command = HttpRequestParameterAdapter.execute(request, MemberRegistCommand.class);
			
			MemberVO member = command.toMemberVO();
			
			//처리
			memberService.modify(member);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//exception 처리...
			url = "/member/modify_fail";
		}
		return url;
	}
	
}
