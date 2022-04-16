package bit.clots.ywk.controller.brand;

import bit.clots.ywk.pojo.Brand;
import bit.clots.ywk.servic.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 商品列表展示服务,
 * 读取数据库中所有的商品信息, 然后在 /web/brandList.jsp 展示
 *
 * @author admin
 */
@WebServlet("/BrandListServlet")
public class BrandListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");

		//遍历数据库中的商品数据, 封装到请求中
		List<Brand> brandList = BrandService.selectAllBrand();
		request.setAttribute("brandList", brandList);
		request.getRequestDispatcher("/web/brandList.jsp").forward(request, response);

	}
}
