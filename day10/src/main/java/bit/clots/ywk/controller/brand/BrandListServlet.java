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
 * ��Ʒ�б�չʾ����,
 * ��ȡ���ݿ������е���Ʒ��Ϣ, Ȼ���� /web/brandList.jsp չʾ
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

		//�������ݿ��е���Ʒ����, ��װ��������
		List<Brand> brandList = BrandService.selectAllBrand();
		request.setAttribute("brandList", brandList);
		request.getRequestDispatcher("/web/brandList.jsp").forward(request, response);

	}
}
