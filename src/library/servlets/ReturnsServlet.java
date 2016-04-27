package library.servlets;

import library.entities.ReturnResults;
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
 * Created by Alex on 4/26/2016.
 */
@WebServlet(
        name = "submit-return",
        urlPatterns = { "/admin/submit-return" }
)
public class ReturnsServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        RentalDAO rentalDAO = (RentalDAO) context.getAttribute("rentalDAO");

        String isbn = request.getParameter("isbn");
        String bookNumber = request.getParameter("bookNumber");

        ReturnResults results = rentalDAO.returnFromForm(isbn, bookNumber);

        String url = "/admin/admin.jsp";
        String content = "/admin/return.jsp";

        request.setAttribute("results", results);
        request.setAttribute("pageTitle", "Checkouts");
        request.setAttribute("PageContent", content);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}
