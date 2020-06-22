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
 * Servlet implementation class GoodsUpdateServlet
 */
@WebServlet("/goods-update-servlet")
public class GoodsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpdateServlet() {
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
		String conf = request.getParameter("conf");
		String message = null;
		Dao dao = new Dao();
		GoodsBean goodsBean = new GoodsBean();

		if(status == null || status.equals("logout") ) {
			forward = "Login.jsp";
		}else if(status.equals("login")) {
			if(conf == null) {
				String sarch = request.getParameter("goodsName");
				session.removeAttribute("updateName");
				session.setAttribute("updateName", sarch);
				String sort = null;

				goodsList = dao.GoodsList(sarch, sort);
				goodsBean = goodsList.get(0);
				request.setAttribute("goodsBean", goodsBean);
				forward = "GoodsUpdate.jsp";
			}else {
				if(conf.equals("y")){
					String goodsName = (String)request.getParameter("goodsName");
					int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
					String goodsImg = (String)request.getParameter("goodsImg");

					goodsBean.setGoodsName(goodsName);
					goodsBean.setGoodsPrice(goodsPrice);
					goodsBean.setGoodsImg(goodsImg);

					String updateName = (String)session.getAttribute("updateName");
					session.removeAttribute("updateName");
					int count = dao.updateGoods(goodsBean, updateName);

					if(count == 1) {
						message = "登録が完了しました";
					}else {
						message = "登録に失敗しました";
					}

					request.setAttribute("message", message);
					forward ="test.jsp";
				}else if(conf.equals("n")) {
					String goodsName = (String)request.getParameter("goodsName");
					int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
					String goodsImg = (String)request.getParameter("goodsImg");

					goodsBean.setGoodsName(goodsName);
					goodsBean.setGoodsPrice(goodsPrice);
					goodsBean.setGoodsImg(goodsImg);

					request.setAttribute("goodsBean", goodsBean);
					forward = "GoodsUpdateDecision.jsp";
				}
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
