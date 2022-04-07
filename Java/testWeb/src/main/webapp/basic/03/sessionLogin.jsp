<%@page import="kr.or.ddit.basic.session.MemberVO"%>
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
	//jsp문서에서 세션은 'session'이라는 이름으로 이미 생성되어있다.
	//로그인에 성공하면 로그인에 성공한 값이 들어간다.
	MemberVO loginMemVo = (MemberVO)session.getAttribute("loginMember"); 
	
	
%>
<%
	if(loginMemVo==null){ //로그인 관련 세션이 없을때 (로그인이 안되어 있을때)
		%>
		<form action="<%= request.getContextPath()%>/sessionLogin.do" method="post">
			<table border="1" style="margin: 0 auto;">
				<tr>
					<td>ID : </td>
					<td> <input type="text" name="memid" placeholder="ID를 입력해주세요."></td>
				</tr>
				<tr>
					<td>Pass : </td>
					<td> <input type="text" name="mempass" placeholder="PassWord를 입력해주세요."></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="Login">
					</td>
				</tr>
			</table>
		</form>
		<%
	}else { //로그인 관련 세션이 있을때 (로그인이 되었을때)
		%>
		<div style="text-align: center;">
			<h3><%=loginMemVo.getMem_name()%>님 반갑습니다.</h3>
			<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
		</div>
		<%
	}
%>
</body>
</html>