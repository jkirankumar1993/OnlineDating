package controller;

import java.io.IOException;
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

import dao.LoginDao;
import dao.userDao;




public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDao logindao = new LoginDao(); 

		Boolean validuser = logindao.verify_username_password(username, password);
		if(validuser==true){
			int theme = logindao.gettheme(username);
			userDao  userdao = new userDao();
			ResultSet rs = userdao.getuserinfo(username);
			HttpSession session = request.getSession();
			try {
				while(rs.next()){
					String photoimage = com.sun.xml.wss.impl.misc.Base64.encode(rs.getBytes("profilephoto"));
					session.setAttribute("profilephoto",photoimage);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("usersession",username);
			session.setAttribute("theme", theme);
			request.getRequestDispatcher("userhome.jsp").forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("loginerror", "username or password is invaild. Please try again. ");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
