package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


import com.sun.jmx.snmp.Timestamp;

import bean.conversation_users;
import bean.searchuserconversation;
import bean.usercompleteinfo;

public class userDao {

	public ResultSet getuserinfo(String username){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user, user_activity where user.username=user_activity.username and user.username ='"+username+"'");
			if(rs!=null){
				return rs;
			}
			else{
				return null;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet get_all_users_info(){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user, user_activity where user.username=user_activity.username");
			if(rs!=null){
				return rs;
			}
			else{
				return null;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getuser_byname(String username,String sessionuser){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user,user_activity where user.username like '"+username+"%' and user.username=user_activity.username and user.username != '"+sessionuser+"'");
			if(rs!=null){
				return rs;
			}
			else{
				return null;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void updateviews(String username) {
		// TODO Auto-generated method stub
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			int rs = st.executeUpdate("update user_activity set views = views+1 where username = '"+username+"'");
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean getlikeinfo(String username1,String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from likes where username1='"+username1+"' and username2 = '"+username2+"' ");
			while(rs.first()){
				return true;
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void like(String username1,String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			int i = st.executeUpdate("update user_activity set likes=likes+1 where username='"+username2+"'");
			i = st.executeUpdate("insert into likes(username1,username2) values('"+username1+"','"+username2+"')");
		
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void dislike(String username1,String username2)
	{
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			int id = getlikeid(username1, username2);
			int i = st.executeUpdate("update user_activity set likes=likes-1 where username='"+username2+"'");
			i = st.executeUpdate("delete from likes where id='"+id+"'");
		
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public int getlikeid(String username1,String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from likes where username1='"+username1+"' and username2 = '"+username2+"' ");
			while(rs.next()){
				int i = rs.getInt("id");
				return i;
			}
			
		
			
		}
		catch (Exception e){
			e.printStackTrace();
		}	
		return 0;
	}
	
	public int getlikescount(String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select likes from user_activity where username='"+username2+"'");
			while(rs.next()){
				int i = rs.getInt("likes");
				return i;
			}		
		}
		catch (Exception e){
			e.printStackTrace();
		}	
		return 0;
	}
	
	
	
	public boolean conversation(String username1,String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from conversation where username1='"+username1+"' and username2 = '"+username2+"'");
			while(rs.first()){
				int id = conversationid(username1, username2);
				java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
				int i = st.executeUpdate("update conversation set time='"+time+"' where id='"+id+"'");
				return true;
			}
			rs = st.executeQuery("select * from conversation where username1='"+username2+"' and username2 = '"+username1+"'");
			while(rs.first()){
				int id = conversationid(username1, username2);
				java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
				int i = st.executeUpdate("update conversation set time='"+time+"' where id='"+id+"'");
				return true;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public List<searchuserconversation> conversationlist(String username1,String username2){
		connectdb db = new connectdb();
		List<searchuserconversation> users = new ArrayList<>();
		try{			
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			
			ResultSet rs =  st.executeQuery("select * from conversation where username1 = '"+username1+"' or username2 = '"+username1+"' order by time desc ");
			while(rs.next()){
				String name1 = rs.getString("username1");
				String name2 = rs.getString("username2");
				if(name1.equals(username1)){
					 String photo = profilephoto_user(name2);
	                   users.add(new searchuserconversation(name2, photo));
	               }
	               else{
	            	   String photo = profilephoto_user(name1);
	                   users.add(new searchuserconversation(name1, photo));
	               }
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}
	
public List<conversation_users> getallconversation(String username1,String  username2){
	connectdb db = new connectdb();
	 ArrayList<conversation_users> conversation = new ArrayList<>();
	try{
		Connection conn = db.getconnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from messages where (username1 = '"+username1+"' and username2 = '"+username2+"') or (username1='"+username2+"' and username2='"+username1+"') order by time");
        while(rs.next()){
            conversation.add(new conversation_users(rs.getString("username1"), rs.getString("username2"), rs.getString("message")));
        }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return conversation;
}

public void sendmessage(String username1,String username2,String message){
	connectdb db = new connectdb();
	try{
		Connection conn = db.getconnection();
		PreparedStatement st = conn.prepareStatement("insert into messages(username1,username2,message,time) values(?,?,?,?)");
		java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
		st.setString(1, username1);
		st.setString(2, username2);
		st.setString(3, message);
		st.setTimestamp(4, time);
		int i = st.executeUpdate();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public String profilephoto_user(String username){
		connectdb db = new connectdb();
		try{			
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery("select * from user where username = '"+username+"'");
			while(rs.next()){
				 String photo = com.sun.xml.wss.impl.misc.Base64.encode(rs.getBytes("profilephoto"));
				 return photo;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}
	
	public void addconversation(String username1,String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			PreparedStatement st = conn.prepareStatement("insert into conversation(username1,username2,time) values(?,?,?)");
			java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
			st.setString(1, username1);
			st.setString(2, username2);
			st.setTimestamp(3, time);
			int i = st.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int conversationid(String username1,String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from conversation where (username1='"+username1+"' and username2 = '"+username2+"') or (username1='"+username2+"' and username2 = '"+username1+"') ");
			while(rs.first()){
				int id = rs.getInt("id");
				return id;
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public void deleteconversation(String username1,String username2){
		connectdb db = new connectdb();
		try{
			Connection conn = db.getconnection();
			Statement st = conn.createStatement();
			int id = conversationid(username1, username2);
			int i = st.executeUpdate("delete from conversation where id='"+id+"'");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
