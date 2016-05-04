package library.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Created by Student on 3/15/2016.
 * Servlet for displaying login error page.
 */
@WebServlet(
        name = "login-error",
        urlPatterns = { "/failedLogin" }
)
public class LoginErrorDisplay extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        if (request.isUserInRole("ADMIN")) {
            url = "admin/home";
            response.sendRedirect(url);
        } else {
            url = "user/home";
            response.sendRedirect(url);
        }

        String content = "/failedLogin.jsp";

        request.setAttribute("pageTitle", "Login Failed");
        request.setAttribute("PageContent", content);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
    /**
     * Handles HTTP POST requests.
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";
        if (request.isUserInRole("ADMIN")) {
            url = "admin/home";
            response.sendRedirect(url);
        } else if (request.isUserInRole("USER")) {
            url = "user/home";
            response.sendRedirect(url);
        }

        String content = "/failedLogin.jsp";

        request.setAttribute("pageTitle", "Login Failed");
        request.setAttribute("PageContent", content);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
}
