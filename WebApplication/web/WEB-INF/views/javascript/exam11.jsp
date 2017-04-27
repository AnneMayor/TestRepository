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
      function handleBtn1() {
        //var img = window.document.querySelector("img");
        //img.src = "/WebApplication/resources/image/photo02.jpg";
        
        var imgArray = document.querySelectorAll("img");
        for(var i = 0; i < imgArray.length; i++) {
          imgArray[i].src = "/WebApplication/resources/image/photo02.jpg";
        }
      }
      
      function handleBtn2() {
        var img1 = document.querySelector("#img1");
        img1.src="/WebApplication/resources/image/photo06.jpg";
      }
      
      function handleBtn3() {
        var imgClass = document.querySelectorAll(".class1");
        for(var i = 0; i < imgClass.length; i++) {
          imgClass[i].src = "/WebApplication/resources/image/photo05.jpg";
        }
      }
      
    </script>
  </head>
  <body>
    <h1>DOM 사용하기</h1>

    <div>
      <img src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px" />
      <img id="img1" src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px" />
      <img class="class1" src="/WebApplication/resources/image/photo09.jpg" width="100px" height="100px" />
      <button onclick="handleBtn1()" class="btn btn-success">Image Change</button><br/>
      <button onclick="handleBtn2()" class="btn btn-success">Image(id="img1") Change</button><br/>
      <button onclick="handleBtn3()">Image(class="class1") Change</button><br/>
    </div>


  </body>
</html>
