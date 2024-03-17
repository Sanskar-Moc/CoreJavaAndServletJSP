<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
	<%=request.getAttribute("myname") %>
	
	<%=application.getAttribute("myname") %>
	<h1>login page</h1>
	<form action='login' method='post' >
         <label for="fname">Enter Username:</label><br>
         <input type='text' name='uname'><br>
         <label for="lname">Enter Password:</label><br>
         <input type='password' name='pwd'><br><br>
         <input type="submit" value="Sign In">
       </form>
</body>
</html>