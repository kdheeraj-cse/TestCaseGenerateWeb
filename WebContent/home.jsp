<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Left Sidebar template - Progressus Bootstrap template</title>

	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">
	<link rel="stylesheet" href="assets/custom-css/simple-sidebar.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
</head>

<body>
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="index.jsp"><img src="assets/images/logo.png" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">More Pages <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="active"><a href="sidebar-left.jsp">Left Sidebar</a></li>
							<li><a href="sidebar-right.jsp">Right Sidebar</a></li>
						</ul>
					</li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a class="btn" href="signin.jsp">SIGN IN / SIGN UP</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">
		
		<ol class="breadcrumb">
			<li><a href="index.jsp">Home</a></li>
			<li class="active">Left Sidebar</li>
		</ol>

		<div class="row">
			
			<!-- Sidebar -->
			<aside class="col-md-4 sidebar sidebar-left">
			
			
			
			
       <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Select Options
                    </a>
                </li>
                <li>
                    <a href="#" id="Dashboard" onclick="showContextForm(this.id)">Dashboard</a>
                </li>
                <li>
                    <a href="#" id="Create_Test" onclick="showContextForm(this.id)">Create Test</a>
                </li>
                <li>
                    <a href="#" id="Saved_Files" onclick="showContextForm(this.id)">Saved Files</a>
                </li>
                <li>
                    <a href="#" id="History" onclick="showContextForm(this.id)">History</a>
                </li>
                <li>
                    <a href="#" id="Edit_Profile"  onclick="showContextForm(this.id)">Edit Profile</a>
                </li>
                <li>
                    <a href="#" id="Search" onclick="showContextForm(this.id)">Search</a>
                </li>
            </ul>
        </div>
			
			</aside>
			<!-- /Sidebar -->
			
			
			<!-- Article main content for Dashboard -->
			<div id="dashboarddiv" style="display: block">
			<article class="col-md-8 maincontent">
				<header class="page-header">
					<h4 class="page-title">DASHBOARD</h4>
				</header>
				
				
			</article>
			</div>
			<!-- /Article -->
			
			
			
			
			<!-- Article main content for create test -->
			<div id="createtestdiv" style="display: none">
			<article class="col-md-8 maincontent">
				<header class="page-header">
					<h4 class="page-title">CREATE TEST</h4>
				</header>
<!-- Form Name : create Test -->				
<form class="form-horizontal">
<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label" for="jsonInput">Test steps JSON file</label>
  <div class="controls">
    <label class="radio" for="jsonInput-0">
      <input name="jsonInput" id="jsonInput-0" value="Select" checked="checked" type="radio" onclick="showJsonSelect()">
      Select
    </label>
    <label class="radio" for="jsonInput-1">
      <input name="jsonInput" id="jsonInput-1" value="Upload" type="radio" onclick="showJsonUploadForm()">
      Upload
    </label>
  </div>
</div>

 


<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label" for="excelInput">Combination Excel file</label>
  <div class="controls">
    <label class="radio" for="excelInput-0">
      <input name="excelInput" id="excelInput-0" value="Select" checked="checked" type="radio" onclick="showExcelSelect()">
      Select
    </label>
    <label class="radio" for="excelInput-1">
      <input name="excelInput" id="excelInput-1" value="Upload" type="radio" onclick="showExcelUploadForm()">
      Upload
    </label>
  </div>
</div>



<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label" for="outputFormat">Output format</label>
  <div class="controls">
    <label class="radio" for="outputFormat-0">
      <input name="outputFormat" id="outputFormat-0" value="xstudio" checked="checked" type="radio">
      xStudio upload compitable
    </label>
    <label class="radio" for="outputFormat-1">
      <input name="outputFormat" id="outputFormat-1" value="msword" type="radio">
      Microsoft word docx
    </label>
  </div>
</div>


<!-- Button -->
<br><br>
<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Create</button>
  </div>
</div>
</form>

<!-- Modal for test create -->

<!-- Modal for JSON UPLOAD -->
<div id="jsonUpload" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Upload JSON file</h4>
            </div>
            <div class="modal-body">
            	<div class="control-group" id="jsonupload">
  					<label class="control-label" for="filebutton"></label>
  					<div class="controls">
    				<input id="uploadfile" name="uploadfile" class="file" type="file">
  					</div>
				</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="startUpload()">UPLOAD</button>
                <div id="upload" style="display:none;">Uploading..</div>
            </div>
        </div>
    </div>
</div>

<!-- Modal for EXCEL UPLOAD -->
<div id="excelUpload" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Upload Excel file</h4>
            </div>
            <div class="modal-body">
            	<div class="control-group" id="jsonupload">
  					<label class="control-label" for="filebutton"></label>
  					<div class="controls">
    				<input id="filebutton" name="filebutton" class="file" type="file">
  					</div>
				</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="startUpload()">UPLOAD</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal for jsonSelect -->
