package library.persistence;

import library.entities.*;
//import org.apache.log4j.Logger;
import library.results.SearchResults;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by Student on 2/16/2016.
 */
public class BookDAO extends LibraryDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    /*
     adds a copy of a book to the database. atm only called by addBook when a new book is entered
     ToDo: be able to add individual books
     */
    private void addBookCopy(BookCopy bookCopy) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save("BookCopy", bookCopy);
            tx.commit();

            log.info("Added book number: " + bookCopy.getBookNumber() + " with isbn: " + bookCopy.getIsbn());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }


    /*
     adds a new book to the database, as well as copies based on the number of copies.
     ToDo: Check to make sure that the book doesn't already exist

     */
    public String addBook(Book book) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String bookId = "";
        log.info("Book being added");
        try {
            tx = session.beginTransaction();
            bookId = (String) session.save("Book", book);
            tx.commit();

            for (int i = 0; i < book.getTotalCopies(); i++) {
                BookCopy newBook = new BookCopy();
                newBook.setIsbn(book.getIsbn());
                newBook.setBookCondition("New");
                newBook.setCheckoutStatus('I');
                newBook.setBookNumber(i + 1);
                addBookCopy(newBook);
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            bookId = "-1";
            log.error(e);
        } finally {
            session.close();
        }
        return bookId;
    }


    /*
     finds a single book copy by the isbn and the book number
     ToDo: implement findBookCopies method?
     */
    public BookCopy getCopyById(int bookNumber, String isbn) {
        List<BookCopy> copies = null;
        BookCopy copy = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        copies =  session.createCriteria(BookCopy.class)
                .add(Restrictions.eq("isbn", isbn))
                .add(Restrictions.eq("bookNumber", bookNumber))
                .list();
        if (copies != null && copies.size() > 0) {
            copy = copies.get(0);
        }
        session.close();
        return copy;
    }

    public SimpleBook getSimpleCopyById(int bookNumber, String isbn) {
        List<BookCopy> copies;
        SimpleBook book = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        copies = (List<BookCopy>) session.createCriteria(BookCopy.class)
                .add(Restrictions.eq("isbn", isbn))
                .add(Restrictions.eq("bookNumber", bookNumber))
                .list();
        if (copies.size() > 0) {
            book = new SimpleBook(getBookByIsbn(isbn));
            book.setBookNumber(copies.get(0).getBookNumber());
        }
        session.close();
        return book;
    }

    public Book getBookByIsbn(String isbn) {
        Book book = new Book();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Book> books = (List<Book>) session.createCriteria(Book.class)
                .add(Restrictions.eq("isbn", isbn))
                .list();
        if (books.size() > 0) {
            book = books.get(0);
        }
        return book;
    }

    public void changeCheckoutStatus(BookCopy bookCopy) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        if (bookCopy.getCheckoutStatus() == 'I') {
            bookCopy.setCheckoutStatus('O');
            // decrease copies available
        } else {
            bookCopy.setCheckoutStatus('I');
            // increase copies available
        }
        try {
            tx = session.beginTransaction();
            session.update("BookCopy", bookCopy);
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public boolean checkoutBookCopy(Rental rental) {
        BookCopy copy = getCopyById(rental.getBookNumber(), rental.getIsbn());
        if (copy.getCheckoutStatus() == 'I') {
            changeCheckoutStatus(copy);
            Book book = getBookByIsbn(rental.getIsbn());
            book.decreaseAvailableCopies();
            updateBook(book);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBookCopy(Rental rental) {
        BookCopy copy = getCopyById(rental.getBookNumber(), rental.getIsbn());
        if (copy.getCheckoutStatus() == 'O') {
            changeCheckoutStatus(copy);
            Book book = getBookByIsbn(rental.getIsbn());
            book.increaseAvailableCopies();
            updateBook(book);
            return true;
        } else {
            return false;
        }
    }

    public int updateBook(Book book) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int i = 0;
        try {
            tx = session.beginTransaction();
            session.update("Book", book);
            tx.commit();
            i = 1;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
            i = -1;
        } finally {
            session.close();
        }
        return i;
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        allBooks = (List<Book>) session.createCriteria(Book.class).list();

        return allBooks;
    }

    public List<Author> searchForNumberOfAuthorBooks(int firstResult, int numberOfBooks, String searchType, String searchValue) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();


        List<Author> authors = session.createCriteria(Author.class).add(Restrictions.like(searchType, "%" + searchValue + "%")).list();


        return authors;
    }

    public SearchResults searchForNumberOfBooks(int firstResult, int numberOfBooks, String searchType, String searchValue) {
        List<Book> books = null;
        SearchResults searchResults = new SearchResults();

        int number = 0;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        if (searchType.equals("")) {
            books = session.createCriteria(Book.class).setFirstResult(firstResult).setMaxResults(numberOfBooks).addOrder(Order.asc("title")).list();
            number = Math.toIntExact((Long) session.createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult());
        } else if (searchType.equals("firstName") || searchType.equals("lastName")) {
            Author author = (Author) session.createCriteria(Author.class).add(Restrictions.eq(searchType, searchValue)).list().get(0);
            number = author.getBooks().size();

            if ((numberOfBooks + firstResult) > author.getBooks().size()) {
                books = new ArrayList<>(author.getBooks()).subList(firstResult, author.getBooks().size());
            } else {
                books = new ArrayList<>(author.getBooks()).subList(firstResult, firstResult + numberOfBooks);
            }

        } else {
            books = session.createCriteria(Book.class).add(Restrictions.like(searchType, "%" + searchValue + "%")).setFirstResult(firstResult).setMaxResults(numberOfBooks).addOrder(Order.asc("title")).list();
            number = Math.toIntExact((Long) session.createCriteria(Book.class).setProjection(Projections.rowCount()).add(Restrictions.like(searchType, "%" + searchValue + "%")).uniqueResult());
        }

        searchResults.setBooks(books);
        searchResults.setCount(number);
        return searchResults;
    }

    public int getNumberOfBooks(String searchType, String searchValue) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        int number = 0;
        if (searchType.equals("")) {
            number = Math.toIntExact((Long) session.createCriteria(Book.class).setProjection(Projections.rowCount()).uniqueResult());
        } else if (searchType.equals("firstName")) {
            List<Author> authors = session.createCriteria(Author.class).add(Restrictions.like(searchType, "%" + searchValue + "%")).list();
            for (Author author: authors) {
                number += author.getBooks().size();
            }

        } else {
            number = Math.toIntExact((Long) session.createCriteria(Book.class).setProjection(Projections.rowCount()).add(Restrictions.like(searchType, "%" + searchValue + "%")).uniqueResult());
        }
        session.close();
        return number;
    }

}
