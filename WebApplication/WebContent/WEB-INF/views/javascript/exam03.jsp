<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta charset=UTF-8">
			<title>JSP Page</title>
			<script>
				 //전역 변수
				 var v1 = "A";
				 
				 function fun1() {
						//로컬변수
						var v2 = "B";
						if(true) {
							 var v3 = "C";
							 v4 = "D";			//함수 안에서 var로 선언하지 않은 변수는 전역변수, 가능하면 이렇게 쓰지 말아라
						}
						
						console.log(v1);
						console.log(v2);
						console.log(v3);
						console.log(v4);
				 }
				 fun1();
				 
				 console.log(v1);
//				 console.log(v2);
//				 console.log(v3);
				 console.log(v4);
			</script>
	 </head>
	 <body>
	 </body>
</html>
