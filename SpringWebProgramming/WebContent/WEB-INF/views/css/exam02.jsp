<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>CSS</title>
    <style type="text/css">
      /*태그 선택자(selector)*/
      div {
        background-color: red; 
        border: 1px solid black; 
        height: 100px;
      }
      /*Class 선택자*/
      .skyblue{
        background-color: skyblue; 
      }
      /*ID 선택자*/
      #gold {
        background-color: gold;
      }
      .btn {
        background-color: gray;
        border: 1px solid black;
        height: 70px;
        padding: 5px;
      }
      .success {
        background-color: forestgreen;
        color: white;
      }
      .warning {
        background-color: red;
        color: white;
      }
      
    </style>
  </head>
  <body>
    <div class="skyblue">
      div tag
    </div>
    <div id="gold">
      div tag
    </div>
    <div>
      div tag
    </div>
    <br/>
     클래스 선택자가 띄어쓰기가 있을 경우 띄어쓰기+1개만큼의 클래스 적용되었다는 의미<br/><br/> 
    <a class="btn success">Confirm</a>
     <a class="btn warning">Warning</a>
  </body>
</html>
