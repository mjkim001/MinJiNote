package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDeleteTest.do")
public class SessionDeleteTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * - Session 삭제하기
		 * 1. Session객체 생성 및 현재 세션 구하기
		 */
		HttpSession session =request.getSession();
		
		/*
		 * 2. Session 삭제하기
		 * 	1) 세션 자체를 삭제하는 것이 아니고 개별적인 세션 데이터를 삭제하기
		 * 		형식) Session객체.removeAttribute("삭제할 key값");
		 */
		//session.removeAttribute("testSession");
		
		/*
		 * 	2) 세션 자체를 삭제하기
		 * 		형식) Session객체.invalidate() 
		 */
		
		session.invalidate();
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<title> Session 데이터 삭제</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session 데이터 삭제하기</h2><hr>");
		
		out.println("<br><hr><br>");
		out.println("<a href='/testWeb/basic/03/session.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
