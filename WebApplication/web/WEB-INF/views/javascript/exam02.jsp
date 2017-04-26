<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script>
      // 매개변수엔 var타입선언 안해준다...
      function totalSum(from, to) {
        /*
         }
         console.log(from);
         // 작은 따옴표를 더 많이 쓴다...큰따옴표보단...
         console.log(to == 'undefined');
         */
        if (to == undefined) {
          to = from;
          from = 0;
        }
        var sum = 0;
        for (var i = 0; i <= to; i++) {
          sum += i;
        }
        return sum;
      }
      
      var result = totalSum(1, 100);
      console.log("result: " + result);
      var result2 = totalSum(100);
      console.log(result2);
    </script>
  </head>
  <body>
  </body>
</html>
