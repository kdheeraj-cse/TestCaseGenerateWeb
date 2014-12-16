<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TC</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
      <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://code.jquery.com/jquery.js"></script>
      <script src="Bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<fieldset>



<form class="form-horizontal" role="form">
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">First Name</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="firstname" 
            placeholder="Enter First Name">
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">Last Name</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="lastname" 
            placeholder="Enter Last Name">
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <div class="checkbox">
            <label>
               <input type="checkbox"> Remember me
            </label>
         </div>
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default">Sign in</button>
      </div>
   </div>
</form>



</fieldset>
</div>

</body>
</html>