package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dto.Movie;

@WebServlet("/movieEdit")
@MultipartConfig(maxFileSize = 5*1024*2024)
public class EditMovie2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movieid1=req.getParameter("movie_id");
		System.out.println("hi");
		System.out.println(movieid1);
		if (movieid1!=null) {
			int movieid=Integer.parseInt(movieid1);
		
		
		
		System.out.println(movieid1);
		String moviename=req.getParameter("movie_name");
		double movieprize=Double.parseDouble(req.getParameter("movie_price"));
		double movierating=Double.parseDouble(req.getParameter("movie_rating"));
		String moviegenre=req.getParameter("movie_genre");
		String movielanguage=req.getParameter("movie_language");
		Part imagepart=req.getPart("movie_image");
		
		Movie movie=new Movie();
		movie.setMovie_id(movieid);
		movie.setMovie_name(moviename);
		movie.setMovie_price(movieprize);
		movie.setMovie_rating(movierating);
		movie.setMovie_genre(moviegenre);
		
		movie.setMovie_language(movielanguage);
if (imagepart.getInputStream().readAllBytes().length>0) {
	
		movie.setMovie_image(imagepart.getInputStream().readAllBytes());
}
else
{
	Dao d= new Dao();
	Movie m;
	try {
		m = d.findMovie(movieid);
		byte[] imgpart=m.getMovie_image();
		movie.setMovie_image(imgpart);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
		
		
		Dao d= new Dao();
		try {
			d.EditMovie(movie);
			req.setAttribute("movies", d.getAllmovies());
			RequestDispatcher rd=req.getRequestDispatcher("Admin_Home.jsp");
			rd.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
	
}
