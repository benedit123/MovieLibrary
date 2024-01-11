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
import dto.Admin;
@WebServlet("/admin_signup")
@SuppressWarnings("serial")
public class adminSignup  extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id =Integer.parseInt(req.getParameter("admin_id"));
	String name=req.getParameter("admin_name");
	long contact=Long.parseLong(req.getParameter("admin_contact"));
	String mail=req.getParameter("admin_mail");
	String pass=req.getParameter("admin_password");
	
	Admin a=new Admin();
	a.setAdminid(id);
	a.setAdminname(name);
	a.setAdmincontact(contact);
	a.setAdminmail(mail);
	a.setAdminpassword(pass);
	Dao da=new Dao();
	try {
		da.saveAdmin(a);
		
		RequestDispatcher rd=req.getRequestDispatcher("admin_login.jsp");
		rd.include(req, resp);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
