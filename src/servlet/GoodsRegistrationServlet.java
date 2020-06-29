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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String status = (String) session.getAttribute("status");
		String forward = null;
		String message = null;
		String error = null;

		if (status == null || status.equals("logout")) {
			forward = "Login.jsp";
		} else if (status.equals("login")) {
			try {
				String goodsName = (String) request.getParameter("goodsName");
				int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
				String goodsImg = (String) request.getParameter("goodsImg");
				int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
				String goodsInfo = (String)request.getParameter("goodsInfo");
				String goodsLang = (String)request.getParameter("goodsLang");
				String conf = (String) request.getParameter("conf");

				if (goodsName == "" || goodsImg == "" || goodsInfo == "" || goodsLang == "") {
					throw new Exception("");
				}

				GoodsBean goodsBean = new GoodsBean();
				goodsBean.setGoodsName(goodsName);
				goodsBean.setGoodsPrice(goodsPrice);
				goodsBean.setGoodsImg(goodsImg);
				goodsBean.setGoodsNumber(goodsNumber);
				goodsBean.setGoodsInfo(goodsInfo);
				goodsBean.setGoodsLang(goodsLang);

				if (conf.equals("y")) {
					Dao dao = new Dao();
					int count = dao.registrationGoods(goodsBean);

					if (count == 1) {
						message = "登録が完了しました";
					} else {
						message = "登録に失敗しました";
					}
					session.setAttribute("message", message);
					forward = "sort-serch-servlet";
					request.setAttribute("forward", "AdminHome.jsp");
				} else if (conf.equals("n")) {
					request.setAttribute("goodsBean", goodsBean);
					forward = "GoodsRegistrationDecision.jsp";
				}
			} catch (Exception e) {
				error = "エラーが起こりました。もう一度やり直してください。";
				forward = "GoodsRegistration.jsp";
			}
		}

		request.setAttribute("message", message);
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
