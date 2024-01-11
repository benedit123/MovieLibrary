<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditMovie</title>
</head>
<body>
<h2>Edit movie</h2>


<%Movie m=(Movie)request.getAttribute("movie"); %>

<%if(m!=null){ %>

<form action="movieEdit" method="post" enctype="multipart/form-data" >
movie_id:<input type="text" name="movie_id"value="<%= m.getMovie_id() %>" readonly="readonly"><br>
movie_name:<input type="text" name="movie_name" value="<%= m.getMovie_name()%>"><br>
movie_price:<input type="text" name="movie_price" value="<%= m.getMovie_price()%>" ><br>
movie_rating:<input type="text" name="movie_rating" value="<%= m.getMovie_rating()%>"><br>
movie_genre:<input type="text" name="movie_genre" value="<%= m.getMovie_genre()%>" ><br>
movie_language	:<input type="text" name="movie_language" value="<%= m.getMovie_language()%>"><br>


movie_image:<input type="file" name="movie_image" value="<%=m.getMovie_image() %>" ><br>
<input type="submit" >

<%} %>

</form> 
<% String base64image=new String(Base64.getEncoder().encode(m.getMovie_image())); %>

<img src="data:image/jpeg;base64,<%=base64image%>" height="100px" width="100px" > 
</body>
</html>