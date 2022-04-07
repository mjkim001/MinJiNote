<%@page import="kr.or.ddit.basic.json.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// 서블릿이 forward방식으로 보내온 데이터를 받는다.
	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("list");
	
%>

<body>
<h2>Lprod 자료목록</h2>
<table border="1">
	<tr>
		<td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td>
	</tr>
	<%
		for(LprodVO vo : lprodList){
			%>
			<tr>
			<td><%=vo.getLprod_id() %></td>
			<td><%=vo.getLprod_gu() %></td>
			<td><%=vo.getLprod_nm() %></td>
			</tr>
			
			<%
		}
	%>
	
</table>
</body>
</html>