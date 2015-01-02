<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOMETOHOME</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
      <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://code.jquery.com/jquery.js"></script>
      <script src="Bootstrap/js/bootstrap.min.js"></script>
      <script src="Bootstrap/js/myJsFunction.js"></script>
</head>
<body>
<%
HttpSession objHttpSession = request.getSession();
if(objHttpSession.getAttribute("islogin").equals(false))
{
	response.sendRedirect("login.jsp");
}

for(Cookie cookie : request.getCookies())
{
	out.println(cookie.getName());
	out.println(cookie.getValue());
}
%>




</body>
</html>