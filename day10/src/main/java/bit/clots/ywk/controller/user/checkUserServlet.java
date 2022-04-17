package bit.clots.ywk.controller.user;

import bit.clots.ywk.pojo.User;
import bit.clots.ywk.servic.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUserServlet")
public class checkUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		User checkUser = UserService.findUserByName(username);
		if ( checkUser != null ) {
			response.getWriter().print("true");
		} else {
			response.getWriter().print("false");
		}
	}
}
