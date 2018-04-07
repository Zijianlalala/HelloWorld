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
@WebServlet("/WordList.action")
public class WordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("LoginUser");
		WordService service = new WordService();
		String json = null;
		if(user!=null) {
			int userId = user.getId();
			json = service.queryWords(userId);
		} else {
			json = service.queryAllWords();
		}
		//调用业务层方法
		response.getWriter().println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
