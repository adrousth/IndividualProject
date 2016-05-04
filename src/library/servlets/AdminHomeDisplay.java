package library.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Student on 3/26/2016.
 * Servlet for displaying admin home page
 */
@WebServlet(
        name = "admin",
        urlPatterns = { "/admin/home" }
)
public class AdminHomeDisplay extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String url = "/admin/admin.jsp";
        String content = "/admin/adminHomePage.jsp";

        request.setAttribute("pageTitle", "Admin Home");
        request.setAttribute("PageContent", content);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}
