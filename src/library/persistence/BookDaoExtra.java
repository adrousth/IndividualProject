package library.persistence;

import library.entities.Book;
import library.entities.BookCopy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

/**
 * Created by Student on 3/8/2016.
 */
public class BookDaoExtra extends LibraryDAO {
    private void addBookCopies2(BookCopy bookCopy) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            Integer x = (Integer) session.save("BookCopy", bookCopy);

            tx.commit();


            log.info("Added book number: " + bookCopy.getIsbn());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

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
                //newBook.setIsbn(book.getIsbn());
                newBook.setBookCondition("New");
                newBook.setCheckoutStatus('I');
                newBook.setBookNumber(i + 1);
                addBookCopies2(newBook);
            }


            //log.info("Added user: " + employee + " with id of: " + employeeId);
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }
        return bookId;
    }
    public Collection<BookCopy> findBookCopies2(int bookIsbn) {
        Collection<BookCopy> copies = null;


        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            copies = session.createCriteria(BookCopy.class).add(Restrictions.eq("isbn", bookIsbn)).addOrder(Order.desc("bookNumber")).list();


        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return copies;

    }
}
