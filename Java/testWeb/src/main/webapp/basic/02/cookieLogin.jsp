<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
span{
	width: 50px;
	display: inline-block;
}
input[type="button"]{
	margin-left: 100px;
}
</style>
</head>
<%
	//jsp문서 (Login폼이 들어 있는 문서)에서 쿠키를 확인해서 값을 셋팅하는 작업을 수행한다.
	
	String cookieId = "";// 쿠키값이 저장아되는변수
	String chk =""; //체크박스 체크용
	
	Cookie[] cookieArr = request.getCookies(); // 쿠키정보 가져오기
	if(cookieArr!=null){
		for(Cookie cookie:cookieArr){  
			if("id".equals(cookie.getName())){
				cookieId = cookie.getValue();//쿠키값 구하기
				chk = "checked";
			}
		}
	}

	
%>
<body>
<h3 style="text-align:center;">Login form</h3>
<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
  <table style="margin:0 auto; border:2px solid gray;">
  <tr>	
	<td>ID : </td>
	<td><input name='id' type='text' value="<%=cookieId %>" placeholder='ID를 입력하세요'></td>
  </tr>
  <tr>	
	<td>PASS : </td>
	<td><input name='pass' type='text' placeholder='PassWord를 입력하세요'></td>
  </tr>	
  <tr>
	<td colspan="2">
		<input type='checkbox' name='remem' value="check" <%=chk %>>id 기억하기
	</td>
  </tr>
  <tr>
	<td colspan="2" style="text-align:center;">
		<input type="submit" name='login' value='Login'>
	</td>
  </tr>
  </table>
</form>
</body>
</html>