<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>CSS</title>
  </head>
  <body>
    <h1>Block태그 및 CSS</h1>
    
    <h3>Block 태그</h3>
    <div style="background-color: red; border: 1px solid black; height: 100px;">
      div tag
    </div>
    <p style="background-color: orange; border: 1px solid black; height: 50px;">p tag</p>
    <h4 style="background-color: yellow; border: 1px solid black; height: 50px;">h tag</h4>
    <form style="background-color: green; border: 1px solid black; height: 50px;">form tag</form>
    <table style="background-color: white; border: 1px solid black; height: 50px; width: 100px;">
      <tr>
        <td>
          Table tag
        </td>
      </tr>
    </table>
    <table style="background-color: white; border: 1px solid black; height: 50px; width: 100%">
      <tr>
        <td>
          Table tag
        </td>
      </tr>
    </table>

    <br/>
    <br/>
    
    <h3>Inline 태그</h3>
    <span style="background-color: skyblue; border: 1px solid black; height: 50px;">span tag</span>
    <span style="background-color: blue; border: 1px solid black; height: 50px;">span tag</span>
    <div style="background-color: violet; border: 1px solid black; height: 100px;">
      div tag
    </div>
    <img style="border: 2px dashed black; height: 100px;" src="/WebApplication/resources/image/google.png">
    <span style="font">+</span>
    <a href="https://www.apple.com/">Apple</a>
    <button>Button</button>
    
    <h3>블록 -> 인라인</h3>
   <div style="background-color: violet; border: 1px solid black; height: 100px; display: inline;">
      div tag
    </div>
    <div style="background-color: violet; border: 1px solid black; height: 100px; display: inline;">
      div tag
    </div>
    
  </body>
</html>
