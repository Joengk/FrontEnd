package bit.clots.ywk.controller.user;

import bit.clots.ywk.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 */
@WebServlet("/verifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������֤��, �����ɵ���֤�봫��ǰ��

		ServletOutputStream sop = response.getOutputStream();

		String checkCodeImg = CheckCodeUtil.outputVerifyImage(100, 50, sop, 1);
		//�浽 seesion ��, ��Ȼ�ڶ��������޷�����
		request.getSession().setAttribute("checkCodeImg", checkCodeImg);

//        System.out.println(checkCode);


	}
}
