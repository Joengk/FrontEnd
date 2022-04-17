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
 * 生成验证码, 并把生成的验证码保存到 session 域, 图片输出到响应流
 *
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
		//生成验证码, 把生成的验证码传到前端

		ServletOutputStream sop = response.getOutputStream();

		String checkCodeImg = CheckCodeUtil.outputVerifyImage(100, 50, sop, 1);
		//存到 seesion 域, 不然第二次请求无法访问
		request.getSession().setAttribute("checkCodeImg", checkCodeImg);

		System.out.println(checkCodeImg);


	}
}
