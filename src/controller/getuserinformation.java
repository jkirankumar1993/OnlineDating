package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.prism.Image;

import bean.usercompleteinfo;
import dao.userDao;

/**
 * Servlet implementation class getuserinformation
 */
@WebServlet("/getuserinformation")
public class getuserinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getuserinformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		userDao userdao = new userDao();
		ResultSet rs = userdao.getuserinfo(username);
		List<usercompleteinfo> li = new ArrayList<>();
		try {
			while(rs.next()){ 
				String user_name = rs.getString("username");
				String name = rs.getString("name");
				Date dob = rs.getDate("dob");
				String sex = rs.getString("sex");
				String interest = rs.getString("interest");
				int likes = rs.getInt("likes");
				int views = rs.getInt("views");
				String status = rs.getString("status");
				int zipcode = rs.getInt("zipcode");
				int theme = rs.getInt("theme");
				if(status==null){
					status = "";
				}
				
				String photoimage = com.sun.xml.wss.impl.misc.Base64.encode(rs.getBytes("profilephoto"));
				HttpSession s = request.getSession();
				s.setAttribute("profilephoto",photoimage);
				li.add(new usercompleteinfo(user_name,name, dob, sex, interest, status, likes, views, photoimage,zipcode,theme));
			}
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");

	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "POST");
	        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	        response.setHeader("Access-Control-Max-Age", "86400");
	        Gson gson = new Gson(); 
	        JsonObject myObj = new JsonObject();
	       
	        for(int i=0;i<li.size();i++){
	        	
	        	JsonElement obj = gson.toJsonTree(li.get(i));
	        	myObj.add(""+(i+1), obj);
	        	
	        }
	        myObj.addProperty("success", true);
	        out.print(myObj.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
