package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();

		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<title>쿠키 count증가하기</title></head>");
		out.println("<body>");
		
		for(Cookie cookie : cookieArr) {
			// '쿠키변수' 구하기
			String cookieName = cookie.getName();
			
			// 해당 쿠키변수가 삭제하려는 쿠키변수인지 확인한다.
			// 예) 쿠키변수가 'gender'인 쿠키정보 삭제하기
			if("count".equals(cookieName)) {
				//해당 쿠키를 찾았으면 유지시간을 0으로 설정
				//다시 저장한다.
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				out.println("<h3>count가 초기화되었습니다.</h3>");
			}
		}
		
		out.println("<hr>");
		out.println("<a href='/testWeb/basic/02/cookieTest02.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
