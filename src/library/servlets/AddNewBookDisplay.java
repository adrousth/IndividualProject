package library.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Created by Student on 3/15/2016.
 */
@WebServlet(
        name = "add-new-book",
        urlPatterns = { "/admin/addNewBook" }
)
public class AddNewBookDisplay extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";
        String content = "/admin/addNewBookForm.jsp";
        String css = "../website.css";

        request.setAttribute("pageTitle", "Add Book");
        request.setAttribute("PageContent", content);
        request.setAttribute("styleSheet", css);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
}
