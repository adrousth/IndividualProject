package library.persistence;

import library.entities.Author;
import library.entities.Book;
import library.entities.BookCopy;
import library.entities.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/21/2016.
 */
public class BookDAOTest {
    Transaction transaction = null;
    BookDAO dao = null;
    CategoryDAO cDao = null;
    AuthorDAO aDao = null;
    @Before
    public void setup() {
        dao = new BookDAO();
        cDao = new CategoryDAO();
        aDao = new AuthorDAO();
    }

    @Test
    public void testAddBook() throws Exception {

        String i = "";
        Book x = new Book();
        x.setIsbn("10");
        x.setTitle("Hello World!");
        x.setPublisher("Java inc.");
        x.setPublishYear("1990");
        x.setEdition("3rd");
        x.setCopies(3);
        x.setAvailableCopies(3);
        Set<Author> authors = new HashSet<>(aDao.findAuthorByParam("firstName", "Fred"));
        Set<Category> categories = new HashSet<>();
        Category c = new Category();
        Category c2 = new Category();
        c.setCategory("Fantasy");
        categories.add(c);
        c2.setCategory("Programming");
        categories.add(c2);

        x.setAuthors(authors);
        x.setCategories(categories);

        i = dao.addBook(x);
        assertTrue(i != "");
    }
    @Test
    public void testGetBooks() {
        Set<BookCopy> books = new HashSet<>(dao.findBookCopies(1234567890));
        for (BookCopy copy : books) {
            System.out.print("isbn: " + copy.getIsbn());
            System.out.print(" book#: " + copy.getBookNumber());
            System.out.print(" condition: " + copy.getBookCondition());
            System.out.println(" status: " + copy.getCheckoutStatus());
        }

    }
    @Test
    public void testGetBooksByParam() {
        Set<BookCopy> books = new HashSet<>(dao.findCopiesByParam("isbn", 1234567890));
        for (BookCopy copy : books) {
            System.out.print("isbn: " + copy.getIsbn());
            System.out.print(" book#: " + copy.getBookNumber());
            System.out.print(" condition: " + copy.getBookCondition());
            System.out.println(" status: " + copy.getCheckoutStatus());
        }

    }
    @Test
    public void testGetBookById() {
        BookCopy copy = dao.getCopyById(2, 1234567890);
        System.out.print("isbn: " + copy.getIsbn());
        System.out.print(" book#: " + copy.getBookNumber());
        System.out.print(" condition: " + copy.getBookCondition());
        System.out.println(" status: " + copy.getCheckoutStatus());
    }
    @Test
    public void testAddBookFromForm() {
        ArrayList<String> testMessage = (ArrayList<String>) dao.addBookFromForm("1234", "Hello World", "Java Inc.", "1990", "2nd", "34");
        for (String line : testMessage) {
            System.out.println(line);
        }
    }
}