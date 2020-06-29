package servlet;

import java.io.IOException;
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
 * Servlet implementation class GoodsInfoServlet
 */
@WebServlet("/goods-info-servlet")
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsInfoServlet() {
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
		GoodsBean goodsBean = new GoodsBean();
		Dao dao = new Dao();
		String status = (String)session.getAttribute("status");
		String forward = null;

		if(status == null || status.equals("logout") ) {
			forward = "Login.jsp";
		}else if(status.equals("login")) {
			String sarch = (String) request.getParameter("goodsName");
			String sort = null;

			List<GoodsBean> goodsList = dao.GoodsList(sarch, sort);
			goodsBean = goodsList.get(0);
			request.setAttribute("goodsBean", goodsBean);
			forward = "FlowerInfo.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
