package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		LprodDao lprodDao = LprodDao.getInstance();
		List<LprodVO> lprodList  = lprodDao.getLprodList();
		
		//view로 보내줄 데이터를 request객체에 저장한다.
		request.setAttribute("list", lprodList);
		
		//view 페이지로 forwarding 한다.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/lprod/lprodList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
