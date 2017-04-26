<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script>
      function onClickBtnNaver() {
        console.log("onClickBtnNaver()...");
        location.href = "http://www.naver.com";
      }

      for (var i = 0; i < 10; i++) {
      }
      
      function onClickBtnGoogle() {
        console.log("onClickBtnGoogle()...");
        location.href = "http://www.google.com";
      }
    </script>
  </head>
  <body>
    <h1>Tag Type</h1>
    <h3>Link Tag </h3>
    <a href="http://www.naver.com">Naver</a><br/>
    <h3>Button Tag </h3>
    <button id="btnNaver" onclick="onClickBtnNaver()">Naver</button>
    <button id="btnGoogle" onclick="onClickBtnGoogle()">Google</button><br/><br/>
    <input type="button" onclick="onClickBtnGoogle()" value="Google" />
    <h3>Image Tag </h3>
    <img src="http://localhost:8080/WebApplication/resources/image/사과.png" alt="apple" width="230px" />
    <input type="image" src="http://localhost:8080/WebApplication/resources/image/사과.png" width="300px"/>
    <input type="image" src="http://localhost:8080/WebApplication/resources/image/사과.png" /><br/><br/>
    
    <h3>Container Tag</h3>
    <div>
      <button id="btnNaver" onclick="onClickBtnNaver()">Naver</button><br/>
      <img src="http://localhost:8080/WebApplication/resources/image/naver.png" />
    </div>
    
    <h3>Form Tag</h3>
    <form>
      이름: <input type="text"/> <br/>
      나이: <input type="number"/><br/>
      생년월일: <input type="date"/><br/>
      성별: <input type="radio" name="sex" />남 <input type="radio" name="sex" />여<br/>
      관심분야: <input type="checkbox" />자바 <input type="checkbox" />자바FX <input type="checkbox" />스프링 <br/>
      <input type="button" value="일반버튼"/>
      <input type="button" value="리셋버튼"/>
      <input type="button" value="제출버튼"/>
    </form>
  </body>
</html>
