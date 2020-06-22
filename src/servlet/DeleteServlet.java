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
@WebServlet("/delete-servlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
			if(conf.equals("y")){
				String[] deleteList = request.getParameterValues("goodsName");
				int count = dao.deleteGoods(deleteList);
				if(count == 0) {
					message = "削除に失敗しました";
				}else {
					message = count + "件削除しました";
				}

				request.setAttribute("message", message);
				forward = "test.jsp";
			}else if(conf.equals("n")) {
				String[] deleteList = request.getParameterValues("goodsName");
				String sort = null;
				List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
				for(String sarch : deleteList) {
					List<GoodsBean> gList = dao.GoodsList(sarch, sort);
					goodsList.add(gList.get(0));
				}

				request.setAttribute("goodsList", goodsList);
				forward = "GoodsDeleteDecision.jsp";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
