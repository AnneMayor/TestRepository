<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script>
      // 전역 변수
      var v1 = "A";
      var v4;
      function fun1() {
        // 로컬 변수
        // 자.스에선 블록단위의 변수가 존재하지않고 오로지 함수 단위의 변수만 존재.
        if(true) {
          var v3 = "C";
          v4 = "D";
        }
        var v2 = "B";

        console.log(v1);
        console.log(v2);
        console.log(v3);
        console.log(v4);
      }
      
      fun1(); // 한번 호출해줘야 v4결과 나옴. 
      console.log(v1);
      //console.log(v2); (x)
      console.log(v4);
    </script>
    <script>

    </script>
  </head>
  <body>
  </body>
</html>