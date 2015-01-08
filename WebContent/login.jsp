<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
      <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="Bootstrap/css/myTheme.css" rel="stylesheet">
      <script src="https://code.jquery.com/jquery.js"></script>
      <script src="Bootstrap/js/bootstrap.min.js"></script>
      <script src="Bootstrap/js/myJsFunction.js"></script>
</head>
<body>
<div class="container">
<div class=""></div>
<div class="loginImage" id="">
<img alt="Login" src="Bootstrap/Images/login.jpg" class="img-rounded">
</div>
<div class="loginForm" id="">
<form action="userLogin.do" class="" role="form" method="post">
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">User-name</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="userid" name="userid"></div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10"><input type="password" class="form-control" id="password" name="password"></div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default">Sign in</button>
     	</div>
	</div>
</form>
</div>
<a href="register.jsp">Sign UP</a>

</div>
</body>
</html>