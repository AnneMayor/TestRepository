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
	function fileChange() {
		if ($("#tattach")[0].files.length != 0) {
			var originalfilename = $("#tattach")[0].files[0].name;
			$("#spanFileName").text(originalfilename);
	}
</script>
<script type="text/javascript">
 
 	function handleImageView(files){		
 		var file = files[0];
 
 		if(!file.type.match(/image.*/)){
 			alert("not image file!");
 		}			
 		var reader = new FileReader();
 		
 		reader.onload = function(e){
 			
 			var img = new Image();
 			img.onload = function(){
 				var ctx = document.getElementById("cview").getContext("2d");
 				ctx.drawImage(img,0,0,480,320);
 			}
 			img.src = e.target.result;
 		}
 		
 		reader.readAsDataURL(file);
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
	<form method="post" style="padding: 0px 20px 0px 20px; margin-left: 22%"
		enctype="multipart/form-data">
		<input type="image" name="timage"
			class="img-rounded" src="file/austrailia?tnumber=${travel.tnumber}" width="700px"/>
			<canvas id="preview" width="700px"></canvas>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-cog"></span>
				</span> <input type="number" class="form-control" placeholder="번호"
					name="tnumber" value="${travel.tnumber}" disabled />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span> <input type="text" class="form-control" placeholder="날짜"
					name="tdate" value="${travel.tdate}" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-globe"></span>
				</span> <input type="text" class="form-control" placeholder="장소"
					name="tplace" value="${travel.tplace}" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-star"></span>
				</span> <input type="text" class="form-control" placeholder="별점"
					name="tstar" value="${travel.tstar}" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-briefcase"></span>
				</span> <input type="text" class="form-control" placeholder="여행일수"
					name="tduration" value="${travel.tduration}" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-pencil"></span>
				</span>
				<textarea class="form-control" rows="10" cols="100" placeholder="설명"
					name="tdescription">${travel.tdescription}</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-thumbs-up"></span>
				</span> <input type="text" class="form-control" placeholder="추천"
					name="trecommendation" value="${travel.trecommendation}"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span> <a class="form-control" href="#">${travel.toriginalfilename}</a>
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span>
				<div class="form-control" style="height: 47px;">
					<span id="spanFileName">${travel.toriginalfilename}</span> <label
						for="tattach" class="btn btn-default">변경</label> <input
						id="tattach" style="visibility: hidden;" type="file"
						name="tattach" onchange="fileChange()" multiple />
						<input type="file" id="inputfile" onchange="handleImageView(this.files)" />
				</div>
			</div>
		</div>

		<input type="submit" class="btn btn-info" value="수정하기" />
	</form>
	
	<input type="file" id="inputfile" onchange="handleImageView(this.files)">
	<canvas id="cview" width="480" height="320" style="border:solid 3px #CCC;"></canvas>

</body>
</html>