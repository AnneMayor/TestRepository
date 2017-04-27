<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Bootstrap Grid</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link href="/WebApplication/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/WebApplication/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <script>
      var v1 = "abc";
      console.log(v1.length);
      var v2 = "Javascript is easy";
      console.log(v2.indexOf("easy"));
      var v3 = "1234567-34213432";
      console.log(v3.substr(0,6));
      console.log(v3.substring(0,6));
      console.log(v3.substring(0, v3.length));
      console.log(v3.substr(0, v3.length));
      console.log(v3.charAt(3));
      
      var v4 = "10:20:30";
      var arr = v4.split(":");
      console.log(arr);
      
    </script>
  </head>
  <body>
    <h1>String method</h1>
  </body>
</html>
