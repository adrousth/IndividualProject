package library.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Student on 2/28/2016.
 */
public class LibraryDAO {
    protected Transaction startTransaction(Session session) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return transaction;
    }

}
