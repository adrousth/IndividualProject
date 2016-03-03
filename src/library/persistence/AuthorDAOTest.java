package library.persistence;

import library.entities.Author;
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
    @Before
    public void setup() {
        dao = new AuthorDAO();
    }
    @Test
    public void testAddAuthor() throws Exception {
        Author testAuthor = new Author();

        testAuthor.setAuthorId(100);
        testAuthor.setFirstName("Joe");
        testAuthor.setLastName("Smith");

        int i = 0;
        i = dao.addAuthor(testAuthor);
        assertTrue(i > 0);
    }
    @Test
    public void testSearchAuthorById() throws Exception {

        Author newAuthor = dao.findAuthorById(101);
        System.out.println(newAuthor.getFirstName());
        System.out.println(newAuthor.getLastName());
        System.out.println(newAuthor.getAuthorId());
    }
    @Test
    public void testSearchAuthorByLastName() throws Exception {
        Set<Author> x = (Set<Author>) dao.findAuthorByParam("lastName", "Smith");
        outputSearchResults(x);
        assertTrue(x.size() == 3);
    }
    @Test
    public void testSearchAuthorByFirstName() throws Exception {
        Set<Author> x = (Set<Author>) dao.findAuthorByParam("firstName", "Fred");
        outputSearchResults(x);
        assertTrue(x.size() == 2);
    }
    @Test
    public void testSearchAuthorById2() throws Exception {
        Set<Author> x = (Set<Author>) dao.findAuthorByParam("authorId", 104);
        outputSearchResults(x);

    }
    @Test
    public void testGetAllAuthors() throws Exception {
        Set<Author> x = (Set<Author>) dao.getAllAuthors();
        outputSearchResults(x);
        assertTrue(x.size() == 4);
    }

    private void outputSearchResults(Collection<Author> authors) {

        for (Author author : authors) {

            System.out.print("First Name: " + author.getFirstName());
            System.out.print(" Last Name: " +author.getLastName());
            System.out.println(" ID: " + author.getAuthorId());
        }
    }

}