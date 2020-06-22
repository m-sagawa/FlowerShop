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
import model.GoodsBean;

/**
 * Servlet implementation class GoodsRegistrationServlet
 */
@WebServlet("/goods-registration-servlet")
public class GoodsRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsRegistrationServlet() {
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
		String forward = null;
		String message = null;

		String goodsName = (String)request.getParameter("goodsName");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsImg = (String)request.getParameter("goodsImg");
		String conf = (String)request.getParameter("conf");

		GoodsBean goodsBean = new GoodsBean();
		goodsBean.setGoodsName(goodsName);
		goodsBean.setGoodsPrice(goodsPrice);
		goodsBean.setGoodsImg(goodsImg);

		if(status == null || status.equals("logout") ) {
			forward = "Login.jsp";
		}else if(status.equals("login")) {
			if(conf.equals("y")){
				Dao dao = new Dao();
				int count = dao.registrationGoods(goodsBean);

				if(count == 1) {
					message = "変更が完了しました";
				}else {
					message = "変更に失敗しました";
				}
				request.setAttribute("message", message);
				forward = "AdminHome.jsp";
			}else if(conf.equals("n")) {
				request.setAttribute("goodsBean", goodsBean);
				forward = "GoodsRegistrationDecision.jsp";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
