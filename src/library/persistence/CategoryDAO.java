package library.persistence;

import library.entities.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Student on 2/27/2016.
 * Dao for categories, not currently implemented.
 */
public class CategoryDAO extends LibraryDAO {

    public void addBookCategory(Category category) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = startTransaction(session);

        session.save("Category", category);
        tx.commit();

        session.close();

    }
    public List<Category> getCategories() {
        List<Category> categories;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        categories = session.createCriteria(Category.class).list();

        session.close();
        return categories;
    }
}
