<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hi</h1>
<form action="signIn" method="post">
Email:<input name="userEmail" type="text" ><br><br>
pass:<input name="userPass" type="text" ><br><br>
<input type="submit">
<a href="userLogin.jsp" >signup</a>
<% String message = (String)request.getAttribute("message"); %>
<% if(message!=null){ %>
<%=message %>
<%} %>
</form>
</body>
</html>