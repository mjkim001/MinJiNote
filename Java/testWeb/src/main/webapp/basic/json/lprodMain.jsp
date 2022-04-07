<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#lprodBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/lprodDaoServlet.do",
			type : "post",
			data : "choice=list",
			success : function(data){ // 응답 데이터 처리 함수
				// [{num : 100, name : "홍길동", tel : "010-1234-5678"},
				// ...]
				let str = "Lprod 데이터<hr>";
				
				$.each(data,function(i,v){ //i:첨자, v:i번째 데이터
					str += i + "번째 자료<br>";
					str += "번호 : " + v.lprod_id + "&nbsp;&nbsp;";
					str += "상품 번호 : " + v.lprod_gu + "&nbsp;&nbsp;";
					str += "상품 카테고리 : " + v.lprod_nm + "<hr>";
					
				})
				$("#result").html(str);		
			},
			error : function() {
				alert("오류");
			},
			dataType : "json" // 응답으로 오는 데이터의 종류 설정
		});
	});
	
	//-------------------------------------------------------------------
	
	$("#lprodBtn2").on('click',function(){
		location.href ="<%=request.getContextPath()%>/lprodList2.do";

	});
	
});
</script>
<body>
<!-- 
	DB의 LPROD테이블의 전체 데이터를 가져와 화면애 출력하시오
 -->
 <form>
 	<input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax)">
 	<input type="button" id="lprodBtn2" value="Lprod자료 가져오기2(Non Ajax)">
 </form>
 <h3>Lprod 자료 목록</h3>
 <div id="result"></div>
</body>
</html>