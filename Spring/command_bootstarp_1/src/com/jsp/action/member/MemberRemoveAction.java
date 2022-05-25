package com.jsp.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberRemoveAction implements Action {

	private MemberService memberService;
	public void setSearchMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/remove_success";
		
		String id = request.getParameter("id");
		try {
			memberService.remove(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			url = "/member/detail_fail";
			// 에러를 직접 보낼 때
			// response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
