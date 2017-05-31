<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>게시물 목록</title>
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
	<h4>게시물 목록</h4>
	<table style="width: 700px;" class="table table-bordered">
		<tr class="success">
			<td>번호</td>
			<td>제목</td>
			<td>조회수</td>
			<td>글쓴이</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.bno}</td>
				<td>${b.btitle}</td>
				<td>${b.bhitcount}</td>
				<td>${b.bwriter}</td>
				<td>${b.bdate}</td>
			</tr>
		</c:forEach>
	</table>
	<div style="margin-top: 20px; width: 700px; text-align: center;">
		<a href="exam05?pageNo=1">[처음]</a>
		<c:if test="${groupNo > 1 }">
			<a href="exam05?pageNo=${startPageNo-1}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
	&nbsp;
	<a href="exam05?pageNo=${i}"
				<c:if test="${pageNo==i}">style="font-weight: bold; color: red;"</c:if>>${i}</a>
	&nbsp;
	</c:forEach>

		<c:if test="${groupNo < totalGroupNo }">
			<a href="exam05?pageNo=${endPageNo+1 }">[다음]</a>
		</c:if>

		<a href="exam05?pageNo=${totalPageNo}">[맨끝]</a>
	</div>
</body>
</html>