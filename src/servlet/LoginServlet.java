package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		String userPASS = request.getParameter("userPASS");
		String message = null;
		String url = null;
		String forward = null;
		String status = "logout";

		Dao dao = new Dao();
		String loginType = dao.Login(userID, userPASS);
		if(loginType.equals("admin")) {
			url = "sort-serch-servlet";
			forward = "AdminHome.jsp";
			status = "login";
		}else if (loginType.equals("customer")) {
			url = "sort-serch-servlet";
			forward = "CustomerHome.jsp";
			status = "login";
		}else {
			message = "ログインできません";
			url = "Login.jsp";
		}

		session.setAttribute("status", status);
		session.setAttribute("userID", userID);
		request.setAttribute("forward", forward);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
