<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<form action="admin_login"	 method="post" >
<label for="id" >MailId</label>
<input  id="id" type="text" name="admin_mail" >
<label for="pass" >password</label>
<input  id="pass" type="password" name="admin_pass" >
<input type="submit">
</form>
<% String message = (String)request.getAttribute("message"); %>
<% if(message!=null){ %>
<%=message %>
<%} %>
</body>
</html>