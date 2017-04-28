<%--

[지시자]
1. 작성: <%@ ... %>
2. 종류
<%@page ... %> : JSP가 무엇을 만들어내느냐? (import시킬 적에도 page지시자 사용!)
<%@include ... %> : 외부파일을 가져와서 포함시킨다.
<%@taglib ... %> : 
--%>
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
    <h1>Other package class include</h1>
    <%@include file="exam02_include.jsp" %>
  </body>
</html>
