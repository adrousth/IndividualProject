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
 */
@WebServlet(
        name = "login",
        urlPatterns = { "/login" }
)
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        if (request.isUserInRole("administrator")) {
            url = "/admin/home";
        } else if (request.isUserInRole("normalUser")) {
            url = "/user/home";
        } else {
            url = "/failedLogin";
        }



        response.sendRedirect(url);

    }
}