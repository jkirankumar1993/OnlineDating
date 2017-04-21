package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
 * Servlet implementation class advancedsearch
 */
@WebServlet("/advancedsearch")
public class advancedsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advancedsearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Advanced Search
		
		String search_sex = request.getParameter("user_sex");
		int minage = Integer.parseInt(request.getParameter("minage"));
		int maxage = Integer.parseInt(request.getParameter("maxage"));
		String search_interest = request.getParameter("user_interest");
		int distance =Integer.parseInt(request.getParameter("zipcode"));
		userDao userdao = new userDao();
		ResultSet rs = userdao.get_all_users_info();
		List<usercompleteinfo> li = new ArrayList<>();
		System.out.println(search_sex+" "+minage+" "+maxage+" "+search_interest+" "+distance);
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
		if(!search_sex.equals("Any")){
			li = li.stream().filter(u -> u.getSex().equals(search_sex)).collect(Collectors.toList());
		}
		if(distance!=0){
			li = li.stream().filter(u -> u.getZipcode()>(u.getZipcode()-distance) && u.getZipcode()<(u.getZipcode()+distance)).collect(Collectors.toList());
		}
		if(!search_interest.equals("Any")){
			li = li.stream().filter(u -> u.getInterest().equals(search_interest)).collect(Collectors.toList());
		}
		
		li = li.stream().filter(u -> u.getage()>=minage && u.getage()<=maxage).collect(Collectors.toList());
		
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
	        HttpSession s = request.getSession();
	        s.setAttribute("advancedsearchuser_by_name_list", li);
	        request.setAttribute("advancedsearchuser_by_name_list", li);
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
