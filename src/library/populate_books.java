package library;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.WebServiceException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Student on 3/30/2016.
 */
public class populate_books {

    private final static String SERVICE_URL = "https://www.goodreads.com/";
    private final static String API_KEY = "?key=FCu2HvScdASGklfD1GmDBg";
    private final static String AUTHOR_INFO_URL = "api/author_url/";
    private final static String AUTHOR_BOOK_URL = "author/list/";

    // takes author info xml and gets their id
    private String getAuthorId(String xml) throws IOException, SAXException{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        String authorId = "";
        try
        {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            authorId = document.getElementsByTagName("author").item(0).getAttributes().item(0).getNodeValue();

        } catch (Exception e) {
            System.out.println(e);
        }

        return authorId;
    }

    // gets xml from goodreads api based on param
    private String getXmlFromGoodreads(String param, String type) throws IOException {
        URL goodreadsUrl = null;
        try {
            if (type == "author") {
                goodreadsUrl = new URL(SERVICE_URL + AUTHOR_INFO_URL + param + API_KEY);
            } else if (type == "books") {
                goodreadsUrl = new URL(SERVICE_URL + AUTHOR_BOOK_URL + param + API_KEY);
            } else if (type == "isbn") {

            }
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }

        InputStream in = goodreadsUrl.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        String xml = "";
        while (reader.ready()) {
            line = reader.readLine();
            xml += line;
            System.out.println(line);
        }
        return xml;
    }



    // gets up to 30 books by an author from goodreads, returns as xml
    public String getBooksByAuthorName(String author) throws IOException, SAXException {
        String info = getXmlFromGoodreads(author, "author");
        String id = getAuthorId(info);

        String xml = getXmlFromGoodreads(id, "books");

        return xml;
    }

    public String getBookById(String id) throws IOException {

        String xml = getXmlFromGoodreads(id, "isbn");

        return xml;

    }

    public static void main(String[] args) throws IOException, SAXException {
        populate_books x = new populate_books();
        String xml = x.getBooksByAuthorName("joe%20smith");


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        String isbn = "";
        try
        {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));



        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(isbn);

    }

}