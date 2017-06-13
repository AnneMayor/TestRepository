<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>AOP JSP file_LoginForm2</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
aop/exam02LoginForm.jsp
<hr/>
로그인 체크 결과: ${loginNeed}<br/>
로그인 폼 화면
</body>
</html>