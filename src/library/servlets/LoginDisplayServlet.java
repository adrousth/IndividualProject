package library.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Student on 3/26/2016.
 * Servlet for displaying login screen.
 */
@WebServlet(
        name = "check-login",
        urlPatterns = { "/checkLogin" }
)
public class LoginDisplayServlet extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";
        String content = "/login.jsp";

        request.setAttribute("pageTitle", "Login");
        request.setAttribute("PageContent", content);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}