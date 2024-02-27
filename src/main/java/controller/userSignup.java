package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.User;
@WebServlet("/userLogin")
public class userSignup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("userId"));
		String name=req.getParameter("userName");
		String email=req.getParameter("userEmail");
		String pass=req.getParameter("userPass");
		long contact=Long.parseLong(req.getParameter("userPhNo"));
		
		User u= new User();
		u.setUserID(id);
		u.setUserName(name);
		u.setUserEmail(email);
		u.setUserPass(pass);
		u.setPhoneNumber(contact);
		
		Dao dao=new Dao();
		try {
			dao.saveUser(u);
			RequestDispatcher rd= req.getRequestDispatcher("user.jsp");
			rd.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
