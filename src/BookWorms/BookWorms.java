package BookWorms;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Alex on 5/6/2016.
 */
public class BookWorms {
    private final static String SERVICE_URL = "http://tomcat2-savannaholson.rhcloud.com/webService%5Fwar/webService/";

    public String getBooksByAuthorName(String firstName, String lastName) throws IOException, SAXException {
        URL bookWormsUrl = null;
        try {

            bookWormsUrl = new URL(SERVICE_URL + firstName + "/" + lastName);
        } catch (MalformedURLException ex) {

            return "";
        }

        InputStream in = null;
        BufferedReader reader = null;

        String json = "";
        try {
            in = bookWormsUrl.openStream();
            reader = new BufferedReader(new InputStreamReader(in));

            String line = null;

            while ((line = reader.readLine()) != null) {

                json += line;

            }

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return json;
    }

    public static void main(String[] args) throws Exception{
        BookWorms x = new BookWorms();
        String json = x.getBooksByAuthorName("Sarah", "Maas");
        System.out.println(json);
    }

}