<div id="jsonSelect" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Select JSON file</h4>
            </div>
            <div class="modal-body">
            	<div class="control-group" id="jsonupload">
  					<label class="control-label" for="filebutton"></label>
  					<div class="controls">
    				<input id="filebutton" name="filebutton" class="file" type="file">
  					</div>
				</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="startUpload()">UPLOAD</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal for excel select -->
<div id="excelSelect" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Select Excel file</h4>
            </div>
            <div class="modal-body">
            	<div class="control-group" id="jsonupload">
  					<label class="control-label" for="filebutton"></label>
  					<div class="controls">
    				<input id="filebutton" name="filebutton" class="file" type="file">
  					</div>
				</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="startUpload()">UPLOAD</button>
            </div>
        </div>
    </div>
</div>




<!-- Modal for test create Ends-->

<!-- Form : Create Test Ends -->				
				
				
			</article>
			</div>
			<!-- /Article -->





<!-- Article main content for saved files -->
			<div id="savediv" style="display: none">
			<article class="col-md-8 maincontent">
				<header class="page-header">
					<h4 class="page-title">SAVED FILES</h4>
				</header>
				
				
			</article>
			</div>
			
			<!-- /Article -->
<!-- Article main content for history -->
			<div id="historydiv" style="display: none">
			<article class="col-md-8 maincontent">
				<header class="page-header">
					<h4 class="page-title">HISTORY</h4>
				</header>
				
				
			</article>
			</div>
			<!-- /Article -->
<!-- Article main content for EDIT PROFILE-->
			<div id="editprofilediv" style="display: none">
			<article class="col-md-8 maincontent">
				<header class="page-header">
					<b><h4 class="page-title">EDIT PROFILE</h4></b>
				</header>
				
				
			</article>
			</div>
			<!-- /Article -->
<!-- Article main content for searcH -->
			<div id="searchdiv" style="display: none">
			<article class="col-md-8 maincontent">
				<header class="page-header">
					<h4 class="page-title">SEARCH</h4>
				</header>
				
				
			</article>
			</div>
			<!-- /Article -->



















		</div>
	</div>	<!-- /container -->
	

<footer id="footer" class="top-space">

		<div class="footer1">
			<div class="container">
				<div class="row">
					
					<div class="col-md-3 widget">
						<h3 class="widget-title">Contact</h3>
						<div class="widget-body">
							<p>+91-9538051387<br>
								<a href="mailto:kdheeraj.cse@gmail.com">kdheeraj.cse@gmail.com</a><br>
								<br>
								Residency Road Bangalore,  560025
							</p>	
						</div>
					</div>

					<div class="col-md-3 widget">
						<h3 class="widget-title">Follow me</h3>
						<div class="widget-body">
							<p class="follow-me-icons">
								<a href="https://twitter.com/dj8april"><i class="fa fa-twitter fa-2"></i></a>
								<a href=""><i class="fa fa-dribbble fa-2"></i></a>
								<a href=""><i class="fa fa-github fa-2"></i></a>
								<a href="https://www.facebook.com/dj8april"><i class="fa fa-facebook fa-2"></i></a>
							</p>	
						</div>
					</div>

					<div class="col-md-6 widget">
						<h3 class="widget-title">Text widget</h3>
						<div class="widget-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi, dolores, quibusdam architecto voluptatem amet fugiat nesciunt placeat provident cumque accusamus itaque voluptate modi quidem dolore optio velit hic iusto vero praesentium repellat commodi ad id expedita cupiditate repellendus possimus unde?</p>
							<p>Eius consequatur nihil quibusdam! Laborum, rerum, quis, inventore ipsa autem repellat provident assumenda labore soluta minima alias temporibus facere distinctio quas adipisci nam sunt explicabo officia tenetur at ea quos doloribus dolorum voluptate reprehenderit architecto sint libero illo et hic.</p>
						</div>
					</div>

				</div> <!-- /row of widgets -->
			</div>
		</div>

		<div class="footer2">
			<div class="container">
				<div class="row">
					
					<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="simplenav">
								<a href="#">Home</a> | 
								<a href="about.jsp">About</a> |
								<a href="sidebar-right.jsp">Sidebar</a> |
								<a href="contact.jsp">Contact</a> |
								<b><a href="signup.jsp">Sign up</a></b>
							</p>
						</div>
					</div>

					<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="text-right">
								Copyright &copy; 2015, Dheeraj Arya.
							</p>
						</div>
					</div>

				</div> <!-- /row of widgets -->
			</div>
		</div>

	</footer>	

		




	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
	<script src="assets/custom-js/my.js"></script>
	<script src="assets/upload-js/jquery.ajaxfileupload.js"></script>
</body>
</html>