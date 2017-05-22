<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Bootstrap Introduction</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link href="/WebApplication/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/WebApplication/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  <body>
    <h3>Button</h3>
    <button>Default</button>
    <button type="button" class="btn btn-default">Default</button>
    <button type="button" class="btn btn-primary">Primary</button>
    <button type="button" class="btn btn-success">Success</button>
    <button type="button" class="btn btn-info">Info</button>
    <button type="button" class="btn btn-danger">Danger</button>
    <button type="button" class="btn btn-link">Link</button>

    <a class="btn btn-primary">Go to home</a><br/><br/><br/>
    <input type="button" value="input tag" class="btn btn-warning"/>

    <h3>Table</h3>
    <table class="table">
      <tr>
        <td>Number</td>
        <td>Title</td>
        <td>Writer</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Today is the day of playing soccer</td>
        <td>With Team Software Associate and us</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Java Study</td>
        <td>me</td>
      </tr>
    </table>

    <br/>
    <table class="table-bordered">
      <tr>
        <td>Number</td>
        <td>Title</td>
        <td>Writer</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Today is the day of playing soccer</td>
        <td>With Team Software Associate and us</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Java Study</td>
        <td>me</td>
      </tr>
    </table>

    <br/>
    <br/>
    <table class="table table-hover">
      <tr>
        <td>Number</td>
        <td>Title</td>
        <td>Writer</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Today is the day of playing soccer</td>
        <td>With Team Software Associate and us</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Java Study</td>
        <td>me</td>
      </tr>
    </table>
    <br/>

    <table class="table-condensed">
      <tr>
        <td>Number</td>
        <td>Title</td>
        <td>Writer</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Today is the day of playing soccer</td>
        <td>With Team Software Associate and us</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Java Study</td>
        <td>me</td>
      </tr>
    </table>

    <h3>Image</h3>
    <img class="img-circle" src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px" />
    <img class="img-rounded" src="/WebApplication/resources/image/photo1.jpg" width="100px" height="100px" />
    <br/>
    <br/>
    
    <h3>Form</h3>
    <form>
      <div>
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" id="exampleInputEmail1" placeholder="Email">
      </div>
    </form>

    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
      </div>
    </form>
    
  </body>
</html>
