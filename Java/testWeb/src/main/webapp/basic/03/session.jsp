<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<body>

<a href="<%=request.getContextPath()%>/sessionAddTest.do">Session정보 저장하기</a><br><hr><br>
<a href="<%=request.getContextPath()%>/sessionReadTest.do">Session정보 읽기</a><br><hr><br>
<a href="<%=request.getContextPath()%>/sessionDeleteTest.do">Session정보 삭제하기</a><br><hr><br>

</body>
</html>