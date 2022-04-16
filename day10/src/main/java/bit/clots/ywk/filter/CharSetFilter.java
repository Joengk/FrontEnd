package bit.clots.ywk.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author admin
 */
@WebFilter("/*")
public class CharSetFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String uri = ((HttpServletRequest) request).getRequestURL().toString();
		System.out.println("charsetFilterStart");

		if ( uri.contains(".css") || uri.contains(".js") || uri.contains(".png") || uri.contains(".jpg") ) {
			//response.setContentType("text/css;charset=utf-8");

		} else {
			//������Ӧ����
			response.setContentType("text/html;charset=utf-8");
		}


		// todo �����Ƿ������, ���� css �Ƿ�ɹ�����
//        //���� html
//        if(uri.contains(".html"))
//        {
//
//            response.setContentType("text/html;charset=utf-8");
//            System.out.println("yes");
//        }
//        else
//        {
//            //������Ӧ����
//            response.setContentType("text/html;charset=utf-8");
//        }

		// �������, ����
		filterChain.doFilter(request, response);
	}

}
