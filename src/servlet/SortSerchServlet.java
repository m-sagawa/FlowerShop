package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao;
import model.GoodsBean;

/**
 * Servlet implementation class SortSerchServlet
 */
@WebServlet("/sort-serch-servlet")
public class SortSerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortSerchServlet() {
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
		String status = (String)session.getAttribute("status");
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
		String forward = null;

		if(status == null || status.equals("logout") ) {
			forward = "Login.jsp";
		}else if(status.equals("login")) {
			String sarch = request.getParameter("sarch");
			String sort = request.getParameter("sort");

			Dao dao = new Dao();
			goodsList = dao.GoodsList(sarch, sort);

			String f1 = (String)request.getParameter("forward");
			String f2 = (String)request.getAttribute("forward");
			if(f1 == null) {
				forward = f2;
			}else if(f2 == null) {
				forward = f1;
			}
		}

		request.setAttribute("goodsList", goodsList);
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
