<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	'id 체크하기'체크박스를 체크한 후 'Lohin'버튼을 클릭하면
	입력했던 값을 쿠키에 저장하고, 쿠키에 'id'값이 저장되어 있으면
	'id'입력 창에 쿠키에 저장되었던 'id'값이 나타나도록 하고, 체크박스도
	체크된 상태가 되도록한다.
	
	체크박스를 해제한 후 로그인을 하면 쿠키에 저장된 'id'값을 삭제하고
	체크박스도 해제된 상태가 되도록한다.
	
	로그인 성공은 id와 password가 'test',"1234"이고,
	로그인이 성공하면 'cookieMain.jsp'로 이동하고 실패하면
	'cookieLogin.jsp'로 이동한다.
	
	해당 내용을 처리하는 서블릿의 URL은 '/cookieLoginServlet.do'이다.
	
	
	cookieMain.jsp파일을 먼저 실행하고,
	login창으로 이동하는 링크를 누르면 cookieLogin.jsp를 실행
	아이디와 비밀번호, id를 기억할 것인지 여부를 체크하고 login버튼을 누르면,
	cookieLoginServlet에서 입력받은 아이디 비밀번호가 일치하는지 보고
	일치하면 cookieMain.jsp, 일치하지 않으면 cookieLogin.jsp
	아이디 비밀번호가 일치할 경우, id를 기억한다고 체크 했으면 id 입력받는곳에 출력되도록한다.
	체크가 해제되어있으면 id입력받는곳을 지운다.
 
 -->
<h3>cookie연습용 main페이지 입니다.</h3>
<a href="<%=request.getContextPath() %>/basic/02/cookieLogin.jsp">Login 창으로 이동</a>
<br><hr><br>
</body>
</html>