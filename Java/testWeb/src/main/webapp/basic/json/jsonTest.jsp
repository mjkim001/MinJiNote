<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax를 이용한 json데이터 처리하기</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	// 문자열 처리
	$("#strBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=string",
			success : function(data){ // 응답 데이터 처리 함수
				var str = "문자열 데이터<hr>"
				str += data;
				$("#result").html(str);
			},
			error : function() {
				alert("오류");
			},
			dataType : "json" // 응답으로 오는 데이터의 종류 설정
		});
	});
	//------------------------------------------------
	
	// 배열 처리
	$("#arrayBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=array",
			success : function(data){ // 응답 데이터 처리 함수
				let str = "배열 데이터<hr>";
				
				$.each(data,function(i,v){ //i:첨자, v:i번째 데이터
					str += i + "번째 데이터 : " + v + "<br>"
				})
				$("#result").html(str);		
			},
			error : function() {
				alert("오류");
			},
			dataType : "json" // 응답으로 오는 데이터의 종류 설정
		});
	});
	//------------------------------------------------
	
	// 객체 처리
	$("#objBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=object",
			success : function(data){ // 응답 데이터 처리 함수
				// {num : 100, name : "홍길동", tel : "010-1234-5678"}
				let str = "객체 데이터<hr>";
				str+="번호 : " + data.num + "<br>"
				str+="이름 : " + data.name + "<br>"
				str+="전화 : " + data.tel + "<br>"
				$("#result").html(str);		
			},
			error : function() {
				alert("오류");
			},
			dataType : "json" // 응답으로 오는 데이터의 종류 설정
		});
	});
	//------------------------------------------------
	
	// 리스트 처리
	$("#listBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=list",
			success : function(data){ // 응답 데이터 처리 함수
				// [{num : 100, name : "홍길동", tel : "010-1234-5678"},
				// ...]
				let str = "리스트 데이터<hr>";
				
				$.each(data,function(i,v){ //i:첨자, v:i번째 데이터
					str += i + "번째 자료<br>";
					str += "번호 : " + v.num + "<br>";
					str += "이름 : " + v.name + "<br>";
					str += "전화 : " + v.tel + "<hr>";
					
				})
				$("#result").html(str);		
			},
			error : function() {
				alert("오류");
			},
			dataType : "json" // 응답으로 오는 데이터의 종류 설정
		});
	});
		//------------------------------------------------
		
		// Map 처리 (자바의 Map은 Json에서는 객체형ㅇ느로 변환된다.)
	$("#mapBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=map",
			success : function(data){ // 응답 데이터 처리 함수
				// {키값1 : value값1 , 키값2 : value값2 ,키값3 : value값3 }
				// ...]
				let str = "Map 데이터<hr>";
				str += "name : "+data.name + "<br>";
				str += "tel : "+data.tel + "<br>";
				str += "addr : "+data.addr + "<br>";
				
				$.each(data, function() {
					//data가 객체형이면 i에는 변수명, v에는 데이터 값이 저장된다.
				})
				
				$("#result").html(str);		
			},
			error : function() {
				alert("오류");
			},
			dataType : "json" // 응답으로 오는 데이터의 종류 설정
		});
	});
});

</script>

</head>
<body>
<form>
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배 열">
	<input type="button" id="objBtn" value="객 체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map객체">
</form>
<hr>
<h3>응답 결과 출력</h3>
<div id ="result" ></div>
</body>
</html>