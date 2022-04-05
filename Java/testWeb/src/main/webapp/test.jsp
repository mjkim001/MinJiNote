<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//이 영역은 자바 명령을 사용할 수 있는 영역입니다...
	int a = 10;
	int b = 50;
	
	int c = a + b;
	
%>

<%=a %>+<%=b %>=<%=c %><br>
<%=a %>*<%=b %>=<%=a*b %><br>
</body>
</html>