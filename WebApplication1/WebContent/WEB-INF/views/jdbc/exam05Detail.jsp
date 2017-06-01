<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>글쓰기</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function handleBtnUpdate() {
		var password = $("#bpassword").val();
		if(password == "") {
			$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
			$("#bpassword").css("border-color", "red");
			return;
		}
		$.ajax({
			url:"exam05CheckBpassword",
			method: "post",
			//data: "bno=${board.bno}&bpassword=" + password,
			data: {"bno":"${board.bno}","bpassword":password},
			success: function(data) {
				if(data.result == "success") {
					location.href="exam05Update?bno=${board.bno}";
				} else {
					$("#bpassword").val("");
					$("#bpassword").attr("placeholder", "비밀번호가 틀렸습니다.");
					$("#bpassword").css("border-color", "red");
				}
			}
		});
	}
	
	function handleBtnDelete() {
		var password = $("#bpassword").val();
		if(password == "") {
			$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
			$("#bpassword").css("border-color", "red");
			return;
		}
		$.ajax({
			url:"exam05CheckBpassword",
			method: "post",
			data: "bno=${board.bno}&bpassword=" + password,
			//data: {"bno":"${board.bno}","bpassword":password},
			success: function(data) {
				if(data.result == "success") {
					location.href="exam05Delete?bno=${board.bno}";
				} else {
					$("#bpassword").val("");
					$("#bpassword").attr("placeholder", "비밀번호가 틀렸습니다.");
					$("#bpassword").css("border-color", "red");
				}
			}
		});
	}
	
</script>
</head>
<body>
	<h4>게시물 쓰기</h4>
	<hr />

	<!-- 자기 경로일 경우, action 생략가능. action에는 보통 상대경로를 써준다.  -->
	<form method="post" style="padding: 0px 20px 0px 20px"
		enctype="multipart/form-data">
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="번호" name="bno"
					value="${board.bno}" disabled />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="제목"
					name="btitle" value="${board.btitle}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <input type="text" class="form-control" placeholder="글쓴이"
					name="bwriter" value="${board.bwriter}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="date" class="form-control" placeholder="글쓴날짜"
					name="bdate" value="${board.bdate}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="number" class="form-control" placeholder="조회수"
					name="bhitcount" value="${board.bhitcount}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-leaf"></span>
				</span>
				<textarea class="form-control" rows="5" cols="30" placeholder="내용"
					name="bcontent" disabled>${board.bcontent}</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span> <a class="form-control" href="#">${board.boriginalfilename}</a>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="password" class="form-control" id="bpassword" placeholder="비밀번호"
					name="bpassword" />
			</div>
		</div>

		<a href="exam05" class="btn btn-success">목록</a> <input type="button"
		 onclick="handleBtnUpdate()" class="btn btn-warning" value="수정" /> <input
			type="button" onclick="handleBtnDelete()" class ="btn btn-danger" value="삭제" />
		<!--  -->
	</form>
</body>
</html>