package com.jsp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.controller.InternalViewResolver;
import com.jsp.dto.MemberVO;



public class LoginUserCheckFilter implements Filter {
	
	private List<String> exURLs = new ArrayList<String>();
	
	public void init(FilterConfig fConfig) throws ServletException {
		String excludeURLNames = fConfig.getInitParameter("exclude");

		StringTokenizer st = new StringTokenizer(excludeURLNames, ",");
		while (st.hasMoreTokens()) {
			exURLs.add(st.nextToken().trim());
		}
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
						FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		// 제외할 url 확인
		String reqUrl = httpReq.getRequestURI()
				.substring(httpReq.getContextPath().length());
		
		if (excludeCheck(reqUrl)) {
			chain.doFilter(request, response);
			return;
		}
		
		// login check
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		//login 확인
		if(loginUser==null) { //비로그인 상태
			
			String contextPath = httpReq.getContextPath();
			String retUrl = httpReq.getRequestURI().replace(contextPath,"");
			
			String mCode = httpReq.getParameter("mCode");
			if(mCode!=null) {
				retUrl+="?mCode="+mCode;
			}				
			
			httpReq.setAttribute("viewName", "redirect:/common/loginForm.do?retUrl="+retUrl);
			InternalViewResolver.view(httpReq, httpResp);
			
		}else {
			chain.doFilter(request, response);			
		}
		
	}

	public void destroy() {}

	private boolean excludeCheck(String url) {
		boolean result = false;

		result = result || url.length() <= 1;

		for (String exURL : exURLs) {
			result = result || url.contains(exURL);
		}
		return result;
	}
}









