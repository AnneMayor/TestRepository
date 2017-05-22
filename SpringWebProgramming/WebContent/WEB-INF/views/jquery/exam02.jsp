<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Load function</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link href="/WebApplication/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/WebApplication/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>


  </head>
  <body>
    <h1>Load complete function</h1>

    <img id="img1" src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px" />
    <script>
      $(function () {
        var img = $("#img1");
        img.attr("src", "/WebApplication/resources/image/photo02.jpg");
      });
      
       jQuery(function () {
         console.log("log1");
      });
      
       $(function () {
         console.log("log2");
      });

      $(document).ready(function () {
        var img = $("#img1");
        img.attr("src", "/WebApplication/resources/image/photo02.jpg");
      });
    </script>
  </body>
</html>
