<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script src="/WebApplication/resources/js/exam04.js" type="text/javascript"></script>
    <script>
      var result = totalSum(1, 100);
      console.log(result);
    </script>
  </head>
  <body>
    <button onclick="handleBtnOk()">
      OK
    </button>
    <a href="javascript:handleBtnOk()">OK</a>
  </body>
</html>