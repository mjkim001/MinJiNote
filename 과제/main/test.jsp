<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>

	<div class="main_slide">


		<div class="slide_info_container">

			<div class="mySlides fade">
				<div class="numbertext"></div>

				<img src="<%=request.getContextPath() %>/resources/img/slide1.jpg"
					style="width: 100%; filter: brightness(80%);">

				<div class="slide_text_box">
					<div class="slide_title">
						<strong>우리들의 기록 공간 <br> Clover
						</strong>
						<hr style="width: 100%; height: 2px; outline: none;">
					</div>
					<div class="slide_text">1ㅣ3</div>
				</div>

			</div>

			<div class="mySlides fade">
				<div class="numbertext"></div>
				<img src="<%=request.getContextPath() %>/resources/img/slide2.jpg"
					style="width: 100%; filter: brightness(80%);">
				<div class="slide_text_box">
					<div class="slide_title">
						<strong>우리들의 기록 공간 <br> Clover
						</strong>
						<hr style="width: 100%; height: 2px; outline: none;">
					</div>
					<div class="slide_text">2ㅣ3</div>
				</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext"></div>
				<img src="<%=request.getContextPath() %>/resources/img/slide3.jpg"
					style="width: 100%; filter: brightness(80%);">
				<div class="slide_text_box">
					<div class="slide_title">
						<strong>우리들의 기록 공간 <br> Clover
						</strong>
						<hr style="width: 100%; height: 2px; outline: none;">
					</div>
					<div class="slide_text">3ㅣ3</div>
				</div>
			</div>


		</div>
		<button type="button" class="prev">
			<img class="btn" src="<%=request.getContextPath() %>/resources/img/img_btn_prev.png" onclick="prev_click()">
		</button>
		<button type="button" class="next">
			<img class="btn" src="<%=request.getContextPath() %>/resources/img/img_btn_next.png" onclick="next_click()">
		</button>

	</div>



	<!-- <div class="row">
	
	<div class="col-3" style="border: 1px solid;">asda</div>
	<div class="col-3" style="border: 1px solid;">asda</div>
	<div class="col-3" style="border: 1px solid;">asda</div>
	<div class="col-3" style="border: 1px solid;">asda</div>
	
	</div> -->

	<div class="main_content row">
		<ul class="content_summary col-md-4 col-sm-3 col-12">
			<li class="summary_container">
				<h3 class="summary_title">소식ㅣ알림</h3> 
				<div class="notice_box">
					<a href="" onclick=""> 
						<strong class="notice_title"></strong>
						<p class="notice_text">fsdasdkjabhsdlkjab</p>
					</a>
				</div>
					<a href="" onclick="" class="summary_link">바로가기<img src="<%=request.getContextPath() %>/resources/img/go_link.png" style="width: 20px; vertical-align: text-top;"></a>
			</li>
		</ul>
		<ul class="content_summary col-md-4 col-sm-3 col-12">
			<li class="summary_container">
				<h3 class="summary_title">일정</h3> 
				<div class="notice_box">
					<a href="" onclick=""> 
						<strong class="notice_title"></strong>
						<p class="notice_text">fsdasdkjabhsdlkjab</p>
					</a>
				</div>
					<a href="" onclick="" class="summary_link">바로가기<img src="<%=request.getContextPath() %>/resources/img/go_link.png" style="width: 20px; vertical-align: text-top;"></a>
			</li>
		</ul>
		
		<ul class="content_summary col-md-4 col-sm-3 col-12">
			<li class="summary_container">
				<h3 class="summary_title">회의록</h3> 
				<div class="notice_box">
					<a href="" onclick=""> 
						<strong class="notice_title"></strong>
						<p class="notice_text">fsdasdkjabhsdlkjab</p>
					</a>
				</div>
					<a href="" onclick="" class="summary_link">바로가기<img src="<%=request.getContextPath() %>/resources/img/go_link.png" style="width: 20px; vertical-align: text-top;"></a>
			</li>
		</ul>
		
	</div>





	<script>
	 	var slideIndex = 0;
		showSlides();
		var slides = document.getElementsByClassName("mySlides");
		var i;

		function prev_click() {
			var slides = document.getElementsByClassName("mySlides");
			slideIndex--;
			if (slideIndex == 0) {
				slideIndex = 3;
			}
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slides[slideIndex - 1].style.display = "contents";
		}
		function next_click() {
			slideIndex++;

			if (slideIndex == 4) {
				slideIndex = 1;
			}

			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slides[slideIndex - 1].style.display = "contents";

		}
		function showSlides() {
			var slides = document.getElementsByClassName("mySlides");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			slides[slideIndex - 1].style.display = "contents";
			setTimeout(showSlides, 3000); // Change image every 3 seconds
		}
		
	</script>
