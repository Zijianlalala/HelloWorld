package cn.anwuli.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.anwuli.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//调用业务层方法
		UserService service = new UserService();
		if(service.queryUser(username, password)!=null) {
			//登录成功
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		} else {
			//登录失败 用户名或密码输入错误
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
