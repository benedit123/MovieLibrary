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
import dto.User;
@WebServlet("/signIn")
public class UserLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userEmail=req.getParameter("userEmail");
		String userPass=req.getParameter("userPass");
		Dao dao= new Dao();
		try {
			User user=dao.findByUserEmail(userEmail);
			HttpSession session=req.getSession();
			session.setAttribute("username", user.getUserName());
			
//			
//			System.out.println(admin);
			if (user!=null&&user.getUserPass()!=null) {
				
				System.out.println(user);
				if (user.getUserPass().equals(userPass)) {
					req.setAttribute("movies", dao.getAllmovies());
					RequestDispatcher rd=req.getRequestDispatcher("userHome.jsp");
					rd.include(req, resp);
				}
				else {
					req.setAttribute("message", "password is wrong");
					RequestDispatcher rd=req.getRequestDispatcher("userSignin.jsp");
					rd.include(req, resp);
				}
			}
			else {
				req.setAttribute("message", "email is wrong");
				RequestDispatcher rd=req.getRequestDispatcher("userSignin.jsp");
				rd.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
}
