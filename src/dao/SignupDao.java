package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class SignupDao {

	public boolean checkusername(String username) {
		connectdb db = new connectdb();
		try {

			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			PreparedStatement query = conn.prepareStatement("select * from user where username = ?");
			query.setString(1, username);
			ResultSet rs = query.executeQuery();
			if (rs.next()) {
				conn.close();
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	public boolean adduser(String name, String email, String username, String password, Date dob, String sex,
			String interest, int zipcode, InputStream photo, int theme) {
		connectdb db = new connectdb();
		try {

			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			PreparedStatement query = conn.prepareStatement(
					"insert into user(name,email,username,password,dob,sex,interest,zipcode,profilephoto,theme) values(?,?,?,?,?,?,?,?,?,?)");
			query.setString(1, name);
			query.setString(2, email);
			query.setString(3, username);
			query.setString(4, password);
			query.setDate(5,  dob);
			query.setString(6, sex);
			query.setString(7, interest);
			query.setInt(8, zipcode);
			query.setBinaryStream(9, photo);
			query.setInt(10, theme);
			int i = query.executeUpdate();
			PreparedStatement query2 = conn.prepareStatement(
					"insert into user_activity(username,status,likes,views) values(?,?,?,?)");
			query2.setString(1, username);
			query2.setString(2, null);
			query2.setInt(3, 0);
			query2.setInt(4, 0);
			int j = query2.executeUpdate();
			if(i==1 && j==1){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;

	}

}
