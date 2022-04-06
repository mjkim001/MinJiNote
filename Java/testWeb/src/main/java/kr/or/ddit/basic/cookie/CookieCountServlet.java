package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		Cookie[] cookieArr = request.getCookies();
		Cookie countCookie= null;

		for (Cookie cookie : cookieArr) {
			if ("count".equals(cookie.getName())) {
				countCookie = cookie;
				countCookie.setValue(String.valueOf(Integer.parseInt(countCookie.getValue()) + 1));
			}
		}
		if(countCookie== null) {
			countCookie = new Cookie("count", String.valueOf(1));
		}
		
		response.addCookie(countCookie);
		
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<title>쿠키 count증가하기</title></head>");
		out.println("<body>");
		out.println("<h3>어서오세요. 당신은 "+countCookie.getValue()+"번째 방문입니다.</h3>");
		out.println("<hr>");
		out.println("<a href='/testWeb/cookieCountServlet.do'>카운트 증가하기</a>");
		out.println("<a href='/testWeb/basic/02/cookieTest02.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
