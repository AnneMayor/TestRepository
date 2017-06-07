<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>여행사진갤러리</title>
<!-- Twitter Bootstrap3 & jQuery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<style>
td {
	text-align: center;
	vertical-align: middle;
}
</style>
<body>
	<h1 style="text-align: center;">Australia(호주)</h1>
	<table style="width: 700px; margin-left: 23%;"
		class="table table-bordered">
		<tr class="success">
			<td>번호</td>
			<td>날짜</td>
			<td>장소</td>
			<td>별점</td>
			<td>이미지</td>
		</tr>
		<c:forEach var="t" items="${list}">
			<tr>
				<td>${t.tnumber}</td>
				<td>${t.tdate}</td>
				<td><a href="photoDetail?tnumber=${t.tnumber}">${t.tplace}</a></td>
				<td>${t.tstar}</td>
				<td><img class="img-rounded"
					src="file/austrailia?tnumber=${t.tnumber}" width="200px"></td>
			</tr>
		</c:forEach>
	</table>

	<div style="margin-top: 10px; text-align: center;">
		<a href="photolist?pageNo=1">[처음]</a>
		<c:if test="${groupNo > 1}">
			<a href="photolist?pageNo=${startPageNo-1}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
		&nbsp;
<a href="photolist?pageNo=${i}"
				<c:if test="${pageNo==i}">style="font-weight: bold; color: black;"</c:if>>${i}</a>
&nbsp;
		</c:forEach>

		<c:if test="${groupNo < totalGroupNo }">
			<a href="photolist?pageNo=${endPageNo+1}">[다음]</a>
		</c:if>

		<a href="photolist?pageNo=${totalPageNo}">[맨끝]</a>
	</div>

	<br />
	<div style="margin-top: 10px; width: 700px; text-align: right;">
		<a href="photoWrite" class="btn btn-primary">글쓰기</a>
		<a href="postinglist" class="btn btn-success">뒤로</a>
	</div>
	<br />
	<br />
	<br />
</body>
</html>
