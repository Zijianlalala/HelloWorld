package cn.anwuli.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.anwuli.bean.User;
import cn.anwuli.service.UserService;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/Info.action")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数type判断是跳转到哪个页面
		String type = request.getParameter("type");
//		//将当前用户信息显示到jsp页面中
//		HttpSession session = request.getSession();
//		String username = ((User) session.getAttribute("loginUser")).getUsername();
//		System.out.println(username);
//		//调用业务层方法
//		UserService service = new UserService();
//		User user = service.queryUserByName(username);
//		//将user对象添加到request属性中
//		request.setAttribute("LoginUser", user);
//		System.out.println(user);
		if(Integer.parseInt(type) == 1) {
			request.getRequestDispatcher("/WEB-INF/jsp/info.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/updateInfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
