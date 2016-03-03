package library.persistence;

import library.entities.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Student on 2/27/2016.
 */
public class CategoryDAO extends LibraryDAO {
    //todo fix methods to use startTransaction from library dao
    public void addBookCategory(Category category) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = startTransaction(session);

        session.save("Category", category);
        tx.commit();

        session.close();

    }
    public List<Category> getCategories() {
        List<Category> categories = null;


        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            categories = session.createCriteria(Category.class).list();


        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }
        return categories;

    }
}
