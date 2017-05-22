<%--
[지시자]
1. 작성: <%@ ... %>
2. 종류
<%@page ... %> : JSP가 무엇을 만들어내느냐? (import시킬 적에도 page지시자 사용!)
<%@include ... %> : 
<%@taglib ... %> : 
--%>

<%@page import="java.util.Calendar, java.io.*, java.net.*"%>
<%@page contentType="text/html; charset=UTF-8"%>
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
    <h1>java.util.Calendar</h1>
    <%
      Calendar now = Calendar.getInstance();
      int year = now.get(Calendar.YEAR);
      int month = now.get(Calendar.MONTH) + 1;
      int day = now.get(Calendar.DAY_OF_MONTH);
    %>
    <%=year%>년 <%=month%>월 <%=day%>일
  </body>
</html>