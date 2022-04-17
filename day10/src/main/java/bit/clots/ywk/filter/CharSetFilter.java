package bit.clots.ywk.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 只对post请求乱码处理, 由于代码中 get 方法是调用 post 方法的所以只判断 post 方法, 响应由 jsp 处理
 *
 * @author admin
 */
//@WebFilter("/*")
public class CharSetFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("charsetFilterStart");

		//请求过滤
		HttpServletRequest request1 = (HttpServletRequest) request;
		String method = request1.getMethod();
		if ( "POST".equals(method) ) {
			request.setCharacterEncoding("UTF-8");
		}


		// 过滤完毕, 放行
		filterChain.doFilter(request, response);

	}

}
