/*
package library.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
*/
/**
 * Created by Student on 3/15/2016.
 */
/*
@WebServlet(
        name = "add-new-book",
        urlPatterns = { "/admin/addNewBook" }
)
public class AddNewBookDisplay extends HttpServlet {
*/
    /**
     *  Handles HTTP GET requests.
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
/*
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/admin/admin.jsp";
        String content = "/admin/addNewBookForm.jsp";

        request.setAttribute("pageTitle", "Add Book");
        request.setAttribute("PageContent", content);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
}
*/