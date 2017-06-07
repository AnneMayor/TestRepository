<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>My Travel Journal</title>
<!-- Twitter Bootstrap3 & jQuery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
	font-size: 400%;
}

p {
	font-size: 250%;
}

.container {
	position: absolute;
	top: 25%;
}

#gate {
	margin-left: 50%;
}

</style>
</head>
<body>
	<div class="container">
		<h1>Welcome to Anne's Homepage!</h1>
		<p class="text-center text-primary">새로움은 항상 나를 설레게 한다. -DHL-</p>
		<a href="postinglist"><button id="gate"
				class="btn btn-default btn-lg">Click Me</button></a>
	</div>
</body>
</html>
