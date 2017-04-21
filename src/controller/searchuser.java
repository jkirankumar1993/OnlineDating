package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import bean.usercompleteinfo;
import dao.userDao;

/**
 * Servlet implementation class searchuser
 */
@WebServlet("/searchuser")
public class searchuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Search By Name
		String search_username = request.getParameter("username");
		userDao userdao = new userDao();
		HttpSession s = request.getSession();
		String session_username = (String)s.getAttribute("usersession");
		ResultSet rs = userdao.getuser_byname(search_username,session_username);
		List<usercompleteinfo> li = new ArrayList<>();
		try{
			while (rs.next()) {
					
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
					li.add(new usercompleteinfo(user_name,name, dob, sex, interest, status, likes, views, photoimage,zipcode,theme));
			}
			PrintWriter out = response.getWriter();
	        response.setContentType("text/html");
	        response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");

	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "POST");
	        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	        response.setHeader("Access-Control-Max-Age", "86400");
	        Gson gson = new Gson(); 
	        JsonObject myObj = new JsonObject();
	       
	        s.setAttribute("searchuser_by_name_list", li);
	        request.setAttribute("searchuser_by_name_list", li);
	        for(int i=0;i<li.size();i++){
	        	
	        	JsonElement obj = gson.toJsonTree(li.get(i));
	        	myObj.add(""+(i+1), obj);
	        	
	        }
	        myObj.addProperty("success", true);
	        out.print(myObj.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
