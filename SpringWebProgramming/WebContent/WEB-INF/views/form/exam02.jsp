<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Join in</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link href="/WebApplication/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/WebApplication/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  <body>
    <h1>Join in</h1>
    <form method="post" action="exam02" style="padding: 0px 20px 0px 20px" enctype="multipart/form-data">
      <div class="form-group">
        <div class="input-group">
          <span class="input-group-addon">
            <span class="glyphicon glyphicon-user"></span>
          </span>
          <input type="text" class="form-control" placeholder="아이디" name="mid"/>
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <span class="input-group-addon">
            <span class="glyphicon glyphicon-tag"></span>
          </span>
          <input type="text" class="form-control" placeholder="이름" name="mname" />
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <span class="input-group-addon">
            <span class="glyphicon glyphicon-lock"></span>
          </span>
          <input type="password" class="form-control" placeholder="비밀번호" name="mpassword"/>
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <span class="input-group-addon">
            <span class="glyphicon glyphicon-leaf"></span>
          </span>
          <input type="number" class="form-control" placeholder="나이" name="mage"/>
        </div>
      </div>		
      <div class="form-group">
        <div class="input-group">
          <span class="input-group-addon" style="border-right:1px solid #ccc;">
            <span class="glyphicon glyphicon-cog"></span>
          </span>
          <input name="mskill" type="checkbox" value="Java"
                 style="width:25px;height:25px;margin-left:10px;"/>Java
          <input name="mskill" type="checkbox" value="SQL"
                 style="width:25px;height:25px"/>SQL
          <input name="mskill" type="checkbox" value="JSP"
                 style="width:25px;height:25px"/>JSP
          <input name="mskill" type="checkbox" value="Spring"
                 style="width:25px;height:25px"/>Spring
        </div>
      </div>
      <div class="form-group">
        <div class="input-group">
          <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
          </span>
          <input type="date" class="form-control" placeholder="생년월일" name="mbirth" />
        </div>
      </div>

      <div class="form-group">
        <div class="input-group">
          <span class="input-group-addon">
            <span class="glyphicon glyphicon-camera"></span>
          </span>
          <input type="file" class="form-control" placeholder="선택" name="attach" />
        </div>
      </div>

      <input type="submit" class="btn btn-info" value="Join in"/>
    </form>
  </body>	
</html>