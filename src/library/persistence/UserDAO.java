package library.persistence;

import library.results.NewUserResults;
import library.entities.SimpleUser;
import library.entities.User;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Student on 3/15/2016.
 * Dao for users.
 */
public class UserDAO extends LibraryDAO {
    private final Logger log = Logger.getLogger(this.getClass());
    private final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    /**
     * Adds a user to the database.
     * @param user The user being added.
     * @return The new user id if successfully added, 0 otherwise.
     */
    public int addNewUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int userId = 0;
        try {
            tx = session.beginTransaction();
            userId = (int) session.save("User", user);
            session.createSQLQuery("INSERT INTO user_roles(user_id) VALUE ("
                                    + userId + ")").executeUpdate();

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

    /**
     * Updates the user.
     * @param user The user being updated.
     */
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

    /**
     * Gets a user based on their id.
     * @param userId The id of the user,
     * @return The user, if found.
     */
    public User getUserById(int userId) {
        List<User> users;
        User user = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = (List<User>) session.createCriteria(User.class)
                            .add(Restrictions.eq("userId", userId)).list();
        if (users.size() != 0) {
            user = users.get(0);
        }
        session.close();
        return user;
    }

    /**
     * Gets a (simple) user based on their id
     * @param userId The id of the user.
     * @return The (simple) user, if found.
     */
    public SimpleUser getSimpleUserById(int userId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        SimpleUser user = new SimpleUser();
        user = ((User)session.createCriteria(User.class)
                .add(Restrictions.eq("userId", userId)).list().get(0)).simpleUserInfo();

        return user;
    }

    /**
     * Adds a new user from the web form. Requires at list a valid first name, last name, birthday and email.
     * @param firstName New user's first name.
     * @param lastName New user's last name.
     * @param birthday New user's b-day.
     * @param email New user's email.
     * @param phone New user's phone number.
     * @param addressOne New user's address (one).
     * @param addressTwo New user's address (two).
     * @param city New user's city.
     * @param state New user's state.
     * @param zip New user's zip code.
     * @return The results of adding the new user.
     */
    public NewUserResults newUserFromForm(String firstName, String lastName, String birthday, String email, String phone, String addressOne, String addressTwo, String city, String state, String zip) {
        NewUserResults results = new NewUserResults();
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
