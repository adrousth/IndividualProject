package library.persistence;

import library.entities.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.List;

/**
 * Created by Student on 2/23/2016.
 * Dao for authors.
 */
public class AuthorDAO extends LibraryDAO {

    /**
     * Adds an author to the database
     * @param newAuthor The author to be added.
     * @return The new author id if insert was successful, otherwise 0 or -1 if it was not added.
     */
    public String addAuthor(Author newAuthor) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String authorId = "0";
        try {
            tx = session.beginTransaction();
            authorId = (String) session.save("Author", newAuthor);

            tx.commit();
            //log.info("Added user: " + employee + " with id of: " + employeeId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
            authorId = "-1";
        } finally {
            session.close();
        }
        return authorId;
    }

    /**
     * finds an author based on the given ID
     * @param authorId The if for the author.
     * @return The author that was found.
     */
    public Author findAuthorById(int authorId) {
        Author author = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            author = (Author) session.get(Author.class, authorId);
            //log.info("Added user: " + employee + " with id of: " + employeeId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }
        return author;
    }

    /**
     *
     * @param searchType
     * @param searchParam
     * @return
     *
     */
    public Collection<Author> findAuthorByParam(String searchType, Object searchParam) {

        Collection<Author> authors = null;


        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            authors = session.createCriteria(Author.class).add(Restrictions.eq(searchType, searchParam)).list();


        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }
        return authors;
    }

    /**
     * gets all authors
     * @return
     */
    public Collection<Author> getAllAuthors() {

        Collection<Author> authors = null;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            authors = session.createCriteria(Author.class).list();


        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();//log.error(e);
        } finally {
            session.close();
        }
        return authors;
    }

}
