package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿 처리 과정...
 * 1. 사용자(클라이언트)가 URL로 요청하면 이 HTTP Request를 Container로 전송한다.
 * 2. 컨테이너는 web.xml에 정의된 url패턴을 확인하여 어느 서블릿을 통해 처리해야
 * 	  할지를 겁색한다.
 * 	  (이떄 해당 서블릿이 로딩이 안된 경우에는 해당 서블릿을 로딩한다.
 * 	   처음 로딩시 init()메서드가 자동으로 호출된다.)
 * 	  (서블릿 버전 3.0 이상에서는 애노테이션(@WebServlet)으로 설정할 수 있다.)
 * 3. 서블릿 컨테이너는 요청을 처리할 개별 쓰레드 객체를 생성하여 해당 서블릿 객체의 
 * 	  service()메서드를 호출한다.
 * 	  (이때 HttpServletRequest객체와 HttpServletResponse 객체를 생성하여
 * 	   매개변수로 넘겨준다.)
 * 4.service()메서드는 form의method타입을 체크하여 적절한 메서드를 호출해 준다.
 * 	  (doGet,doPost, doPut, doDelete 등...)
 * 5. 요청 및 응답처리가 완료되면 HttpServletRequest객체와 
 * 	  HttpServletResponse 객체는 자동으로 소멸된다.
 * 6. 컨테이너로부터 서블릿이 제거죄는 경우에는 destory()메서드가 자동으로 호출된다.
 */
@WebServlet(name = "ServletTest03", urlPatterns = { "/servletTest03.do" })
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("servlet : " + this.getServletName()
						+ "에서 init()메서드가 호출되었습니다...");
	}
	@Override
	public void destroy() {
		System.out.println("servlet : " + this.getServletName()
		+ "에서 destroy()메서드가 호출되었습니다...");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("service()메서드 입니다...");
		
		//GET방식과 POST방식에 맞는 메서드 호출하기
		
		//방법1 ==> 부모 클래스인 HttpServlet의 service()메서드로 위임하기
		//super.service(req, resp);
		
		//방법2 ==> 클라이언트의 전송방식(GET, POST등)을 구분해서 직접 메소드 호출
		String method = ((HttpServletRequest)req).getMethod();
		System.out.println("method => " + method);
		if("GET".equals(method)) {
			this.doGet((HttpServletRequest)req, (HttpServletResponse)resp);
		}else if("POST".equals(method)) {
			this.doPost((HttpServletRequest)req, (HttpServletResponse)resp);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='UTF-8'></head>"
				+ "<body><h2 style ='color:red'>doGet()메소드를 처리한 결과입니다.</h2></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='UTF-8'></head>"
				+ "<body><h2 style ='color:blue'>doPost()메소드를 처리한 결과입니다.</h2></body></html>");
	}

}
