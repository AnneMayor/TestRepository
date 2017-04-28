<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="UTF-8">
    <title>WebApplication</title>
  </head>

  <body>
    WebApplication Home
    </hr>

    <h4>html tag</h4>
    <a href="/WebApplication/html/exam01" >exam01</a>

    <h4>css tag</h4>
    <a href="/WebApplication/css/exam01" >exam01</a>
    <a href="/WebApplication/css/exam02" >exam02</a>
    <a href="/WebApplication/css/exam03" >exam03</a>

    <h4>javascript tag</h4>
    <%for (int i = 1; i <= 11; i++) {
        String exam = "exam";
        if (i < 10) {
          exam += "0" + i;
        } else {
          exam += String.valueOf(i);
        }%>
        <a href="javascript/<%=exam%>" ><%=exam%></a>
    <%}%>
    
    <h4>jquery tag</h4>
    <%for (int i = 1; i <= 4; i++) {
      String exam = "exam";
      exam += "0" + i;
      %>
      <a href="jquery/<%=exam%>"><%=exam%></a>
    <%}%>
    
    <h4>bootstrap tag</h4>
    <%for (int i = 1; i <= 3; i++) {
      String exam = "exam";
      exam += "0" + i;
      %>
      <a href="bootstrap/<%=exam%>" ><%=exam%></a>
      <%}%>
  </body>

</html>

