<%-- 
    Document   : exam07
    Created on : 2017. 4. 27, 오전 9:34:13
    Author     : Administrator
--%>

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
  </head>
  <script>
    var arr1 = ["Saab", "Volvo", "BMW"];
    console.log(arr1[0]);
    console.log(arr1.length);

    var arr2 = new Array("Saab", "Volvo", "BMW");
    arr2.sort();
    for (var i = 0; i < arr2.length; i++) {
      console.log(arr2[i]);
    }

    var arr3 = ["Banana", "Orange", "Apple", "Mango"];
    arr3.push("Lemon");
    for (var i = 0; i < arr3.length; i++) {
      console.log(arr3[i]);
    }
    arr3[5] = "Grape";
    for (var i = 0; i < arr3.length; i++) {
      console.log(arr3[i]);
    }

    arr3.splice(2, 1, "Kiwi");
    for (var i = 0; i < arr3.length; i++) {
      console.log(arr3[i]);
    }
    
    arr3.splice(0, 2);
     for (var i = 0; i < arr3.length; i++) {
      console.log(arr3[i]);
    }
  </script>
  <body>
    <h1>Array</h1>
  </body>
</html>
