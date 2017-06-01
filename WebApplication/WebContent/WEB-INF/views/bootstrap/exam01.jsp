<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta charset=UTF-8">
			<meta name= viewport content="width=device-width initial-scale=1 user-scalable=no">
			<title>JSP Page</title>
			<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
			<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
			<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	 </head>
	 <body>
			<h3> 버튼 </h3>
				 <button type="button" class="btn btn-default">Default</button>
				 <button type="button" class="btn btn-primary">Default</button>
				 <button type="button" class="btn btn-warning">Default</button>
				 <button type="button" class="btn btn-success">Default</button>
				 <a class="btn btn-info" href="/WebApplication">a tag</a>
				 <input type="button" class="btn btn-success" value="input tag"/>
			
			<h3> 테이블 </h3>
			<table class="table table-bordered">
				 <tr class="active">
						<td>번호</td>
						<td>제목</td>
						<td>저자</td>
				 </tr>
				 <tr>
						<td>1</td>
						<td>오늘은 축구하는 날</td>
						<td>성근</td>
				 </tr>
			</table>
			
			<h3>이미지</h3>
			<img class="img-rounded" src="<%=application.getContextPath()%>/resources/images/photo1.jpg" width="100px" height="100px">
			<img class="img-circle" src="<%=application.getContextPath()%>/resources/images/photo1.jpg" width="100px" height="100px">
			<img class="img-thumbnail" src="<%=application.getContextPath()%>/resources/images/photo1.jpg" width="100px" height="100px">
			
			<h3>폼</h3>
			<form>
				 <div class="form-group">
						<label for="exampleInputEmail1">Email address</label>
						<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
				 </div>
			</form>	 
	 </body>
</html>
