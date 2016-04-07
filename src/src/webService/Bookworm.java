package src.webService;


import library.entities.Author;
import library.entities.Book;
import library.persistence.BookDAO;
import src.entities.AuthorType;
import src.entities.BookType;
import src.entities.GoodreadsResponseType;
import org.xml.sax.SAXException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by savannaholson on 3/8/16.
 */
// The Java class will be hosted at the URI path "/webservice"
@Path("/webService")
public class Bookworm {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    @Path("/{authorFirst}/{authorLast}")
    public GoodreadsResponseType getRecomendationWithTitleAndAuthor(
            @PathParam("authorFirst") String authorFirst,
            @PathParam("authorLast") String authorLast
            ) {

        GoodreadsAPI apiRequest = new GoodreadsAPI();
        String xml = "";



        try {
            xml = apiRequest.getBooksByAuthorName(authorFirst + "%20" + authorLast);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        //Nancy's Code
        GoodreadsResponseType books = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(GoodreadsResponseType.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringBuffer xmlStr = new StringBuffer(xml);
            books = (GoodreadsResponseType) unmarshaller.unmarshal(new StreamSource(new StringReader(xmlStr.toString()) ) );

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return books;
        //Savannah's Code
/*
        ObjectMapper mapper = new ObjectMapper();
        String json = "";


        try {
            json = mapper.writeValueAsString(books);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
        */
    }

    public static void main(String[] args) {
        Bookworm x = new Bookworm();
        GoodreadsResponseType books = x.getRecomendationWithTitleAndAuthor("john", "flanagan");
        ArrayList<BookType> books1 = (ArrayList<BookType>) books.getAuthor().getBooks().getBook();
        for (BookType book : books1) {
            Book newBook = new Book();
            if (book.getIsbn().length() != 0 && book.getIsbn() != null) {
                newBook.setIsbn(book.getIsbn());
                newBook.setTitle(book.getTitle());
                newBook.setPublisher(book.getPublisher());
                newBook.setPublishYear(book.getPublicationYear());
                newBook.setEdition(book.getEditionInformation());
                newBook.setNumberPages(book.getNumPages());
                newBook.setFormat(book.getFormat());
                newBook.setDescription(book.getDescription());

                AuthorType author = book.getAuthors().getAuthor();
                Author newAuthor = new Author();
                newAuthor.setName(author.getName());
                newAuthor.setAuthorId(author.getId());

                newBook.addAuthor(newAuthor);

                BookDAO dao = new BookDAO();
                dao.addBook(newBook);
            }



            /*
            System.out.println("isbn: " + book.getIsbn());
            System.out.println("title: " + book.getTitle());
            System.out.println("publisher: " + book.getPublisher());
            System.out.println("publish year: " + book.getPublicationYear());
            System.out.println("edition info: " + book.getEditionInformation());
            System.out.println("number pages: " + book.getNumPages());
            System.out.println("format: " + book.getFormat());
            try {
                System.out.println("description: " + book.getDescription().substring(1, 100));
            } catch (StringIndexOutOfBoundsException ex) {
                System.out.println("description: none");
            }
            */

        }
    }

}
