package library.servlets;

import library.entities.Book;
import library.persistence.BookDAO;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Created by Student on 3/15/2016.
 */
@WebServlet(
        name = "add-new",
        urlPatterns = { "/admin/addBook" }
)
public class AddNewBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        BookDAO bookDirectory = (BookDAO) context.getAttribute("libraryDirectory");

        HttpSession session = request.getSession();

        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        String year = request.getParameter("year");
        String edition = request.getParameter("edition");
        String copies = request.getParameter("copies");
        System.out.println(isbn);
        System.out.println(title);
        System.out.println(year);

        ArrayList<String> message = (ArrayList<String>) bookDirectory.addBookFromForm(isbn, title, publisher, year, edition, copies);

        System.out.println();
        session.setAttribute("message", message);

        String url = "/admin/addNewBook";
        response.sendRedirect(url);



    }
}
