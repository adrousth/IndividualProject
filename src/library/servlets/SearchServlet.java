package library.servlets;

import library.entities.Book;
import library.results.SearchResults;
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
 * Created by Alex on 4/10/2016.
 */
@WebServlet(
        name = "search",
        urlPatterns = { "/search" } // search/#
)
public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pageNumber = 1;
        int booksPerPage = 10;
        float maxPages = 10;
        String url = "/search/search.jsp";
        String content = "/search/searchResults.jsp";
        String params = "";
        String search = "";
        int numberOfBooks = 0;
        ServletContext context = getServletContext();
        BookDAO dao = (BookDAO) context.getAttribute("bookDAO");
        SearchResults results;

        if (request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }

        if(request.getParameter("isbn") != null) {
            search = request.getParameter("isbn");
            results = dao.searchForNumberOfBooks((pageNumber - 1)*booksPerPage, booksPerPage, "isbn", search);
            params += "&isbn=" + request.getParameter("isbn");
        } else if(request.getParameter("firstName") != null) {
            search = request.getParameter("firstName");
            results = dao.searchForNumberOfBooks((pageNumber - 1)*booksPerPage, booksPerPage, "firstName", search);
            params += "&firstName=" + request.getParameter("firstName");
        } else if (request.getParameter("lastName") != null) {
            search = request.getParameter("lastName");
            results = dao.searchForNumberOfBooks((pageNumber - 1)*booksPerPage, booksPerPage, "lastName", search);
            params += "&lastName=" + request.getParameter("lastName");
        } else if (request.getParameter("title") != null) {
            search = request.getParameter("title");
            results = dao.searchForNumberOfBooks((pageNumber - 1)*booksPerPage, booksPerPage, "title", search);
            params += "&title=" + request.getParameter("title");
        } else {
            results = dao.searchForNumberOfBooks((pageNumber - 1)*booksPerPage, booksPerPage, "", "");
        }



        //List<Book> results = dao.searchForNumberOfBooks((pageNumber - 1)*booksPerPage, booksPerPage, "", "");

        numberOfBooks = results.getCount();

        int numberOfPages = (int) Math.ceil((float)numberOfBooks / booksPerPage);
        if (numberOfPages < maxPages) {
            maxPages = numberOfPages;
        }
        int halfMaxPages = (int) (maxPages / 2);



        List<Book> books = results.getBooks();


        request.setAttribute("halfMaxPages", halfMaxPages);
        request.setAttribute("params", params);
        request.setAttribute("maxPages", maxPages);
        request.setAttribute("results", books);
        request.setAttribute("pageTitle", "Search Results");
        request.setAttribute("PageContent", content);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("numberOfBooks", numberOfBooks);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}
