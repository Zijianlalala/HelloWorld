package cn.anwuli.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.anwuli.bean.User;
import cn.anwuli.bean.Word;
import cn.anwuli.service.WordService;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/Collection.action")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = ((User) session.getAttribute("LoginUser")).getId();
		//调用业务层方法
		WordService service = new WordService();
		List<Word> collection = service.queryCollection(userId);
		request.setAttribute("collection", collection);
		request.getRequestDispatcher("/WEB-INF/jsp/collection.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
