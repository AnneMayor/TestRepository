<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>회원정보수정</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
	<script>
	function fileChange() {
		
		if($("#mattach")[0].files.length != 0) {
			var originalfilename = $("#mattach")[0].files[0].name;
			$("#spanFileName").text(originalfilename);
		}
		
	}
	</script>
</head>
<body>
<h4>회원정보수정</h4>
	<hr />

	<!-- 자기 경로일 경우, action 생략가능. action에는 보통 상대경로를 써준다.  -->
	<form method="post" style="padding: 0px 20px 0px 20px"
		enctype="multipart/form-data">
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="이름" name="mname"
					value="${member.mname}" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="password" class="form-control" id="mpassword" placeholder="비밀번호"
					name="mpassword" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <input type="number" class="form-control" placeholder="나이"
					name="mage" value="${member.mage}" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="주소"
					name="maddress" value="${member.maddress}" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="이메일"
					name="memail" value="${member.memail}" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="전화번호"
					name="mtel" value="${member.mtel}" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span>
				<span id="spanFileName">${member.moriginalfilename}</span>
				<label for="mattach" class="btn btn-default">변경</label>
				<input id="mattach" style="visibility:hidden;" type="file" name="mattach" onchange="fileChange()" multiple/>
			</div>
		</div>
		
		<input type="submit" class="btn btn-success" value="수정"/>
		
	</form>
</body>
</html>