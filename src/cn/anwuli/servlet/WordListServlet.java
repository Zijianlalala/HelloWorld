package cn.anwuli.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cn.anwuli.bean.User;
import cn.anwuli.bean.Word;
import cn.anwuli.service.WordService;

/**
 * Servlet implementation class WordListServlet
 */
@WebServlet("/WordListServlet")
public class WordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		int userId = ((User) session.getAttribute("LoginUser")).getId();
		//调用业务层方法
		WordService service = new WordService();
		String json = service.queryWords(userId);

		response.getWriter().println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
