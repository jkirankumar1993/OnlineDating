package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import bean.searchuserconversation;
import dao.userDao;

/**
 * Servlet implementation class conversation
 */
@WebServlet("/conversation")
public class conversation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public conversation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String username1 = (String)s.getAttribute("usersession");
		String username2 = request.getParameter("username");
		userDao userdao = new userDao();
		boolean hasconversation = userdao.conversation(username1, username2);
		if(hasconversation==false){
			userdao.addconversation(username1, username2);
		}
		List<searchuserconversation> conversation_users = userdao.conversationlist(username1, username2);
		s.setAttribute("conversationlist", conversation_users);
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
        
		// request.getRequestDispatcher("messages.jsp").forward(request, response);
		myObj.addProperty("success", true);
        out.print(myObj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
