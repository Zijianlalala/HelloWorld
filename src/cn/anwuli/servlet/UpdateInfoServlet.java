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
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet("/UpdateInfo.action")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		//获取信息
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String username = ((User) session.getAttribute("LoginUser")).getUsername();
		//调用业务层方法
		UserService service = new UserService();
		User user = service.updateInfo(username, password, nickname);
		if(user!=null) {
			//修改成功，调转到个人中心页面
			session.setAttribute("LoginUser", user);
			request.getRequestDispatcher("/WEB-INF/jsp/info.jsp").forward(request, response);
		} else {
			//修改失败
		}
	}

}
