package library.persistence;

import library.entities.*;
import library.results.SearchResults;
import org.hibernate.Transaction;
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
    public void testGetAllBooks() {
        List<Book> books = dao.getAllBooks();
        int i = 1;
        for (Book book: books) {
            System.out.println("book #: " + i);
            System.out.println(book.getIsbn());
            System.out.println(book.getTitle());
            System.out.println();
            i++;
        }
    }

    @Test
    public void testNumberOFBooks() {
        SearchResults results = dao.searchForNumberOfBooks(2, 3, "title", "hello");
        int i = 1;
        for (Book book: results.getBooks()) {
            System.out.println("book #: " + i);
            System.out.println(book.getIsbn());
            System.out.println(book.getTitle());
            System.out.println();
            i++;
        }
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
    public void testGetBookById() {
        BookCopy copy = dao.getCopyById(2, "1234567890");
        System.out.print("isbn: " + copy.getIsbn());
        System.out.print(" book#: " + copy.getBookNumber());
        System.out.print(" condition: " + copy.getBookCondition());
        System.out.println(" status: " + copy.getCheckoutStatus());
    }

    @Test
    public void testSearchNumberOfBooks() {
        SearchResults results = dao.searchForNumberOfBooks(0, 1000, "title", "the");
        System.out.println(Math.ceil((float)results.getBooks().size() / 7));
        assertTrue(results.getBooks().size() > 1);

    }

    @Test
    public void testSearchingBookAuthors() {
        Set<Book> books = new HashSet<>();
        List<Author> authors = dao.searchForNumberOfAuthorBooks(0, 10, "firstName", "e");
        System.out.println(authors.size());
        for (Author author: authors) {
            books.addAll(author.getBooks());
        }
        System.out.println(books.size());
        for (Book book: books) {
            System.out.println(book.getTitle());
        }
        assertTrue(authors.size() > 1);
    }

    @Test
    public void testSearchingBookAuthors2() {
        SearchResults results = dao.searchForNumberOfBooks(10, 20, "firstName", "mark");
        System.out.println(results.getBooks().get(0).getTitle());
        System.out.println(results.getBooks().size());


    }

    @Test
    public void testing() {
        SearchResults results = dao.searchForNumberOfBooks(0, 10, "firstName", "mark");
        for (BookCopy copy : results.getBooks().get(0).getBookCopies()) {
            System.out.println("book number: " + copy.getBookNumber());
            System.out.println("isbn: " + copy.getIsbn());
        }

    }
}