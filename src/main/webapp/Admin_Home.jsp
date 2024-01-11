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
<h1>welcome home</h1>
<% List<Movie> movies=(List)request.getAttribute("movies"); %>


<%if(movies!=null){ %>
<table border="2px">
<tr>
<th>id</th>
<th>name</th>
<th>prize</th>
<th>rating</th>
<th>genre</th>
<th>language</th>
<th>image</th>
<th>DeleteMovie</th>
<th>Edit_movie</th>
</tr>

<% for(Movie m:movies){ %>
<tr>
<td><%= m.getMovie_id() %></td>
<td><%= m.getMovie_name() %></td>
<td><%= m.getMovie_price() %></td>
<td><%= m.getMovie_rating() %></td>
<td><%= m.getMovie_genre() %></td>
<td><%= m.getMovie_language() %></td>


<% String base64image=new String(Base64.getEncoder().encode(m.getMovie_image())); %>

<td> <img src="data:image/jpeg;base64,<%=base64image%>" height="100px" width="100px" > </td>
<td> <a href="deleteMovie?id=<%= m.getMovie_id() %>" >Delete</a></td>
<td> <a href="EditMovie?id=<%= m.getMovie_id() %>" >Edit</a></td>

</tr>
<% } %>

</table>
<%} %>





<a href="add_movie.jsp" >add_movie</a>
</body>
</html>