package bit.clots.ywk.controller.brand;


import bit.clots.ywk.pojo.Brand;
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
@WebServlet("/updateBrandServlet")
public class UpdateBrandServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	/**
	 * 修改数据的方法
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//解析请求的数据: 要修改的id值
		Integer id = Integer.valueOf(request.getParameter("id"));
		String brandName = request.getParameter("brandName");
		String companyName = request.getParameter("companyName");
		Integer ordered = Integer.valueOf(request.getParameter("ordered"));
		String description = request.getParameter("description");
		Integer status = Integer.valueOf(request.getParameter("status"));

		Brand brand = new Brand(id, brandName, companyName, ordered, description, status);

		//更新数据库信息
		BrandService.updateBrand(brand);

		//更新成功返回全部信息页面
		response.sendRedirect(request.getContextPath() + "/BrandListServlet");


	}
}
