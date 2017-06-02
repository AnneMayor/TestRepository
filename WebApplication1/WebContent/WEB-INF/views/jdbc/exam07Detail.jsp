<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<script type="text/javascript">
function handleBtnUpdate() {
	var mpassword = $("#mpassword").val();
	if(mpassword == "") {
		$("#mpassword").attr("placeholder", "비밀번호를 입력하세요.");
		$("#mpassword").css("border-color","red");
		return;
	}
	$.ajax({
		url:"exam07CheckMpassword",
		method:"post",
		data: {"mid" : "${member.mid}", "mpassword": mpassword},
		success: function(data) {
			if(data.result == "success") {
				console.log("success");
				location.href="exam07Update?mid=${member.mid}";
			} else {
				console.log("fail");
				$("#mpassword").val("");
				$("#mpassword").attr("placeholder", "비밀번호가 틀렸습니다.");
				$("#mpassword").css("border-color", "red");
			}
		}
	});
}

function handleBtnDelete() {
	var mpassword = $("#mpassword").val();
	if(mpassword == "") {
		$("#mpassword").attr("placeholder", "비밀번호를 입력하세요.");
		$("#mpassword").css("border-color","red");
		return;
	}
	$.ajax({
		url:"exam07CheckMpassword",
		method:"post",
		data: {"mid" : "${member.mid}", "mpassword": mpassword},
		success: function(data) {
			if(data.result == "success") {
				console.log("success");
				location.href="exam07Delete?mid=${member.mid}";
			} else {
				console.log("fail");
				$("#mpassword").val("");
				$("#mpassword").attr("placeholder", "비밀번호가 틀렸습니다.");
				$("#mpassword").css("border-color", "red");
			}
		}
	});
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
					value="${member.mname}" disabled />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="아이디"
					name="mid" value="${member.mid}" disabled />
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
					name="mage" value="${member.mage}" disabled />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="주소"
					name="maddress" value="${member.maddress}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="date" class="form-control" placeholder="날짜"
					name="mdate" value="${member.mdate}" disabled />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="이메일"
					name="memail" value="${member.memail}" disabled />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="전화번호"
					name="mtel" value="${member.mtel}" disabled />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span> <a class="form-control" href="#">${member.moriginalfilename}</a>
			</div>
		</div>
		
		<a href="exam07" class="btn btn-success">목록</a> 
		<input type="button" onclick="handleBtnUpdate()" class="btn btn-warning" value="수정" /> 
		<input type="button" onclick="handleBtnDelete()" class ="btn btn-danger" value="삭제" />
	</form>
</body>
</html>