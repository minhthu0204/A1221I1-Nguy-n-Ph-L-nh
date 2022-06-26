package controller;

import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "edit":
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                showProductList(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("productList", productService.findAll()); //đẩy data vào jsp
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
