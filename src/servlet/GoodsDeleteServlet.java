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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/goods-delete-servlet")
public class GoodsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDeleteServlet() {
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
		String error = null;
		String message = null;
		Dao dao = new Dao();
		String[] dl = request.getParameterValues("goodsName");

		if(status == null || status.equals("logout") ) {
			forward = "Login.jsp";
		}else if(status.equals("login")) {
			if(dl == null) {
				error = "エラーが起こりました。もう一度やり直してください。";
				forward = "sort-serch-servlet";
				request.setAttribute("forward", "GoodsDelete.jsp");
			}else {
				if(conf.equals("y")){
					int count = dao.deleteGoods(dl);
					if(count == 0) {
						message = "削除に失敗しました";
					}else {
						message = count + "件削除しました";
					}

					session.setAttribute("message", message);
					forward = "sort-serch-servlet";
					request.setAttribute("forward", "AdminHome.jsp");
				}else if(conf.equals("n")) {
					String sort = null;
					List<GoodsBean> deleteList = new ArrayList<GoodsBean>();
					for(String sarch : dl) {
						List<GoodsBean> gList = dao.GoodsList(sarch, sort);
						deleteList.add(gList.get(0));
					}

					request.setAttribute("deleteList", deleteList);
					forward = "GoodsDeleteDecision.jsp";
				}
			}
		}

		request.setAttribute("message", message);
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
