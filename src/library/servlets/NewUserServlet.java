package library.servlets;

import library.entities.AddUserResults;
import library.persistence.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alex on 4/22/2016.
 */
@WebServlet(
        name = "add-new-user",
        urlPatterns = { "/admin/addUser" }
)
public class NewUserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        UserDAO userDAO = (UserDAO) context.getAttribute("userDAO");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String addressOne = request.getParameter("addressOne");
        String addressTwo = request.getParameter("addressTwo");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        AddUserResults results = userDAO.newUserFromForm(firstName, lastName, birthday, email, phone, addressOne, addressTwo, city, state, zip);

        for (String message : results.getMessages()) {
            System.out.println(message);
        }

        String url = "/admin/admin.jsp";
        String content = "/admin/newUserForm.jsp";

        request.setAttribute("results", results);

        request.setAttribute("pageTitle", "New User");
        request.setAttribute("PageContent", content);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}
