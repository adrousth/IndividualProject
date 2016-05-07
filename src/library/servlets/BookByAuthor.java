package library.servlets;

import BookWorms.BookWorms;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alex on 5/6/2016.
 */
@WebServlet(
        name = "books-by-author",
        urlPatterns = { "/booksByAuthor" }
)
public class BookByAuthor  extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String url = "/index.jsp";
        String content = "/authorBooks.jsp";
        BookWorms api = new BookWorms();
        String json = "";
        try {
            json = api.getBooksByAuthorName(firstName, lastName);
        } catch (SAXException e) {
            e.printStackTrace();
        }


        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            jsonObject = (JSONObject) parser.parse(json);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.setAttribute("json", jsonObject);
        request.setAttribute("pageTitle", "Login");
        request.setAttribute("PageContent", content);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}