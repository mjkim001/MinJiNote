<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Starter</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->

  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">


<script type="text/javascript">

</script>

<script>
function picture_go(){
	//alert("file change");
	
   var form = $('form[role="form"]');
   var picture = form.find('[name=picture]')[0];
   
   //이미지 확장자 jpg 확인
   var fileFormat = picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
	if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
   		alert("이미지는 jpg/jpeg 형식만 가능합니다.");
   		picture.value="";      
   		return;
	} 

	//이미지 파일 용량 체크
   if(picture.files[0].size>1024*1024*1){
      alert("사진 용량은 1MB 이하만 가능합니다.");
      picture.value="";
      return;
   };
   
   //업로드 확인변수 초기화(사진변경)
   form.find('[name="checkUpload"]').val(0);
   
   document.getElementById('inputFileName').value = picture.files[0].name;
   //$('#inputFileName').val(picture.files[0].name)
   
   if(picture.files && picture.files[0]){
	   var reader = new FileReader();
	   
	   reader.onload = function (e){
		   $('div#pictureView').css(
			   {
			   'background-image' : 'url('+ e.target.result+')',
			   'background-position' : 'center',
			   'background-size' : 'cover',
			   'background-repeat' : 'no-repeat'
			   }
		   );
	   }
	   
	   reader.readAsDataURL(picture.files[0]);
   }
   
}

function upload_go(){
	//alert('upload btn click')
	
	if(!$('input[name="pictureFile"]').val()){
		alert('사진을 선택하세요.')
		$('input[name="pictureFile"]').click();
		return;
	}
	
	if($('input[name="checkUpload"]').val() == 1){
		alert("이미 업로드 된 사진입니다.");
		return;
	}
	
	
	var formData = new FormData($('form[role="imageForm"]')[0]);
	
	$.ajax({
		url : "picture.do",
		data : formData,
		type : "post",
		processData : false,
		contentType : false,
		success : function(data){
			//업로드 확인변수 세팅
			$('input[name="checkUpload"]').val(1);
			
			//저장된 파일명 저장
			$('input#oldFile').val(data); //변경시 삭제할 파일명
			$('form[role="form"] inputp[name="picture"]').val(data);
			alert("사진이 업로드 되었습니다.");
		},
		error:function(error){
			alert("현재 사진 업로들가 불가합니다.\n 관리자에게 연락바랍니다.");
		}
	})
	
}

var checkedID = "";
function idCheck_go(){
	//alert("id check btn click");
	var input_ID=$('input[name="id"]');
	
	if(!input_ID.val()){
		alert("아이디를 입력하시오");
		input_ID.focus();
		return;
	}
	
	$.ajax({
		url : "idCheck.do?id="+input_ID.val().trim(),
		method : "get",
		success : function(result){
			if(result.toUpperCase() == "DUPLICATED"){
				alert("중복된 아이디 입니다.");
				$('input[name="id"]').focus();
			}else{
				alert("사용가능한 아이디 입니다.");
				checkedID = input_ID.val().trim();
				$('input[name="id"]').val(input_ID.val().trim());
			}
		},
		error : function(error){
			alert("시스템장애로 가입이 불가합니다.");
		}
	});
	
}

function modify_go(){
	
	
	var form = $('form[role="form"]');
	form.attr({"method":"post",
			   "action":"modify.do"
	});
	form.submit();
	
	alert("회원등록에 성공했습니다.\n 회원리스트 페이지로 이동합니다.");
	
	window.opener.location.href="<%=request.getContextPath()%>/member/list.do";
	window.close();
}
</script>

</head>    
    
<title>회원수정</title>

<body>
  <!-- Content Wrapper. Contains page content -->
  <div>
   <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>수정페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">회원관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	수정
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section> 
  <!-- Main content -->
  <section class="content register-page" >
	<form role="form" class="form-horizontal" action="modify.do" method="post" enctype="multipart/form-data">	
		<div class="card" style="min-width:450px;">	
			<div class="card-body">	
				<div class="row">					
					<input type="hidden" name="oldPicture"  value=""/>
					<input type="file" id="inputFile" onchange="changePicture_go();" name="picture" style="display:none" />
					<div class="input-group col-md-12">
						<div class="col-md-12" style="text-align: center;">
							<div class="manPicture" data-id="${member.id }" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; margin-bottom:5px; background-image: url('<%=request.getContextPath() %>/member/getPicture.do?id=${member.id }');"></div>														
							<div class="input-group input-group-sm">
								<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">사진변경</label>
								<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled
									value="${member.picture }"/>
								<input id="picture" class="form-control" type="hidden" name="uploadPicture" />
							</div>						
						</div>												
					</div>
				</div>	
				<div class="form-group row">
					<label for="id" class="col-sm-3 control-label text-center">아이디</label>	
					<div class="col-sm-9">
						<input readonly name="id" type="text" class="form-control" id="id"
							placeholder="13글자 영문자,숫자 조합" value="${member.id }">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="pwd" class="col-sm-3 control-label text-center" >패스워드</label>

					<div class="col-sm-9">
						<input name="pwd" type="password" class="form-control" id="pwd"
							placeholder="20글자 영문자,숫자,특수문자 조합" value="${member.pwd }">
					</div>
				</div>
				<div class="form-group row">
					<label for="pwd" class="col-sm-3 control-label text-center" >이 름</label>

					<div class="col-sm-9">
						<input name="name" type="text" class="form-control" id="name"
							placeholder="20글자 영문자,숫자,특수문자 조합" value="${member.name }">
					</div>
				</div>
						
									
				<div class="form-group row">
					<label for="authority" class="col-sm-3 control-label text-center" >권 한</label>
					<div class="col-sm-9">
						<select name="authority" class="form-control">
							<option  value="ROLE_USER">사용자</option>
							<option  value="ROLE_MANAGER">운영자</option>
							<option  value="ROLE_ADMIN">관리자</option>
						</select>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="email" class="col-sm-3 control-label text-center">이메일</label>

					<div class="col-sm-9">
						<input name="email" type="email" class="form-control" id="email"
							placeholder="example@naver.com" value="${member.email }">
					</div>
				</div>
				<div class="form-group row">
                  <label for="phone" class="col-sm-3 control-label text-center">전화번호</label>
                  <div class="col-sm-9">   
                  	<input name="phone" type="text" class="form-control" id="inputPassword3" value="${member.phone }">	                
                  </div>                  
                </div>  
				
				<div class="card-footer row" style="margin-top: 0; border-top: none;">						
					<button type="button" id="modifyBtn"  onclick="modify_go();"
						class="btn btn-warning col-sm-4 text-center" >수정하기</button>
					<div class="col-sm-4"></div>
					<button type="button" id="cancelBtn" onclick="history.go(-1);"
						class="btn btn-default pull-right col-sm-4 text-center">취 소</button>
				</div>	
			</div>
		</div>
	</form>
  </section>
    <!-- /.content -->
  </div>
  
  <form role="imageForm" action="upload/picture" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display:none;" onchange="picture_go()">
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
  </form>

<!-- REQUIRED SCRIPTS -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
</body>
</html>

