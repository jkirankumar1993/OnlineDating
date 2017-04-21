package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {

	public boolean verify_username_password(String username,String password){
		connectdb db = new connectdb();
		try{
		
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			PreparedStatement query = conn.prepareStatement("select * from user where username = ? and password = ?");
			query.setString(1, username);
			query.setString(2, password);
			ResultSet rs = query.executeQuery();
			if(rs.next()){
				conn.close();
				return true;
			}
			else{
				return false;
			}
 		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	}
	
	public int gettheme(String username){
		connectdb db = new connectdb();
		try{
		
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			PreparedStatement query = conn.prepareStatement("select * from user where username = ?");
			query.setString(1, username);
			ResultSet rs = query.executeQuery();
			if(rs.next()){
				int theme = rs.getInt("theme");
				return theme;
			}
			else{
				return 0;
			}
 		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}
	
	
	
}
