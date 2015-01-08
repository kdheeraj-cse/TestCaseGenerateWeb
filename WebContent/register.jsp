<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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

<div class="registerForm" id="">
<form action="register.do" class="" role="form" method="post">
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">UserID</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="userId" name="userId"></div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">NAME</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="name" name="name"></div>
	</div>
	<div class="form-group">
		<label for="age" class="col-sm-2 control-label">Age</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="age" name="age"></div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="email" name="email"></div>
	</div>
	<div class="form-group">
		<label for="address" class="col-sm-2 control-label">Address</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="address" name="address"></div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default">Register</button>
     	</div>
	</div>
</form>
</div>
</div>


</body>
</html>