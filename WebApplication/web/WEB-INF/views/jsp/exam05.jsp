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
    이름: ${name3}<br/>
    이름: ${member3.name}<br/>
    나이: ${member3.age}<br/>
    
    <h3>Board</h3>
    No: ${board.bno}<br/>
    Name: ${board.bwriter}<br/>
    Date: ${board.bdate}<br/>
    Content: ${board.bcontent}<br/>
      
  </body>
</html>