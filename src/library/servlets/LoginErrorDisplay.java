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
        name = "login-error",
        urlPatterns = { "/failedLogin" }
)
public class LoginErrorDisplay extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        if (request.isUserInRole("administrator")) {
            url = "admin/home";
            response.sendRedirect(url);
        } else if (request.isUserInRole("normalUser")) {
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
