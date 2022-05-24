package com.jsp.action.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.service.MemberService;

public class MemberListAction implements Action {

	private MemberService searchMemberService;
	public void setSearchMemberService(MemberService searchMemberService) {
		this.searchMemberService = searchMemberService;
	}



	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/member/list";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum");
		String keyword = request.getParameter("keyword");
		String searchType = request.getParameter("searchType");
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);
		
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
				return null;
			}
		}
		
		
		try {
			Map<String, Object> dataMap = searchMemberService.getMemberListForPage(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (Exception e) {
			url = "/error/500";
		}
		
		return url;
	}

}
