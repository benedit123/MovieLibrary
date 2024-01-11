<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add movie</h2>
<form action="Addmovie" method="post" enctype="multipart/form-data" >
movie_id:<input type="text" name="movie_id" ><br>
movie_name:<input type="text" name="movie_name" ><br>
movie_price:<input type="text" name="movie_price" ><br>
movie_rating:<input type="text" name="movie_rating" ><br>
movie_genre:<input type="text" name="movie_genre" ><br>
movie_language:<input type="text" name="movie_language" ><br>
movie_image:<input type="file" name="movie_image" ><br>
<input type="submit" >



</form>
</body>
</html>