package bit.clots.ywk.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 检查用户是否登录，
 * 登录过不做特殊处理
 * 如果没有，则重定向到登录页面
 *
 * @author admin
 */

//todo 修改 filter 模板

//@WebFilter("/*")
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("loginFilterStart");

		HttpServletRequest hRequest = (HttpServletRequest) sRequest;
		HttpServletResponse hResponse = (HttpServletResponse) sResponse;

		//直接放行资源列表
		String[] uris = {"/css", "/js", "/imgs", "/index", "/login", "/register"};

		//解析访问路径
		String uri = hRequest.getRequestURI();

		//部分不需要验证的资源直接放行, 不再判断
		for (String s : uris) {
			if ( uri.contains(s) ) {
				System.out.println("go out");
				filterChain.doFilter(hRequest, hResponse);
				return;
			}
		}

		HttpSession session = hRequest.getSession();
		if ( session.getAttribute("loginUser") == null ) {
			System.out.println("login first");
			hResponse.sendRedirect(hRequest.getContextPath() + "/web/login.jsp");
		} else {
			filterChain.doFilter(hRequest, hResponse);
		}
	}
}
