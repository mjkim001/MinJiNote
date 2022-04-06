package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//form에서 가지고온 데이터 id, pass, remem값 받아오기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String remem = request.getParameter("remem");
		
		//id가 저장된 쿠키 객체 생성
		Cookie idCookie = new Cookie("id",id);
		//System.out.println("체크여부 : " + remem);
		// 체크박스의 체크여부에 따라 쿠키 저장한다.
		if(remem != null) { //체크박스가 체크되었을때
			response.addCookie(idCookie); //쿠키 저장
		}else {// 체크박스의 체크가 해제되었을 때
			idCookie.setMaxAge(0);
			response.addCookie(idCookie); //쿠키를 삭제한다.
		}
		
		//로그인 성공 여부 확인
		
		//id와 pass의 null 체크 ==> 반드시 해주는 것이 좋다.
		if(id!=null&&pass!=null) {
			if("test".equals(id)&&"1234".equals(pass)) {//로그인 성공
				response.sendRedirect(request.getContextPath()+"/basic/02/cookieMain.jsp");
			}else//로그인 실패
				response.sendRedirect(request.getContextPath()+"/basic/02/cookieLogin.jsp");
		}else //로그인 실패
			response.sendRedirect(request.getContextPath()+"/basic/02/cookieLogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
