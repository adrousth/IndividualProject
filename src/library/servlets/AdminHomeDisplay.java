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
        name = "admin",
        urlPatterns = { "/admin/home" }
)
public class AdminHomeDisplay extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String url = "/admin/admin.jsp";
        String content = "/admin/adminHomePage.jsp";
        String css = "../website.css";

        request.setAttribute("pageTitle", "User Home");
        request.setAttribute("PageContent", content);
        request.setAttribute("styleSheet", css);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}
