package library.persistence;

import library.entities.*;
import library.results.SearchResults;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/21/2016.
 */
public class BookDAOTest {
    BookDAO dao = null;
    AuthorDAO aDao = null;
    Book testBook;
    Book testBook1;
    Book testBook2;
    Book testBook3;
    Book testBook4;
    @Before
    public void setup() {
        dao = new BookDAO();
        aDao = new AuthorDAO();
        testBook = new Book();

        testBook1 = new Book();
        testBook1.setIsbn("abcdefghij");
        testBook1.setTitle("Hello World");
        testBook1.setTotalCopies(2);

        testBook2 = new Book();
        testBook2.setIsbn("abcdefghik");
        testBook2.setTitle("Hello World2");
        testBook2.setTotalCopies(1);

        testBook3 = new Book();
        testBook3.setIsbn("abcdefghil");
        testBook3.setTitle("Hello World3");
        testBook3.setTotalCopies(3);

        testBook4 = new Book();
        testBook4.setIsbn("abcdefghim");
        testBook4.setTitle("Hello World4");
        testBook4.setTotalCopies(1);

        dao.addBook(testBook1);
        dao.addBook(testBook2);
        dao.addBook(testBook3);
        dao.addBook(testBook4);

    }

    @After
    public void tearDown() throws Exception {
        dao.deleteBook(dao.getBookByIsbn(testBook1.getIsbn()));
        dao.deleteBook(dao.getBookByIsbn(testBook2.getIsbn()));
        dao.deleteBook(dao.getBookByIsbn(testBook3.getIsbn()));
        dao.deleteBook(dao.getBookByIsbn(testBook4.getIsbn()));
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = dao.getAllBooks();
        assertTrue(books.size() > 0);
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
        x.setTotalCopies(3);
        x.setAvailableCopies(3);

        i = dao.addBook(x);
        assertTrue(i != "");
        dao.deleteBook(x);
    }

    @Test
    public void testAddBook2() throws Exception {
        String i = "";
        i = dao.addBook(testBook2);
        assertTrue(i == "0" || i == "-1");
    }

    @Test
    public void testGetBookCopyById() {
        BookCopy copy = null;
        copy = dao.getCopyById(3, "abcdefghil");
        assertTrue(copy != null);

    }

    @Test
    public void testGetBookCopyById2() {
        BookCopy copy = null;
        copy = dao.getCopyById(4, "abcdefghil");
        assertTrue(copy == null);

    }

    @Test
    public void testSearchNumberOfBooks() {
        SearchResults results = dao.searchForNumberOfBooks(0, 3, "title", "Hello");
        assertTrue(results.getBooks().size() == 3);
    }

    @Test
    public void testSearchNumberOfBooks2() {
        SearchResults results = dao.searchForNumberOfBooks(0, 2, "title", "Hello");
        assertTrue(results.getBooks().size() == 2);
    }

    @Test
    public void testSearchingBookAuthors() {
        SearchResults results = dao.searchForNumberOfBooks(10, 20, "firstName", "mark");
        assertTrue(results.getBooks().size() > 0);
    }

    @Test
    public void testSearchingBookAuthors2() {
        SearchResults results = dao.searchForNumberOfBooks(0, 10, "firstName", "adsfklja;kjsdf");
        assertTrue(results.getBooks().size() == 0);
    }

    @Test
    public void getBookByIsbn() throws Exception {
        Book book = null;
        book = dao.getBookByIsbn("abcdefghik");
        assertTrue(book != null);
    }

    @Test
    public void getBookByIsbn2() throws Exception {
        Book book = null;
        book = dao.getBookByIsbn("abcdefghikasdf");
        assertTrue(book.getIsbn() == null);
    }

    @Test
    public void updateBook() throws Exception {
        testBook1.setTitle("My new Book");
        int i = dao.updateBook(testBook1);
        assertTrue(i > 0);
    }

    @Test
    public void updateBook2() throws Exception {
        testBook.setIsbn("mynewisbn");
        int i = dao.updateBook(testBook);
        assertTrue(i <= 0);
    }

    @Test
    public void changeCheckoutStatus() {
        BookCopy copy = dao.getCopyById(3, "abcdefghil");

        dao.changeCheckoutStatus(copy);
        copy = dao.getCopyById(3, "abcdefghil");
        assertTrue(copy.getCheckoutStatus() == 'O');
        dao.changeCheckoutStatus(copy);
        copy = dao.getCopyById(3, "abcdefghil");
        assertTrue(copy.getCheckoutStatus() == 'I');
    }

}