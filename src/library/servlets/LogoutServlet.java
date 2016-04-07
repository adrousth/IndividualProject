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
        name = "logout",
        urlPatterns = { "/logout" }
)
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message;
        String header = "";
        if(request.getUserPrincipal() != null) {
            request.logout();
            message = "Logged out";
            header = "/sections/header.jsp";
            ServletContext context = getServletContext();
            context.setAttribute("pageHeader", header);
        } else {
            message = "Not logged in";
        }


        request.logout();



        String url = "/index.jsp";

        request.setAttribute("Title", "Log out");
        request.setAttribute("PageContent", "/logout.jsp");
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);


    }
}