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

import model.CartBean;
import model.Dao;
import model.GoodsBean;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart-servlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		String conf = (String)request.getParameter("conf");
		String forward = null;
		String message = null;
		Dao dao = new Dao();

		if(status == null || status.equals("logout") ) {
			forward = "Login.jsp";
		}else if(status.equals("login")) {
			if(conf == null) {
				String goodsName = (String)request.getParameter("goodsName");
				int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
				String sort = null;
				List<CartBean> cartList = (List<CartBean>)session.getAttribute("cartList");

				List<GoodsBean> goodsList = dao.GoodsList(goodsName, sort);

				CartBean cartBean = new CartBean();
				cartBean.setGoodsBean(goodsList.get(0));
				cartBean.setGoodsNumber(goodsNumber);

				if(cartList == null) {
					cartList = new ArrayList<CartBean>();
				}
				cartList.add(cartBean);

				session.setAttribute("cartList", cartList);
				forward = "Cart.jsp";
			}else if(conf.equals("y")) {
				message = "ご注文を承りました。商品発送までしばらくお待ちください。";
				forward = "test.jsp";
			}else if(conf.equals("n")) {
				forward = "CartDecision.jsp";
			}else if(conf.equals("h")) {
				List<CartBean> cartList = (List<CartBean>)session.getAttribute("cartList");
				/*
				int listSize = cartList.size();
				for(int i = 0; i < listSize; i++) {
					String index = String.valueOf(i);
					String gn = (String)request.getParameter(index);
					int goodsNumber = Integer.parseInt(gn);
					//int goodsNumber = Integer.parseInt(request.getParameter(index));

					CartBean cartBean = cartList.get(i);
					cartBean.setGoodsNumber(goodsNumber);
					cartList.add(i, cartBean);
				}
				*/
				int deleteCart = Integer.parseInt(request.getParameter("deleteCart"));
				cartList.remove(deleteCart);

				session.setAttribute("cartList", cartList);
				forward = "Cart.jsp";
			}
		}

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
