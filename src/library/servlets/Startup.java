package library.servlets;

import library.entities.Book;
import library.entities.Rental;
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

        final Logger log = Logger.getLogger(this.getClass());
        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO = new UserDAO();
        RentalDAO rentalDAO = new RentalDAO();
        ServletContext context = getServletContext();
        String content = "indexContent.jsp";

        context.setAttribute("PageContent", content);

        context.setAttribute("pageHeader", "/sections/header.jsp");
        context.setAttribute("message", "The current home page for my website, most links do not work");
        context.setAttribute("bookDAO", bookDAO);
        context.setAttribute("userDAO", userDAO);
        context.setAttribute("rentalDAO", rentalDAO);
        context.setAttribute("logger", log);
        context.setAttribute("pageTitle", "Home Page");
    }
}
