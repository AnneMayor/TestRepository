<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>여행사진리스트</title>
<!-- Twitter Bootstrap3 & jQuery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h4></h4>
	<hr />

	<!-- 자기 경로일 경우, action 생략가능. action에는 보통 상대경로를 써준다.  -->
	<form method="post" style="padding: 0px 20px 0px 20px"
		enctype="multipart/form-data">

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="날짜"
					name="tdate" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="장소"
					name="tplace" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="별점"
					name="tstar" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="여행일수"
					name="tduration" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-leaf"></span>
				</span>
				<textarea class="form-control" rows="10" cols="100" placeholder="설명"
					name="tdescription"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="추천"
					name="trecommendation" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span> <input type="file" class="form-control" placeholder="선택"
					name="tattach" />
			</div>
		</div>

		<input type="submit" class="btn btn-info" value="확인" />
	</form>
</body>
</html>