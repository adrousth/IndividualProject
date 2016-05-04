package library.servlets;

import library.entities.Book;
import library.persistence.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 4/16/2016.
 * Servlet for the search bar.
 */
@WebServlet(
        name = "searchBar",
        urlPatterns = { "/searchBar" } // search/#
)
public class SearchBarServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String select = request.getParameter("select");
        String search = request.getParameter("searchParam");
        System.out.println(select);
        System.out.println(search);

        String url = "/search?" + select + "=" + search;
        response.sendRedirect(url);

    }
}
