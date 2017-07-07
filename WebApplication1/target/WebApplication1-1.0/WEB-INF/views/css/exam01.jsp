<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
	 </head>
	 <body>
			<h1>블록 태그 및 인라인 태그</h1>
			
			<h3>블록 태그</h3>
			<div style="background-color:yellow; border:1px solid black; height: 100px">div태그</div>
			<p style="background-color:skyblue; border:1px solid black; height: 100px">p 태그</p>
			<h4 style="background-color:coral; border:1px solid black; height: 100px">h 태그</h4>
			<form style="background-color:firebrick; border:1px solid black; height: 100px">form 태그</form>
			<table style="background-color:mediumaquamarine; border:1px solid black; height: 100px; width:100%">
				 <tr>
						<td>테이블 태그</td>
				 </tr>
				 <tr>
						<td>테이블 태그</td>
				 </tr>
			</table>
			<table style="background-color:mediumvioletred; border:1px solid black; height: 100px; width:100px"></table>
			
			<h3>인라인 태그</h3>
			<span style="background-color:blueviolet; border:1px solid black; height: 100px">span 태그</span>
			<span style="background-color:cyan; border:1px solid black; height: 100px">span 태그2</span><br/>
			<span style="background-color:chartreuse; border:1px solid black; height: 100px">span 태그3</span>
			<img src="/WebApplication/resources/images/penguins.jpg" style="border:2px solid black; height: 100px" />
			<a style="border:2px solid blue; height: 100px">a 태그</a>
			
			<h3>블록 -> 인라인</h3>
			<div style="background-color:yellow; border:1px solid black; height: 100px; display:inline;">div태그</div>
			<div style="background-color:yellow; border:1px solid black; height: 100px; display:inline;">div태그</div>

	 </body>
</html>
