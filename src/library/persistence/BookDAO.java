package library.persistence;

import library.entities.Book;
//import org.apache.log4j.Logger;
import library.entities.BookCopy;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
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
     finds all copies of a book by it's isbn
     ToDo: by able to search by other params
     */
    public Collection<BookCopy> findBookCopies(int bookIsbn) {
        Collection<BookCopy> copies;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        copies = session.createCriteria(BookCopy.class).add(Restrictions.eq("isbn", bookIsbn)).addOrder(Order.desc("bookNumber")).list();

        session.close();

        return copies;

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

            for (int i = 0; i < book.getCopies(); i++) {
                BookCopy newBook = new BookCopy();
                newBook.setIsbn(book.getIsbn());
                newBook.setBookCondition("New");
                newBook.setCheckoutStatus('I');
                newBook.setBookNumber(i + 1);
                addBookCopy(newBook);
            }


            //log.info("Added user: " + employee + " with id of: " + employeeId);
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            bookId = "-1";
            log.error("error did not add book");
        } finally {
            session.close();
        }
        return bookId;
    }


    /*
     currently only really able to search by isbn
     ToDo: should either get rid of this method or merge it with findBookCopies
     */
    public Collection<BookCopy> findCopiesByParam(String searchType, Object searchParam) {
        Collection<BookCopy> copies;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        copies = session.createCriteria(BookCopy.class).add(Restrictions.eq(searchType, searchParam)).list();
        return copies;
    }

    /*
     finds a single book copy by the isbn and the book number
     ToDo: implement findBookCopies method?
     */
    public BookCopy getCopyById(int bookNumber, int isbn) {
        BookCopy copy;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        copy = (BookCopy) session.createCriteria(BookCopy.class)
                .add(Restrictions.eq("isbn", isbn))
                .add(Restrictions.eq("bookNumber", bookNumber))
                .list().get(0);
        return copy;
    }

    public List<String> addBookFromForm(String isbn, String title, String publisher, String publishYear, String edition, String copies) {

        List<String> messages = new ArrayList<>();
        Book newBook = new Book();

        if (isbn == null || isbn.length() <= 0 || isbn.length() > 10 || !convertToNumber(isbn)) {
            messages.add("please enter a 10 digit isbn");
        } else {
            newBook.setIsbn(isbn);
        }

        if (title == null || title.length() <= 0) {
            messages.add("please enter a title");
        } else {
            newBook.setTitle(title);
        }

        if (copies == null || copies.length() <= 0 || !convertToNumber(copies)) {
            messages.add("please enter the number of copies being added");
        } else {
            newBook.setCopies(Integer.valueOf(copies));
        }

        if (convertToNumber(publishYear)) {
            int year = Integer.valueOf(publishYear);
            if (year <= 0 || year > Calendar.getInstance().get(Calendar.YEAR)) {
                messages.add("please enter a number for the publish year between 0 and " + Calendar.getInstance().get(Calendar.YEAR));
            }
            newBook.setPublishYear(publishYear);
        }
        if (messages.size() > 0) {
            messages.add("Book was not added.");
            return messages;
        }
        newBook.setPublisher(publisher);
        newBook.setEdition(edition);

        if (addBook(newBook) == isbn) {
            messages.add("Book was successfully added");
        } else {
            messages.add("Book was not added");
        }


        return messages;
    }

    private boolean convertToNumber(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e){
            log.error(e);
            System.out.println(e);
            return false;
        }
        return true;
    }
}
