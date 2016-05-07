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
        testBook4.setTotalCopies(0);

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


    @Test
    public void addBook() throws Exception {

    }

    @Test
    public void getCopyById() throws Exception {

    }

    @Test
    public void getSimpleCopyById() throws Exception {

    }

    @Test
    public void getBookByIsbn() throws Exception {

    }

    @Test
    public void changeCheckoutStatus() throws Exception {

    }

    @Test
    public void checkoutBookCopy() throws Exception {

    }

    @Test
    public void returnBookCopy() throws Exception {

    }

    @Test
    public void updateBook() throws Exception {

    }

    @Test
    public void getAllBooks() throws Exception {

    }

    @Test
    public void searchForNumberOfAuthorBooks() throws Exception {

    }

    @Test
    public void searchForNumberOfBooks() throws Exception {

    }

    @Test
    public void getNumberOfBooks() throws Exception {

    }
}