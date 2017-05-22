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
				 var v1 = "abc";
				 console.log(v1.length);
				 
				 var v2 = "JavaScript is easy";
				 console.log(v2.indexOf("easy"));
				 
				 var v3 = "123456 - 1234567";
				 console.log(v3.substring(1, 4));
				 console.log(v3.substring(0, 6));
				 console.log(v3.substr(1, 4));
				 
				 var v4 = "10:20:30";
				 console.log(v4.split(":"));
			</script>
	 </head>
	 <body>
			<h1>String의 메소드</h1>
	 </body>
</html>
