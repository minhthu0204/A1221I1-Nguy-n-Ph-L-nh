import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price")) ;
        float percent = Float.parseFloat(request.getParameter("percent"));
        double DiscountAmount = price * percent * 0.01;
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("Description : " + Description + "\n"
                + "Product Price : " + price + "\n"
                + "Discount Percent : " + percent );
        writer.print("DisCount Amount : " + DiscountAmount);
        writer.print("</html>");
    }
}

