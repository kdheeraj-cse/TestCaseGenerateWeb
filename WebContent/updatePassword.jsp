<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE</title>
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
<div class="updatePasswordForm" id="">
<form action="update.do" class="" role="form" method="post">
	<div class="form-group">
		<label for="old" class="col-sm-2 control-label">Old Password</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="old" name="old"></div>
	</div>
	<div class="form-group">
		<label for="new1" class="col-sm-2 control-label">New Password</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="new1" name="new1"></div>
	</div>
	<div class="form-group">
		<label for="new2" class="col-sm-2 control-label">Confirm Password</label>
		<div class="col-sm-10"><input type="text" class="form-control" id="new2" name="new2"></div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default">Update</button>
     	</div>
	</div>
</form>
</div>
</div>

</body>
</html>