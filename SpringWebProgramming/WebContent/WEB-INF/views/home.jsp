<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link href="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=application.getContextPath() %>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
  </head>

  <body>
    WebApplication Home
    <hr/>
    <h4>html 태그</h4>
    <a href="html/exam01" class="btn btn-warning">exam01</a>

    <h4>CSS</h4>
    <a href="css/exam01" class="btn btn-success">exam01</a>
    <a href="css/exam02" class="btn btn-success">exam02</a>
    <a href="css/exam03" class="btn btn-success">exam03</a>

    <h4>JavaScript</h4>
    <%for (int i = 1; i <= 11; i++) {
        String exam = "exam";
        if (i < 10) {
          exam += "0" + i;
        } else {
          exam += String.valueOf(i);
          }%>
    <a href="javascript/<%=exam%>" class="btn btn-primary"><%=exam%></a>
    <%}%>

    <h4>Jquery</h4>
    <%for (int i = 1; i <= 4; i++) {
        String exam = "exam";
        if (i < 10) {
          exam += "0" + i;
        } else {
          exam += String.valueOf(i);
          }%>
    <a href="jquery/<%=exam%>" class="btn btn-primary"><%=exam%></a>
    <%}%>

    <h4>BootStrap</h4>
    <%for (int i = 1; i <= 3; i++) {
        String exam = "exam";
        if (i < 10) {
          exam += "0" + i;
        } else {
          exam += String.valueOf(i);
          }%>
    <a href="bootstrap/<%=exam%>" class="btn btn-primary"><%=exam%></a>
    <%}%>"

    <h4>JSP</h4>
    <%for (int i = 1; i <= 5; i++) {
        String exam = "exam";
        if (i < 10) {
          exam += "0" + i;
        } else {
          exam += String.valueOf(i);
          }%>
    <a href="jsp/<%=exam%>" class="btn btn-primary"><%=exam%></a>
    <%}%>

    <h4>HTTP</h4>
    <h5>요청방식</h5>
    1) GET 방식: <a href="http/exam01" class="btn btn-primary">exam01</a> <br/>
    2) POST 방식: 
    <form method="post" action="http/exam01" style="display:inline">
      <input type="submit" value="exam01" class="btn btn-primary"/>
    </form>

    <h4>요청 HTTP 정보 얻기</h4>
    <a href="http/exam02?type=freeboard&bno=5&hobby=baseball&hobby=soccer" class="btn btn-primary">exam02</a>
    <a href="http/exam03?type=freeboard&bno=5&hobby=baseball&hobby=soccer" class="btn btn-primary">exam03</a>

    <h4>폼 제출</h4>
    <a href="form/exam01" class="btn btn-primary">회원 가입 양식 요청</a>

    <h4>파일 업로드</h4>
    <a href="form/exam02" class="btn btn-primary">회원 가입 양식 요청</a>

    <h4>파일 다운로드</h4>
    <a href="file/exma03" class="btn btn-primary">파일로 저장</a>
    <img src="file/exam03" width="100px" height="100px" />
    
    <h4>의존성 주입</h4>
    <a href="di/exam01" class="btn btn-primary">회원 가입</a>
    <a href="di/exam02" class="btn btn-primary">로그인</a>
  </body>
</html>