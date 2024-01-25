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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.Dao;
import dto.Movie;

@WebServlet("/Addmovie")
@MultipartConfig(maxFileSize = 5*1024*2024)
public class addMovie extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int movieid=Integer.parseInt(req.getParameter("movie_id"));
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
		movie.setMovie_image(imagepart.getInputStream().readAllBytes());
			
		Dao dao=new Dao();
		try {
			HttpSession session=req.getSession();
			String s1=(String) session.getAttribute("adminname");
			if (s1!=null) {
			dao.saveMovie(movie);
			req.setAttribute("movies", dao.getAllmovies());
			RequestDispatcher rs=req.getRequestDispatcher("Admin_Home.jsp");
//			System.out.println(dao.saveMovie(movie));
			rs.include(req, resp);
			}
			else 
			{
				req.setAttribute("message", "access denied you must do login");
				RequestDispatcher rd= req.getRequestDispatcher("admin_login.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
