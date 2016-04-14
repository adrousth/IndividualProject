package library.servlets;

import library.entities.Book;
import library.entities.SearchResults;
import library.persistence.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/10/2016.
 */
@WebServlet(
        name = "search",
        urlPatterns = { "/search" } // search/#
)
public class SearchServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("pageNumber", 0/*#*/);
        String url = "/search/search.jsp";
        String content = "/search/searchResults.jsp";
        ServletContext context = getServletContext();
        BookDAO dao = (BookDAO) context.getAttribute("bookDAO");
        List<Book> results;

        results = dao.getNumberOfBooks(0, 10);

        request.setAttribute("results", results);
        request.setAttribute("pageTitle", "Search Results");
        request.setAttribute("PageContent", content);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);



        /*
        ServletContext context = getServletContext();
        EmployeeDirectory directory = (EmployeeDirectory)context.getAttribute("employeeDirectory");

        String searchType = request.getParameter("typeOfSearch");
        String searchTerm = request.getParameter("searchTerm");

        Search search = directory.searchEmployees(searchType, searchTerm);

        HttpSession session = request.getSession();
        session.setAttribute("EmployeeTableSearchResults", search);

        request.setAttribute("EmployeeTableSearchResults", search);
        String url = "/employeeSearchResults.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
         */
    }
}
