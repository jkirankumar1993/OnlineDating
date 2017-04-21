package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.SignupDao;

/**
 * Servlet implementation class checkusername
 */
@MultipartConfig
public class signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public signupcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String dob = request.getParameter("dob");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(dob);
			Date dateofbirth = new Date(date.getTime()) ;
			System.out.println(date);
			String sex = request.getParameter("sex");
			String interest = request.getParameter("interest");
			String zipcode_string = request.getParameter("zipcode");
			int zipcode = Integer.parseInt(zipcode_string);
			String theme_string = request.getParameter("themes");
			int theme = Integer.parseInt(theme_string);
			Part img = request.getPart("profilephoto");
			InputStream inputstream = img.getInputStream();
			SignupDao db = new SignupDao();
			boolean res = db.adduser(name, email, username, password, dateofbirth, sex, interest, zipcode, inputstream, theme);
			if (res) {
				HttpSession session = request.getSession();
				session.setAttribute("usersession",username);
				session.setAttribute("theme", theme);
				request.getRequestDispatcher("userhome.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
