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
@WebServlet("/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解析请求: 添加的商品信息
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        Integer ordered = Integer.valueOf(request.getParameter("ordered"));
        String description = request.getParameter("description");
        Integer status = Integer.valueOf(request.getParameter("status"));
        Brand brand = new Brand(null, brandName, companyName, ordered, description, status);

        //添加商品
        BrandService.addBrand(brand);

        //添加成功返回所有商品列表
        response.sendRedirect(request.getContextPath() + "\\BrandListServlet");


    }
}
