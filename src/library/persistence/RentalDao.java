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
    //todo fix methods to use startTransaction from library dao

    public int addRental(Rental rental) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = startTransaction(session);



        BookDAO dao = new BookDAO();
        Integer rentalId;
        //BookCopy rentalItem = dao.getCopyById(rental.getBookNumber(), rental.getIsbn());
        rentalId = (Integer) session.save("Rental", rental);
        tx.commit();


        return rentalId;
    }
}