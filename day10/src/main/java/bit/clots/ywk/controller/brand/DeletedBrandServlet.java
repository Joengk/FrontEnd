package bit.clots.ywk.controller.brand;


import bit.clots.ywk.servic.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * ɾ����Ʒ��Ϣ
 * ɾ���ɹ� ���� /BrandListServlet
 *
 * @author admin
 */
@WebServlet("/DeletedBrandServlet")
public class DeletedBrandServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�������������: Ҫɾ����idֵ
		Integer id = Integer.valueOf(request.getParameter("id"));

		//ɾ�����ݿ���Ϣ
		BrandService.deletedBrand(id);

		//ɾ���ɹ�����ȫ����Ϣҳ��
		response.sendRedirect(request.getContextPath() + "/BrandListServlet");

	}
}
