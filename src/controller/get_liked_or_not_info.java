package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.userDao;

/**
 * Servlet implementation class get_liked_or_not_info
 */
@WebServlet("/get_liked_or_not_info")
public class get_liked_or_not_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public get_liked_or_not_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao userdao = new userDao();
		HttpSession s = request.getSession();
		String username1 = (String)s.getAttribute("usersession");
		String username2 = request.getParameter("username");
		boolean hasliked = userdao.getlikeinfo(username1, username2);
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
        if(hasliked==true){
        	myObj.addProperty("success", true);
        }
        else{
        	myObj.addProperty("success", false);
        }
        
        out.print(myObj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao userdao = new userDao();
		HttpSession s = request.getSession();
		String username1 = (String)s.getAttribute("usersession");
		String username2 = request.getParameter("username");
		boolean hasliked = userdao.getlikeinfo(username1, username2);
		if(hasliked==false){
			userdao.like(username1, username2);
		}
		else{
			userdao.dislike(username1, username2);
		}
		hasliked = userdao.getlikeinfo(username1, username2);
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
        int likes_count = userdao.getlikescount(username2);
        if(hasliked==true){
        	myObj.addProperty("success", true);
        	myObj.addProperty("likes", likes_count);
        }
        else{
        	myObj.addProperty("success", false);
        	myObj.addProperty("likes", likes_count);
        }
        
        out.print(myObj.toString());
		
	}

}
