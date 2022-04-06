package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieAddTest.do")
public class CookieAddTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		/*
		 * - Cookie 저장하는 방법
		 * 		==> 하나의 쿠키는 4kb(4096byte)까지 저장 가능하다.
		 * 		==> 한 도메인 당 20개, 총 300개까지 저장가능하다.
		 * 
		 * 1) Cookie객체를 생성한다. ==> '쿠키변수'와 '쿠키값'은 문자열로 저장한다.
		 * 형식) Cookie cookie변수 = new Cookie("쿠키변수","쿠키값");
		 * 		==> 쿠키값을 한글을 사용할 경우에는 URLEncoder.encode()메서드로 
		 * 			인코딩한 후 저장한다.
		 */
		
		Cookie nameCookie = new Cookie("name",URLEncoder.encode("홍길동","utf-8"));
		Cookie ageCookie = new Cookie("age", String.valueOf(30));
		Cookie genderCookie = new Cookie("gender","Male");
		
		/*
		 * 2) 쿠키의 속성을 설정한다. 
		 * 		- 쿠키변수.setPath("적용경로"); ==> 지정한 경로와 그 하위 경로에서 
		 * 			해당 쿠키를 사용할 수 있다. 생략하면 쿠키를 저장할 당시의 경로가
		 * 			기본값으로 설정된다.
		 * 		- 쿠키변수.setMaxAge(유지시간); ==> 단위(초)
		 * 			==> -1 : 브라우저가 종료될 때까지 유지된다.(기본값)
		 * 			==> 0 : 즉시 쿠키가 삭제된다.
		 * 		- 쿠키변수.setDomain("적용도메인명");
		 * 			==> 예) ".ddit.or.kr"
		 * 					==> www.ddit.or.kr, mail.ddit.or.kr
		 * 		- 쿠키변수.setSecure(보안여부); 
		 * 			==> true : 적용, false : 미적용(기본값)
		 * 		http://
		 * 		https://
		 * 
		 * 3) response객체를 이용해서 쿠키를 웹브라우저로 보내면 웹브라우저가
		 * 	  이 쿠키르 받아서 저장한다.
		 * 	  형식) response.addCookie(1번에서 만든 쿠키변수);
		 * 
		 */
		
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<title>쿠키 저장하기</title></head>");
		out.println("<body>");
		out.println("<h3>Cookie 데이터가 저장되었습니다.</h3>");
		out.println("<hr>");
		out.println("<a href='"+request.getContextPath() +"/basic/02/cookieTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
