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
 */
@WebServlet(
        name = "login",
        urlPatterns = { "/login" }
)
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/failedLogin";;
        String header = "";

        if (request.isUserInRole("ADMIN")) {
            url = "/admin/home";
            header = "/admin/adminHeader.jsp";
        } else if (request.isUserInRole("USER")) {
            url = "/user/home";
            header = "/user/userHeader.jsp";
        } else {
            response.sendRedirect(url);
        }
        ServletContext context = getServletContext();
        context.setAttribute("pageHeader", header);


        response.sendRedirect(url);

    }
}