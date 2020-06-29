package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao;

/**
 * Servlet implementation class MemberRegistrationServlet
 */
@WebServlet("/member-registration-servlet")
public class MemberRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegistrationServlet() {
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
		//HttpSession session = request.getSession();
		String forward = null;
		String message = null;
		String error = null;
		String conf = (String) request.getParameter("conf");

		try {
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			String u_password = request.getParameter("u_password");

			if (user_id == "" || user_password == "") {
				throw new Exception("");
			}

			if (conf.equals("y")) {
				Dao dao = new Dao();
				int count = dao.registrationMember(user_id, user_password);

				if (count == 1) {
					message = "登録が完了しました";
				} else {
					error = "登録に失敗しました";
				}
				forward = "Login.jsp";
			} else if (conf.equals("n")) {
				if(user_password.equals(u_password)) {
					request.setAttribute("user_id", user_id);
					request.setAttribute("user_password", user_password);
					forward = "MemberRegistrationDecision.jsp";
				}else {
					error = "パスワードが一致しません。もう一度入力してください。";
					forward = "MemberRegistration.jsp";
				}
			}
		}catch(Exception e) {
			error = "エラーが起こりました。もう一度やり直してください。";
			forward = "Login.jsp";
		}

		request.setAttribute("message", message);
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
