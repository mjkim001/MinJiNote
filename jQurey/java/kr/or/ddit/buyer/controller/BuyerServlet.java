package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class BuyerServlet
 */
@WebServlet("/BuyerServlet.do")
public class BuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//selectByName
		
		//1. 전송시 데이터 받기
		//2. service객체 얻기
		IBuyerService service = BuyerServiceImpl.getInstance();
		//3. service메소드 호출하기 - 결과값 리턴 받기
		List<BuyerVO> list = service.selectByName();
		//4. request에 결과값 저장
		request.setAttribute("buyerList", list);
		//5. jsp로 위임(forward)하여 응답데이터 생성하기(출력또는 json데이터)
		request.getRequestDispatcher("0330/buyerList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//idByDetail
		
		//1. 전송시 데이터 받기
		String inputId = request.getParameter("id");
		//2. service객체 얻기
		IBuyerService service = BuyerServiceImpl.getInstance();
		//3. service메소드 호출하기 - 결과값 리턴 받기
		BuyerVO vo = service.idByDetail(inputId);
		//4. request에 결과값 저장
		request.setAttribute("buyerVO", vo);
		//5. jsp로 위임(forward)하여 응답데이터 생성하기(출력또는 json데이터)
		request.getRequestDispatcher("0330/detail.jsp").forward(request, response);
	}

}
