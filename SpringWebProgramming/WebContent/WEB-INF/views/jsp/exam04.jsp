<%--
[표현식]
1. 작성 : ${ ... } <- 이걸 사용하려면 request에 Map에 객체가 저장되어 있어야 한다!
2. 용도: 값 또는 객체의 Getter를 이용해서 리턴값을 얻고 출력
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="com.mycompany.myapp.dto.*"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link href="/WebApplication/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/WebApplication/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  <body>
    <div>
      <%String name = "Hong";%>
      이름: <%=name%>
    </div>
    <br/>
    <div>
      <%Member member = new Member("Lee", 20);%>
      이름: <%=member.getName()%><br/>
      나이: <%=member.getAge()%>
    </div>
    <br/>
    <div>
      <%request.setAttribute("name", "Hong");%><br/>
      이름: <%=request.getAttribute("name")%>
      이름: ${name}
    </div>
    <br/>
    <div>
      <%request.setAttribute("member", new Member("Kim", 30));%>
      이름: <%=((Member)request.getAttribute("member")).getName() %>
      이름: ${member.name} <br/>
      나이: ${member.age}
    </div>
      <div>
      이름: ${name2} <br/>
      이름: ${member2.name} <br/>
      나이: ${member2.age}
    </div>
  </body>
</html>