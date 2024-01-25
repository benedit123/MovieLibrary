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

//import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import dao.Dao;
import dto.Admin;
@WebServlet("/admin_login")
@SuppressWarnings("serial")
public class adminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_mailid=req.getParameter("admin_mail");
		String admin_password=req.getParameter("admin_pass");
		Dao dao= new Dao();
		try {
			Admin admin=dao.findByEmail(admin_mailid);
			HttpSession session=req.getSession();
			session.setAttribute("adminname", admin.getAdminname());
			
			
//			System.out.println(admin);
			if (admin!=null&&admin.getAdminpassword()!=null) {
				
				System.out.println(admin);
				if (admin.getAdminpassword().equals(admin_password)) {
					req.setAttribute("movies", dao.getAllmovies());
					RequestDispatcher rd=req.getRequestDispatcher("Admin_Home.jsp");
					rd.include(req, resp);
				}
				else {
					req.setAttribute("message", "password is wrong");
					RequestDispatcher rd=req.getRequestDispatcher("admin_login.jsp");
					rd.include(req, resp);
				}
			}
			else {
				req.setAttribute("message", "email is wrong");
				RequestDispatcher rd=req.getRequestDispatcher("admin_login.jsp");
				rd.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
