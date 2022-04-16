package bit.clots.ywk.controller.brand;


import bit.clots.ywk.servic.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author admin
 */
@WebServlet("/DeletedBrandServlet")
public class DeletedBrandServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	/**
	 * 删除数据的方法
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//解析请求的数据: 要删除的id值
		Integer id = Integer.valueOf(request.getParameter("id"));

		//删除数据库信息
		BrandService.deletedBrand(id);

		//删除成功返回全部信息页面
		response.sendRedirect(request.getContextPath() + "/BrandListServlet");

	}
}
