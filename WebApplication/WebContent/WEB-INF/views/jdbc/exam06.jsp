<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>회원 목록</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
	<h4>회원 목록</h4>
	<table class="table table-bordered">
		<tr class="success">
			<td>이름</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>나이</td>
		</tr>
		<c:forEach var="m" items="${list}">
			<tr>
				<td>${m.mname}</td>
				<td>${m.mid}</td>
				<td>${m.mpassword}</td>
				<td>${m.mage}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>