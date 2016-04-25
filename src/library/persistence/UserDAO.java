package library.persistence;

import library.entities.AddUserResults;
import library.entities.SimpleUser;
import library.entities.User;
import org.apache.bval.routines.EMailValidationUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Student on 3/15/2016.
 */
public class UserDAO extends LibraryDAO {
    private final Logger log = Logger.getLogger(this.getClass());
    private final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

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
            session.createSQLQuery("INSERT INTO user_roles(user_id) VALUE (" + userId + ")").executeUpdate();

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

    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate("User", user);
            tx.commit();

            log.info("Updated user: " + user.getFirstName() + " " + user.getLastName());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    public User getUserById(int userId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User)session.createCriteria(User.class).add(Restrictions.eq("userId", userId)).list().get(0);
        session.close();
        return user;
    }
    public SimpleUser getSimpleUserById(int userId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        SimpleUser user = new SimpleUser();
        user = ((User)session.createCriteria(User.class).add(Restrictions.eq("userId", userId)).list().get(0)).simpleUserInfo();
        return user;
    }

    public AddUserResults newUserFromForm(String firstName, String lastName, String birthday, String email, String phone, String addressOne, String addressTwo, String city, String state, String zip) {
        System.out.println(birthday);
        AddUserResults results = new AddUserResults();
        DateFormat format = new SimpleDateFormat("yyyy-dd-MM");
        Date date = null;
        if (firstName.length() < 2 || firstName.equals(null)) {
            results.addMessage("first name must be at least two letters long");
        }
        if (lastName.length() < 2 || lastName.equals(null)) {
            results.addMessage("last name must be at least two letters long");
        }
        try {
            date = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
            results.addMessage("invalid date");
        }
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            results.addMessage("email is not valid");
        }
        if (results.getMessages().size() == 0) {
            String userPassword = RandomStringUtils.random(6, true, true);
            User user = new User(firstName, lastName, date, email, phone, addressOne, addressTwo, city, state, zip, userPassword);
            results.setNewUserId(addNewUser(user));
            results.setNewUserPassword(userPassword);
            results.setSuccess(true);
        }
        return results;
    }

}
