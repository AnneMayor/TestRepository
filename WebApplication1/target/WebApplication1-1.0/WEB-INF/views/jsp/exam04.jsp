<%--
[표현식]
1. 작성: ${...}
2. 용도: 객체의 Getter를 이용해서 값을 얻고 출력
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="com.mycompany.myapp.dto.*" %>
<!DOCTYPE html>
<html>
	 <head>
      <meta charset=UTF-8">
			<meta name= viewport content="width=device-width initial-scale=1 user-scalable=no">
			<title>JSP Page</title>
			<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
			<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
			<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
	 </head>
	 <body>
			<div>
				 <%String name = "홍길동";%>			 <%-- 그냥 변수 값을 출력하겠다--%>
				 이름: <%=name%>
			</div>
			<div>
				 <%Member member = new Member("홍길동", 30);%>			 <%-- 그냥 변수 값을 출력하겠다--%>
				 이름: <%=member.getName()%><br/>	
				 나이: <%=member.getAge()%>
			</div>
			<div>
				 <%request.setAttribute("name", "홍길동");%>			<%--리퀘스트라는 객체에 키로 값을 저장해 두면, 키를 통해 값을 얻어올 수 있다--%>
				 이름: <%=request.getAttribute("name")%>
				 이름: ${name}
			</div>
			<div>
				 <%request.setAttribute("member", new Member("홍길동", 30));%>			<%--리퀘스트라는 객체에 키로 객체를 저장--%>
				 이름: <%=((Member)request.getAttribute("member")).getName()%>					<%--멤버객체를 리턴하긴 하지만, 오브젝트 타입으로 리턴--%>
				 이름: ${member.name}<br/>													<%--필드를 호출하는 것이 아니라 게터를 호출하여 값을 얻음--%>
				 나이: ${member.age}
			</div>
			<div>
				 이름: ${name2}<br/>													<%--필드를 호출하는 것이 아니라 게터를 호출하여 값을 얻음--%>
				 나이: ${member2.name}<br/>
				 이름 : ${member2.age}
			</div>
	 </body>
</html>
