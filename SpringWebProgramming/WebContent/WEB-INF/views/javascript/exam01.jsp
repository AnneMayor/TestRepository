<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSP Page</title>
    <script type="text/javascript">
      //변수 선언(기본 타입, 참조 타입 따로 존재하지 않음. 내부적으로는 타입이 존재하나 작성할 땐 var로 통일)
      var v1 = 10;
      var v2 = "Javascript 드뎌 시작!ㅋㅋ";
      var v3 = true;
      var v4 = [10, 20, 30, 40];
      var v5 = { "mid":"white", "mname":"Dahye Lee", "mage": "20"}; // 자.스는 필드라는 용어대신 속성이라는 용어 사용! 네트워크로 전송할 목적이면 이렇게 ""마크로 감싸주기. 혼란스러울 땐 걍 넣기
      var v6 = new Date();
      var v7 = null;
      // 여기선 함수도 객체!자바는 절대 메소드는 객체 아니다! v8: 변수이름이자 함수이름
      var v8 = function() { 
        console.log("function() 실행");
      }
      console.log(typeof(v1) + " " + v1);
      console.log(typeof(v2) +" " +v2);
      console.log(typeof(v3) + " " + v3);
      console.log(typeof(v4) + " " + v4);
      console.log(v5);
      console.log(typeof(v5) + " " + v5);
      console.log(v6);
      console.log(typeof(v7) + " " + v7);
      console.log(typeof(v8) + " " + v8);
      v8();
    </script>
  </head>
  <body>
  </body>
</html>
