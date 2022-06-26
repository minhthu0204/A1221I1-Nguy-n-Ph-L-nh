package controller;

import model.Product;
import repository.IProductRepository;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":

                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            case "find":
                break;
            default:
                showProductList(request,response);
                break;
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("products", productService.findAll()); //đẩy data vào jsp
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            case "find":
                break;
            default:
                break;
        }
    }
}
