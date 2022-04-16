package bit.clots.ywk.controller.user;

import bit.clots.ywk.pojo.User;
import bit.clots.ywk.servic.UserServic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//todo servlet 修改模板

/**
 * 用户登录验证
 * 验证成功 跳转 /BrandListServlet
 * 验证失败 提示错误信息
 *
 * @author admin
 */
@WebServlet(value = "/loginServlet", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解析请求数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//验证用户
		User loginUser = UserServic.findByUsernameAndPassword(username, password);

		if ( loginUser != null ) {

			//为用户添加 cookie
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60 * 60 * 12 * 7);
			response.addCookie(cookie);

			// 传递用户数据
			request.getSession().setAttribute("username", username);

			//重定向到 商品详情页面
			response.sendRedirect(request.getContextPath() + "/BrandListServlet");

		} else {

			response.getWriter().println("<h1>账号或密码有误<h1/>");
		}


	}
}
