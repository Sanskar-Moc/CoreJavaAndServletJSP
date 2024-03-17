<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success page</title>
</head>
<body>
	<%
		String name=(String)request.getAttribute("myname");
	%>
	<%
	List<String>list=new ArrayList<>();
	%>
	<%=name %>
	<%=config.getInitParameter("myname") %>
	<%=application.getAttribute("myname") %>
		<h2>Authentication Successful</h2>
		<h2>Welcome <%=session.getAttribute("uname") %></h2>

</body>
</html>