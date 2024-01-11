package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Admin;
import dto.Movie;





public class Dao {

	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movielibrary","root","98$t7@bene#1");
		
	}
//	Admin as=new Admin();
	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		
        Connection conn = getconnection();
		
		PreparedStatement pst = conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		pst.setInt(1, admin.getAdminid());
		pst.setString(2, admin.getAdminname());
		pst.setLong(3, admin.getAdmincontact());
		pst.setString(4, admin.getAdminmail());
		pst.setString(5, admin.getAdminpassword());
		return pst.executeUpdate();
	}
	
	public Admin findByEmail(String admin_mailid) throws ClassNotFoundException, SQLException {
         Connection conn = getconnection();
		
		PreparedStatement pst = conn.prepareStatement("select*from admin where adminmail=?");
		pst.setString(1, admin_mailid);
		ResultSet rs=pst.executeQuery();
		Admin a= new Admin();
		if (rs.next()) {
			a.setAdminid(rs.getInt(1));
			a.setAdminname(rs.getString(2));
			a.setAdmincontact(rs.getLong(3));
			a.setAdminmail(rs.getString(4));
			a.setAdminpassword(rs.getString(5));
		}

		return a;
		
	}
	
public int saveMovie(Movie movie) throws ClassNotFoundException, SQLException {
	
	Connection conn= getconnection();
	PreparedStatement pst = conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
	pst.setInt(1, movie.getMovie_id());
	pst.setString(2, movie.getMovie_name());
	pst.setDouble(3, movie.getMovie_price());
	pst.setDouble(4, movie.getMovie_rating());
	pst.setString(5, movie.getMovie_genre());
	pst.setString(6, movie.getMovie_language());
	Blob imageblob=new SerialBlob(movie.getMovie_image());
	pst.setBlob(7, imageblob);
	return pst.executeUpdate();
		
	}


public List<Movie> getAllmovies() throws ClassNotFoundException, SQLException
{
	
	Connection conn= getconnection();
	PreparedStatement pst =conn.prepareStatement("select * from movie");
	
	ResultSet rs= pst.executeQuery();
	List<Movie> movie1=new  ArrayList<Movie>();
	while (rs.next()) {
		Movie m= new Movie();
		m.setMovie_id(rs.getInt(1));
		m.setMovie_name(rs.getString(2));
		m.setMovie_price(rs.getDouble(3));
		m.setMovie_rating(rs.getDouble(4));
		m.setMovie_genre(rs.getString(5));
		m.setMovie_language(rs.getNString(6));
		Blob b=rs.getBlob(7);
		byte[] img =b.getBytes(1, (int)b.length());
		m.setMovie_image(img);
		movie1.add(m);
	}
	return movie1;
	
}

public int deleteMovie(int id) throws ClassNotFoundException, SQLException {
	Connection conn = getconnection();
	PreparedStatement pst =conn.prepareStatement("delete from movie where movie_id=?");
	pst.setInt(1, id);
	return pst.executeUpdate();
	
}
public int EditMovie(Movie movie) throws ClassNotFoundException, SQLException
{
	Connection conn= getconnection();
	PreparedStatement pst = conn.prepareStatement("update movie set movie_name=?,movie_price=?,movie_rating=?,movie_genre=?,movie_language=?,movie_image=? where movie_id=?");
	pst.setString(1, movie.getMovie_name());
	pst.setDouble(2, movie.getMovie_price());
	pst.setDouble(3, movie.getMovie_rating());
	pst.setString(4, movie.getMovie_genre());
	pst.setString(5, movie.getMovie_language());
	Blob imageBlob=new SerialBlob(movie.getMovie_image());
	pst.setBlob(6, imageBlob);
	pst.setInt(7, movie.getMovie_id());
	
	return pst.executeUpdate();
	
}


public Movie findMovie(int movieid) throws ClassNotFoundException, SQLException
{
	
	Connection conn=getconnection();
	PreparedStatement pst=conn.prepareStatement("select * from movie where movie_id=?");
	pst.setInt(1, movieid);
	ResultSet rs=pst.executeQuery(); 
	Movie m= new Movie();
	if(rs.next()) {
		m.setMovie_id(rs.getInt(1));
		m.setMovie_name(rs.getString(2));
		m.setMovie_price(rs.getDouble(3));
		m.setMovie_rating(rs.getDouble(4));
		m.setMovie_genre(rs.getString(5));
		m.setMovie_language(rs.getNString(6));
		Blob b=rs.getBlob(7);
		byte[] img =b.getBytes(1, (int)b.length());
		m.setMovie_image(img);
	}
	
	
	return m;
	
}


















}
