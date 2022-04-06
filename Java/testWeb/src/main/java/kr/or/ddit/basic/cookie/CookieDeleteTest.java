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


@WebServlet("/cookieDeleteTest.do")
public class CookieDeleteTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * - 저장된 쿠키정보 삭제하기
		 * 		==> 쿠키 데이터의 삭제는 남은 쿠키의 유지시간을 0으로 설정하는 방법을 사용한다.
		 * 		==> 쿠키의 수명은 쿠키를 저장하는 addCookie()메서드를 호출하기 전에
		 * 			해당 쿠키객체의 setMaxAge()메서드를 이용하여 유지시간을 -으로 설정한다.
		 * 		형식) Cookie cookie변수 =  new Cookie("쿠키변수","쿠키값");
		 * 			 cookie변수.setMaxAge(시간);
		 * 				==> 시간이 0이면 쿠키가 삭제되고,
		 * 					시간이 음수이면 웹브라우저가 닫힐때 쿠키가 삭제된다.
		 */
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<title>쿠키값 삭제</title></head>");
		out.println("<body>");
		
		out.println("<h3>저장된 쿠키 데이터가 삭제하기</h3>");
		out.println("<hr>");
		
		if(cookieArr==null || cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
		}else {
			// 쿠키 배열에서 삭제하려는 쿠키정보를 구해온다.
			for(Cookie cookie : cookieArr) {
				// '쿠키변수' 구하기
				String cookieName = cookie.getName();
				
				// 해당 쿠키변수가 삭제하려는 쿠키변수인지 확인한다.
				// 예) 쿠키변수가 'gender'인 쿠키정보 삭제하기
				if("gender".equals(cookieName)) {
					//해당 쿠키를 찾았으면 유지시간을 0으로 설정
					//다시 저장한다.
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					out.println("<h3>쿠키를 삭제했습니다.</h3>");
				}
			}
		}
		out.println("<hr>");
		out.println("<a href='"+request.getContextPath() +"/basic/02/cookieTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
