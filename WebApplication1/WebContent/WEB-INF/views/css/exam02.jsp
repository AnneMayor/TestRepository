<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
			<style type="text/css">
				 /*태그 선택자 (css 주석, (자바에서는 블록 주석))*/
				 div {background-color:yellow; border:1px solid black; height: 100px}
				 /*Class 선택자*/
				 .skyblue {background-color:skyblue; border:1px solid black; height: 100px}
				 .btn{background-color:burlywood; border:1px solid black; height: 70px; padding:5px}
				 .success{background-color:forestgreen; color:white;}
				 .warning{background-color:red; color:white;}
				 /*id 선택자*/
				 #goldDiv1 {background-color:gold}
				 #goldDiv2 {background-color:goldenrod}
			</style>
	 </head>
	 <body>
			<div>div태그</div>
			<div>div태그</div>
			<div>div태그</div>
			<div class="skyblue">div태그</div>
			<div class="skyblue">div태그</div>
			<div id="goldDiv1" class="skyblue">div태그</div>
			<div id="goldDiv2" class="skyblue">div태그</div>
			<a class="btn success">확인</a>
			<a class="btn warning">경고</a>
	 </body>
</html>
