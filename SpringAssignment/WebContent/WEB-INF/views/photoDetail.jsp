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
<title>여행사진리스트</title>
<!-- Twitter Bootstrap3 & jQuery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function handleBtnUpdate() {
		location.href="photoUpdate?tnumber=${travel.tnumber}";
	}
	function handleBtnDelete() {
		location.href="photoDelete?tnumber=${travel.tnumber}";
	}
	</script>
	<style>
	.form-group {
	width: 700px;
	}
	</style>
</head>
<body>
	<h4></h4>
	<hr />

	<!-- 자기 경로일 경우, action 생략가능. action에는 보통 상대경로를 써준다.  -->
	<form method="post" style="padding: 0px 20px 0px 20px; margin-left: 22%;"
		enctype="multipart/form-data">
		<input class="img-rounded" type="image" name="tnumber" src="file/austrailia?tnumber=${travel.tnumber}" width="700px"/>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-cog"></span>
				</span> <input type="number" class="form-control" placeholder="번호" name="tnumber"
					value="${travel.tnumber}" disabled />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span> <input type="text" class="form-control" placeholder="날짜"
					name="tdate" value="${travel.tdate}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-globe"></span>
				</span> <input type="text" class="form-control" placeholder="장소"
					name="tplace" value="${travel.tplace}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-star"></span>
				</span> <input type="text" class="form-control" placeholder="별점"
					name="tstar" value="${travel.tstar}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-briefcase"></span>
				</span> <input type="text" class="form-control" placeholder="여행일수"
					name="tduration" value="${travel.tduration}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-pencil"></span>
				</span>
				<textarea class="form-control" rows="10" cols="100" placeholder="설명"
					name="tdescription" disabled>${travel.tdescription}</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-thumbs-up"></span>
				</span> <input type="text" class="form-control" placeholder="추천"
					name="trecommendation" value="${travel.trecommendation}" disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span> <a class="form-control" href="#">${travel.toriginalfilename}</a>
			</div>
		</div>

		<a href="photolist?pageNo=" class="btn btn-success">목록</a> <input type="button" 
		 onclick="handleBtnUpdate()" class="btn btn-warning" value="수정" /> <input
			type="button" onclick="handleBtnDelete()" class ="btn btn-danger" value="삭제" />
	</form>
</body>
</html>