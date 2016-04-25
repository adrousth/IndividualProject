package library.persistence;

import library.entities.BookCopy;
import library.entities.Rental;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

/**
 * Created by Student on 2/28/2016.
 */
public class RentalDAO extends LibraryDAO {

    public int addRental(Rental rental) {

        BookDAO bookDAO = new BookDAO();
        BookCopy copy = bookDAO.getCopyById(rental.getBookNumber(), rental.getIsbn());

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int rentalId = 0;
        try {
            tx = session.beginTransaction();

            rentalId = (Integer) session.save("Rental", rental);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return rentalId;
    }

    public boolean checkoutBookCopy(Rental rental) {
        BookDAO bookDAO = new BookDAO();
        BookCopy copy = bookDAO.getCopyById(rental.getBookNumber(), rental.getIsbn());
        if (copy.getCheckoutStatus() == 'I') {

            return true;
        } else {
            return false;
        }
    }

    public void getRentals() {

    }
}
