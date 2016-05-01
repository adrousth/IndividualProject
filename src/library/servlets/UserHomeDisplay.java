package library.servlets;

import library.entities.Rental;
import library.entities.SimpleRental;
import library.entities.SimpleUser;
import library.entities.User;
import library.persistence.RentalDAO;
import library.persistence.UserDAO;

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

        ServletContext context = getServletContext();
        if (context.getAttribute("user") == null) {
            UserDAO dao = (UserDAO) context.getAttribute("userDAO");
            SimpleUser user = dao.getSimpleUserById(Integer.parseInt(request.getRemoteUser()));
            System.out.println(request.getRemoteUser());
            context.setAttribute("user", user);
        }

        RentalDAO rentalDAO = (RentalDAO) context.getAttribute("rentalDAO");
        List<SimpleRental> rentals = rentalDAO.getUserRentals(request.getRemoteUser());

        String url = "/user/user.jsp";
        String content = "/user/userHomePage.jsp";
        String header = "/user/userHeader.jsp";

        request.setAttribute("pageTitle", "User Home");
        request.setAttribute("PageContent", content);
        request.setAttribute("pageHeader", header);
        request.setAttribute("rentals", rentals);


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
}
