package bit.clots.ywk.controller.user;

import bit.clots.ywk.pojo.User;
import bit.clots.ywk.servic.UserServic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户注册认证服务,
 * 通过, 跳转到 /BrandListServlet
 * 不通过, 跳转到 /web/login.jsp
 *
 * @author admin
 */
@WebServlet(value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解析请求数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");


		//验证码校验, 从 session 域里面拿数据
		String checkCode = request.getParameter("checkCode");
		String checkCodeImg = (String) request.getSession().getAttribute("checkCodeImg");
		if ( !(checkCodeImg.equalsIgnoreCase(checkCode)) ) {
			//验证失败, 提示错误
			response.getWriter().println("<script>" + "alert('验证码错误, 请重试')" + "history.back();" + "</script>");
			//结束程序
			return;
		}


		//与数据比对用户名
		User checkUser = UserServic.findUserByName(username);

		if ( checkUser == null ) {
			//注册成功, 把用户名传给其它页面
			UserServic.addUser(username, password);

			request.setAttribute("username", username);

			//重定向到商品详情页面
			response.sendRedirect(request.getContextPath() + "/BrandListServlet");

		} else {
			//注册失败, 重定向到注册页面
			response.getWriter().println("<script> alert('用户已存在,请重试') </script>");
			response.sendRedirect("/web/login.jsp");
		}
	}
}
