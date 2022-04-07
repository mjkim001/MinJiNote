package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/lprodDaoServlet.do")
public class LprodDaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		//응답 데이터가 JSON데이터일 경우 ContentType을 아래와 같이 변경한다.
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Gson객체 생성
		Gson gson =  new Gson();
		
		//Json으로 변환된 문자열이 저장될 변수 선언
		String jsonData = null;
		
		LprodDao dao = LprodDao.getInstance();
		
		List<LprodVO> list  = dao.getLprodList();
		
		jsonData = gson.toJson(list);
		
		System.out.println("jsonData = > "+jsonData);
		out.write(jsonData);
		response.flushBuffer();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
