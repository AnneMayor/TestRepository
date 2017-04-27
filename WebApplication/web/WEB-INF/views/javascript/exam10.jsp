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
      console.log(window.outerHeight);
      console.log(window.outerWidth);
      console.log(window.innerHeight);
      console.log(window.innerWidth);

      var mywindow;
      function handleBtn1() {
        mywindow = window.open("/WebApplication/javascript/exam09", "pop1", "width=500, height=200");
      }

      function handleBtn2() {
        mywindow.close();
      }

      function handleBtn3() {
        work1 = window.setInterval(function () {
          console.log(new Date());
        }, 1000);
        work2 = window.setInterval(function () {
          console.log("Wow");
        }, 1000);
      }

      function handleBtn4() {
        finish1 = window.clearInterval(work1);
        finish2 = window.clearInterval(work2);
      }

      // 반복시행이 안된다 얘는! 알아두자! 글구 특정 시간 이후에 한번 시행하는 명령어다!
      function handleBtn5() {
        work3 = window.setTimeout(function () {
          console.log("Yeah!");
        }, 3000);
      }

      function handleBtn6() {
        window.clearTimeout(work3);
      }
      
      function handleBtn7() {
        location.href = "/WebApplication/javascript/exam09";
      }
    </script>
  </head>

  <body>
    <h1>BOM 사용하기</h1>

    <h3>Popup</h3>
    <button onclick="handleBtn1()" class="btn btn-info">Open Popup(New Tab Only applicable in New Tab)</button>
    <button onclick="handleBtn2()" class="btn btn-info">Close Popup(New Tab Only applicable in New Tab)</button><br/>

    <h3>Interval execution</h3>
    <button onclick="handleBtn3()" class="btn btn-info">Start</button>
    <button onclick="handleBtn4()" class="btn btn-info">End</button><br/>

    <h3>Delay execution</h3>
    <button onclick="handleBtn5()" class="btn btn-info">Start</button>
    <button onclick="handleBtn6()" class="btn btn-info">End</button><br/>

    <h3>Path Switch</h3>
    <button onclick="handleBtn7()" class="btn btn-info">Path</button>
  </body>
</html>
