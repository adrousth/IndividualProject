package library.servlets;

import library.entities.Book;
import library.persistence.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

/**
 * Created by Student on 3/15/2016.
 */
@WebServlet(
    name = "startup",
    urlPatterns = { "/project-startup" },
    loadOnStartup = 1
)
public class Startup extends HttpServlet {
    public void init() throws ServletException {

        /*
        ArrayList<LibraryDAO> libraryDirectory = new ArrayList<>();
        LibraryDAO authorDirectory = new AuthorDAO();
        LibraryDAO bookDirectory = new BookDAO();
        LibraryDAO categoryDirectory = new CategoryDAO();
        LibraryDAO rentalDirectory = new RentalDAO();
        LibraryDAO userDirectory = new UserDAO();
        libraryDirectory.add(authorDirectory);
        libraryDirectory.add(bookDirectory);
        libraryDirectory.add(categoryDirectory);
        libraryDirectory.add(rentalDirectory);
        libraryDirectory.add(userDirectory);
        */
            final Logger log = Logger.getLogger(this.getClass());
        BookDAO bookDAO = new BookDAO();
        ServletContext context = getServletContext();
        String content = "indexContent.jsp";

        context.setAttribute("PageContent", content);

        context.setAttribute("pageHeader", "/sections/header.jsp");
        context.setAttribute("message", "The current home page for my website, most links do not work");
        context.setAttribute("bookDAO", bookDAO);
        context.setAttribute("logger", log);
        context.setAttribute("pageTitle", "Home Page");
    }
}
