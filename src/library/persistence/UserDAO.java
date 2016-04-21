package library.persistence;

import library.entities.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Student on 3/15/2016.
 */
public class UserDAO extends LibraryDAO {
    private final Logger log = Logger.getLogger(this.getClass());

    /*
     adds a copy of a book to the database. atm only called by addBook when a new book is entered
     ToDo: be able to add individual books
     */
    public int addNewUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int userId = 0;
        try {
            tx = session.beginTransaction();
            userId = (int) session.save("User", user);
            tx.commit();

            log.info("Added user: " + user.getFirstName() + " " + user.getLastName());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return userId;
    }
}
