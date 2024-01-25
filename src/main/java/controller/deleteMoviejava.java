package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
@WebServlet("/deleteMovie")
public class deleteMoviejava extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Dao dao = new Dao();
		try {
			HttpSession session=req.getSession();
			String s1=(String) session.getAttribute("adminname");
			if (s1!=null) {
				dao.deleteMovie(id);
				req.setAttribute("movies", dao.getAllmovies());
				RequestDispatcher rd= req.getRequestDispatcher("Admin_Home.jsp");
				rd.include(req, resp);
			}
			else {
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
