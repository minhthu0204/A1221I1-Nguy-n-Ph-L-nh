import Model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/Customer")
public class CustomerServlet extends HttpServlet {

    private  static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Toàn","19-12-2002","Hòa Xuân",""));
        customerList.add(new Customer("Mai Văn Toàn","19-12-2002","Hòa Xuân",""));
        customerList.add(new Customer("Mai Văn Toàn","19-12-2002","Hòa Xuân",""));
        customerList.add(new Customer("Mai Văn Toàn","19-12-2002","Hòa Xuân",""));
        customerList.add(new Customer("Mai Văn Toàn","19-12-2002","Hòa Xuân",""));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("haha.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
