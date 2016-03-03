package library.persistence;

import library.entities.Book;
//import org.apache.log4j.Logger;
import library.entities.BookCopy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.dialect.InterbaseDialect;

import java.util.Collection;
import java.util.List;

/**
 * Created by Student on 2/16/2016.
 */
public class BookDAO extends LibraryDAO {
    //private final Logger log = Logger.getLogger(this.getClass());

    //todo fix methods to use startTransaction from library dao
    private void addBookCopies(BookCopy bookCopy) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = startTransaction(session);

        session.save("BookCopy", bookCopy);
        tx.commit();

        session.close();


    }



    private void addBookCopies2(BookCopy bookCopy) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save("BookCopy", bookCopy);
            tx.commit();


            //log.info("Added user: " + employee + " with id of: " + employeeId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }

    }

    public Collection<BookCopy> findBookCopies(int bookIsbn) {
        Collection<BookCopy> copies = null;


        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            copies = session.createCriteria(BookCopy.class).add(Restrictions.eq("isbn", bookIsbn)).addOrder(Order.desc("bookNumber")).list();


        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }
        return copies;

    }

    public int addBook(Book book) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = startTransaction(session);




        Integer bookId;

        bookId = (Integer) session.save("Book", book);
        tx.commit();

        for (int i = 0; i < book.getCopies(); i++) {
            BookCopy newBook = new BookCopy();
            newBook.setIsbn(book.getIsbn());
            newBook.setBookCondition("new");
            newBook.setCheckoutStatus('i');
            newBook.setBookNumber(i + 1);
            addBookCopies2(newBook);
        }


        session.close();


        return bookId;
    }

    public int addBook2(Book book) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer bookId = 0;
        try {
            tx = session.beginTransaction();
            bookId = (Integer) session.save("Book", book);
            tx.commit();

            for (int i = 0; i < book.getCopies(); i++) {
                BookCopy newBook = new BookCopy();
                newBook.setIsbn(book.getIsbn());
                newBook.setBookCondition("New");
                newBook.setCheckoutStatus('I');
                newBook.setBookNumber(i + 1);
                addBookCopies2(newBook);
            }


            //log.info("Added user: " + employee + " with id of: " + employeeId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }
        return bookId;
    }

    public Collection<BookCopy> findCopiesByParam(String searchType, Object searchParam) {
        Collection<BookCopy> copies = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = startTransaction(session);
        copies = session.createCriteria(BookCopy.class).add(Restrictions.eq(searchType, searchParam)).list();
        return copies;
    }

    public BookCopy getCopyById(int bookNumber, int isbn) {
        BookCopy copy = new BookCopy();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = startTransaction(session);
        copy = (BookCopy) session.createCriteria(BookCopy.class)
                .add(Restrictions.eq("isbn", isbn))
                .add(Restrictions.eq("bookNumber", bookNumber))
                .list().get(0);
        return copy;
    }


}
