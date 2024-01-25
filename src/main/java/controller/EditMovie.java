package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;

//import dao.Dao;
//import dto.Movie;

@WebServlet("/EditMovie")
public class EditMovie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id=req.getParameter("id");
       Dao d= new Dao();
       
       int id1=Integer.parseInt(req.getParameter("id"));
       try {
    	   HttpSession session=req.getSession();
			String s1=(String) session.getAttribute("adminname");
			if (s1!=null) {
		       req.setAttribute("movie", d.findMovie(id1));
		       req.setAttribute("id", id);
		       RequestDispatcher rd=req.getRequestDispatcher("EditMovie.jsp");
		       rd.include(req, resp);
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
