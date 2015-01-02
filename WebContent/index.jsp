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
      <script src="Bootstrap/js/myJsFunction.js"></script>
</head>
<body>
<div class="container">

<div>
<ul class="nav nav-pills nav-stacked">
   <li class="active"><a href="#">Home</a></li>
   <li><a onclick="showCreateTest();">Create Test</a></li>
   <li><a onclick="showHistory();">See History</a></li>
   <li><a href="#">Edit Profile</a></li>
   <li><a href="#">Saved Files</a></li>
   <li><a href="#">--</a></li>
</ul>
</div>







<div id="createTest" style="display:none">
<form class="form-horizontal" role="form">
   <div class="form-group">
      <label for="uploadJSON" class="col-sm-2 control-label">JSON</label>
      <div class="col-sm-10">
         <input type="file" id="jsonFile" class="file" onchange="uploadStart(this.value);"
            >
          <img alt="" id="uploadProg" src="" height="25" width="25">
      </div>
   </div>
   <div class="form-group">
      <label for="uploadExcel" class="col-sm-2 control-label">Excel</label>
      <div class="col-sm-10">
         <input type="file" id="excelFile" class="file"
            >
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
</div>


</div>

</body>
</html>