/*
package library.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
*/
/**
 * Created by Alex on 4/25/2016.
 */
/*
@WebServlet(
        name = "checkout",
        urlPatterns = { "/admin/checkout" }
)
public class CheckoutDisplay extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String url = "/admin/admin.jsp";
        String content = "/admin/checkout.jsp";

        request.setAttribute("pageTitle", "Checkouts");
        request.setAttribute("PageContent", content);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}
*/