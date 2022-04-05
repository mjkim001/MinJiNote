package kr.or.ddit.basic.reqNres;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전달되는 데이터 받기	
		int num1 =  Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		String cal = request.getParameter("cal");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2> 계산 결과</h2>");
		out.println(num1 + " " + cal +" " + num2 + " = ");
		switch (cal) {
		case "+":
			out.println(num1+num2);
			break;
		case "-":
			out.println(num1-num2);
			break;
		case "*":
			out.println(num1*num2);
			break;
		case "/":
			out.println((double)num1/num2);
			break;
		case "%":
			out.println(num1%num2);
			break;
		}
		
		
		out.println("</body></html>");
	}


	private String parseInt(String num1) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
