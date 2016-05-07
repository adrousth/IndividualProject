package library.persistence;

import library.entities.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/23/2016.
 */
public class AuthorDAOTest {
    AuthorDAO dao;
    Author testAuthor;
    Author testAuthor1;
    Author testAuthor2;
    Author testAuthor3;
    @Before
    public void setup() {
        dao = new AuthorDAO();
        testAuthor = new Author();
        testAuthor1 = new Author();
        testAuthor2 = new Author();
        testAuthor3 = new Author();

        testAuthor1.setAuthorId("abc");
        testAuthor1.setFirstName("Johnson");
        testAuthor1.setLastName("Smith");

        testAuthor2.setAuthorId("def");
        testAuthor2.setFirstName("Johnson");
        testAuthor2.setLastName("Deer");

        testAuthor3.setAuthorId("ghi");
        testAuthor3.setFirstName("Joe");
        testAuthor3.setLastName("Smith");


        dao.addAuthor(testAuthor1);
        dao.addAuthor(testAuthor2);
        dao.addAuthor(testAuthor3);


    }
    @Test
    public void testAddAuthor() throws Exception {
        testAuthor.setAuthorId("100");
        testAuthor.setFirstName("Joe");
        testAuthor.setLastName("Smith");

        String i = "0";
        i = dao.addAuthor(testAuthor);
        assertTrue(!i.equals("0"));
        dao.deleteAuthor(testAuthor);
    }

    @Test
    public void testSearchAuthorById() throws Exception {
        testAuthor.setAuthorId("100");
        testAuthor.setFirstName("Joe");
        testAuthor.setLastName("Smith");
        String i = "0";
        i = dao.addAuthor(testAuthor);
        Author newAuthor = dao.findAuthorById("100");

        assertTrue(newAuthor.getAuthorId().equals("100"));
        assertTrue(newAuthor.getFirstName().equals("Joe"));
        assertTrue(newAuthor.getLastName().equals("Smith"));
        dao.deleteAuthor(testAuthor);
    }
    @Test
    public void testSearchAuthorByLastName() throws Exception {
        List<Author> x = (List<Author>) dao.findAuthorByParam("lastName", "Smith");
        assertTrue(x.size() == 2);
    }
    @Test
    public void testSearchAuthorByFirstName() throws Exception {
        List<Author> x = (List<Author>) dao.findAuthorByParam("firstName", "Johnson");
        assertTrue(x.size() == 2);
    }
    @Test
    public void testSearchAuthorById2() throws Exception {
        List<Author> x = (List<Author>) dao.findAuthorByParam("authorId", "abc");
        assertTrue(x.size() == 1);
    }
    @Test
    public void testGetAllAuthors() throws Exception {
        List<Author> x = (List<Author>) dao.getAllAuthors();
        assertTrue(x.size() >= 3);
    }

    @After
    public void tearDown() {
        dao.deleteAuthor(testAuthor1);
        dao.deleteAuthor(testAuthor2);
        dao.deleteAuthor(testAuthor3);
    }
}