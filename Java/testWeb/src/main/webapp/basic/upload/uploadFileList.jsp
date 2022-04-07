
<%@page import="kr.or.ddit.basic.fileUpload.FileInfo"%>
<%@page import="java.util.List"%>
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
String userName = (String)request.getAttribute("userName");
List<FileInfo> fileList = (List<FileInfo>)request.getAttribute("fileList");
%>
<%
if(userName!=null){
	%>
	<h3>전체 업로드한 파일 목록</h3>
	<%
}
%>
<table border="1">
	<thead>
	<tr>
		<td>파일이름</td><td>파일크기</td><td>업로드 상태</td><td>비고</td>
	</tr>
	</thead>
	<tbody>
	<%
	for(FileInfo fileInfo: fileList){
	%>
		<tr>
			<td><%=fileInfo.getFileName() %></td>
			<td><%=fileInfo.getFileSize() %></td>
			<td><%=fileInfo.getStatus() %></td>
			<td>download</td>
		</tr>
	
	<%
	}
	%>
	</tbody>
</table>
<a href="<%=request.getContextPath()%>/basic/upload/fileuploadMain.jsp"></a>
</body>
</html>