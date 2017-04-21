package controller;

import java.io.IOException;
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

import bean.usercompleteinfo;
import dao.userDao;

/**
 * Servlet implementation class viewprofile
 */
@WebServlet("/viewprofile")
public class viewprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchusername = request.getParameter("username");
		userDao userdao = new userDao();
		userdao.updateviews(searchusername);
		ResultSet rs = userdao.getuserinfo(searchusername);
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
				li.add(new usercompleteinfo(user_name,name, dob, sex, interest, status, likes, views, photoimage,zipcode,theme));
			}
			HttpSession s = request.getSession();
			s.setAttribute("searchuserprofile", li);
		    request.setAttribute("searchuserprofile", li);
		    request.getRequestDispatcher("display_search_user.jsp").forward(request, response);
		}
		catch (Exception e) {
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
