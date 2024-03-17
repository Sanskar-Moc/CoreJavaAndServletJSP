<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>counter</title>
</head>
<body>
<%!
int counter=0;
List<String>list=new ArrayList<>();
public String sayHello(String name){
	return "hello, como estas "+name;
}
%>
<%
list.add("Jesus");
list.add("John");
list.add("Judah");
list.add("Joseph");
counter++;
%>
 <% for (String x:list) { %>
            <li><%= x %></li>
        <% } %>
<h2>you are visitor number <%=counter %></h2>
<%=sayHello("Christopher") %>
</body>
</html>