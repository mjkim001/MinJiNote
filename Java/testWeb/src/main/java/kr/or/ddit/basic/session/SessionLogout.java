package kr.or.ddit.basic.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogout.do")
public class SessionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그아웃 처리는 세션을 삭제하면 된다.
		HttpSession session =  request.getSession();
		
		session.invalidate(); //전체 세션 삭제
		
		// 세션 삭제 후 로그인 폼이 있는 jsp로 이동
		// 처음으로 시작한 jsp문서로 이동한다.
		response.sendRedirect(request.getContextPath()+"/basic/03/sessionLogin.jsp");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
