package library.persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Student on 2/28/2016.
 */
public class LibraryDAO {
    protected final Logger log = Logger.getLogger(this.getClass());

    public LibraryDAO() {
    }

    //todo: tx.commit
    protected Transaction startTransaction(Session session) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error(e);
        }

        return transaction;
    }

}
