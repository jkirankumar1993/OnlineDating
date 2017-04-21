package dao;

import java.sql.DriverManager;
import java.util.ResourceBundle;

import java.sql.*;

public class connectdb {

	private String drivername;
	private String url;
	private String username;
	private String password;
	private Connection conn;
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public connectdb() {
		   try{
			ResourceBundle r = ResourceBundle.getBundle("dbParameters");
			drivername = "com.mysql.jdbc.Driver";
			url = r.getString("DB_URL");
			username = r.getString("DB_USER");
			password = r.getString("DB_PASSWORD");
			
					
		   }
		   catch (Exception e) {
			
		}
		   
		  
	}
	
	public Connection getconnection(){
		try{
			Class.forName(drivername);	
		}
		catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
		try{
			conn = (Connection)DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	
	
}
