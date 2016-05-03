package library.servlets;

import library.results.CheckoutResults;
import library.persistence.RentalDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alex on 4/23/2016.
 */
@WebServlet(
        name = "checkout",
        urlPatterns = { "/admin/checkout" }
)
public class CheckoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String url = "/admin/admin.jsp";
        String content = "/admin/checkout.jsp";

        request.setAttribute("pageTitle", "Checkouts");
        request.setAttribute("PageContent", content);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        RentalDAO rentalDAO = (RentalDAO) context.getAttribute("rentalDAO");



        String userId = request.getParameter("userId");
        String isbn = request.getParameter("isbn");
        String bookNumber = request.getParameter("bookNumber");
        String days = request.getParameter("days");

        System.out.println(userId);
        System.out.println(isbn);
        System.out.println(bookNumber);
        System.out.println(days);

        CheckoutResults results = rentalDAO.checkoutFromForm(userId, isbn, bookNumber, days);





        request.setAttribute("results", results);

        doGet(request, response);

    }
}
