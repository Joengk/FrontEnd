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
@WebServlet("/SelectByIDServlet")
public class SelectByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Brand brand = BrandService.selectById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("brand", brand);
        //将查询的对象给 页面渲染
        request.getRequestDispatcher(request.getContextPath() + "/web/updateBrand.jsp").forward(request, response);
    }
}
