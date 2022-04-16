package bit.clots.ywk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ����û��Ƿ��¼�����û�У����ض��򵽵�¼ҳ��
 *
 * @author admin
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("��¼����������");
		HttpSession session = ((HttpServletRequest) request).getSession();
		if ( session.getAttribute("username") == null ) {
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/web/login.jsp");
		} else {
			filterChain.doFilter(request, response);
		}
		System.out.println("��¼�������������");

	}
}
