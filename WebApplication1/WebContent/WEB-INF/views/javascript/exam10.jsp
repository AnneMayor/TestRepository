<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
      <meta charset=UTF-8">
			<meta name= viewport content="width=device-width initial-scale=1 user-scalable=no">
			<title>JSP Page</title>
			<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
			<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
			<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
			<script>
				 console.log(window.outerWidth +","+window.outerHeight);
				 console.log(window.innerWidth +","+window.innerHeight);
				 
				 var pop1;
				 function handleBtn1() {
						pop1 = window.open("<%=application.getContextPath()%>/javascript/exam09", "pop1", "width=300, height=200");
				 }
				 function handleBtn2() {
						pop1.close();
				 }
				 function handleBtn3() {
						work1 = window.setInterval(function(){
							 console.log("umm........" + new Date());
						}, 100);
						work2 = window.setInterval(function(){
							 console.log("umm........2" + new Date());
						}, 105);
				 }
				 function handleBtn4() {
						window.clearInterval(work1);
						window.clearInterval(work2);
				 }
				 function handleBtn5() {
						work3 = window.setTimeout(function() {
							 console.log("Wouhoo~~");
						}, 2000);
				 }
				 function handleBtn6() {
						window.clearTimeout(work3);
				 }
				 function handleBtn6() {
						location.href="WebApplcation/javascript/exam09"
				 }
			</script>
	 </head>
	 <body>
			<h1>BOM 사용하기</h1>
			
			<h3>팝업</h3>
			<button onclick="handleBtn1()" class="btn btn-warning">팝업 띄우기</button>
			<button onclick="handleBtn2()" class="btn btn-warning">팝업 닫기</button>
			
			<h3>주기적 실행</h3>
			<button onclick="handleBtn3()" class="btn btn-warning">시작</button>
			<button onclick="handleBtn4()" class="btn btn-warning">중지</button>
			
			<h3>지연 실행</h3>
			<button onclick="handleBtn5()" class="btn btn-warning">시작</button>
			<button onclick="handleBtn6()" class="btn btn-warning">중지</button>
			
			<h3>요청 경로 변경</h3>
			<button onclick="handleBtn7()" class="btn btn-warning">요청 경로 변경</button>
	 </body>
</html>
