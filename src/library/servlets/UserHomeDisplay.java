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
        name = "user-home",
        urlPatterns = { "/user/home" }
)
public class UserHomeDisplay extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/user/user.jsp";
        String content = "/user/userHomePage.jsp";
        String css = "../website.css";
        String header = "userHeader.jsp";


        request.setAttribute("pageTitle", "User Home");
        request.setAttribute("PageContent", content);
        request.setAttribute("styleSheet", css);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
}
