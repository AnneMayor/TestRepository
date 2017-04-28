<%--
[표현식]
1. 작성 : ${ ... } <- 이걸 사용하려면 request에 Map에 객체가 저장되어 있어야 한다!
2. 용도: 값 또는 객체의 Getter를 이용해서 리턴값을 얻고 출력
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="com.mycompany.myapp.dto.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    
    <hr/>
    <h3>Board</h3>
    No: ${board.bno}<br/>
    Name: ${board.bwriter}<br/>
    Date: ${board.bdate}<br/>
    Content: ${board.bcontent}<br/>
    <hr/>
    
    <h3>New Board</h3>
    <table class="table table-bordered">
      <tr class="success">
        <td>
          번호
        </td>
        <td>
          제목
        </td>
        <td>
          내용
        </td>
        <td>
          글쓴이
        </td>
        <td>
          날짜
        </td>
      </tr>
      <c:forEach var="b" items="${list}">
        <tr>
          <td>${b.bno}</td>
        <td>${b.btitle}</td>
        <td>${b.bcontent}</td>
        <td>${b.bwriter}</td>
        <td>${b.bdate}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>