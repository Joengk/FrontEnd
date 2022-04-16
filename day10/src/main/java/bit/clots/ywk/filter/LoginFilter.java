package bit.clots.ywk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 检查用户是否登录，如果没有，则重定向到登录页面
 *
 * @author admin
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("登录过滤器处理");
		HttpSession session = ((HttpServletRequest) request).getSession();
		if ( session.getAttribute("username") == null ) {
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/web/login.jsp");
		} else {
			filterChain.doFilter(request, response);
		}
		System.out.println("登录过滤器处理完成");

	}
}
