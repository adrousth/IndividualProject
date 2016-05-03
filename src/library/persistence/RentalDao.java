package library.persistence;

import library.entities.*;
import library.results.CheckoutResults;
import library.results.ReturnResults;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by Student on 2/28/2016.
 * Dao for checking out and returning books
 *
 */
public class RentalDAO extends LibraryDAO {


    /**
     * Adds the passed rental to the database
     * @param rental The rental to be added.
     * @return The rental id from the newly added rental. Returns -1 if the BookCopy in the rental does not exist.
     *         Returns 0 if the rental could not be added for any reason.
     */
    public int addRental(Rental rental) {

        BookDAO bookDAO = new BookDAO();
        if (!bookDAO.checkoutBookCopy(rental)) {
            return -1;
        }
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

    /**
     * Updates the rental table with a returning book copy.
     * @param rental The Rental to be updated.
     * @return 1 if the update succeeds. -1 if the BookCopy does not exist. 0 if the update failed for any reason.
     */
    public int returningRental(Rental rental) {
        BookDAO bookDAO = new BookDAO();


        if (!bookDAO.returnBookCopy(rental)) {
            return -1;
        }

        rental.setReturnDate(new Date());
        int i = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update("Rental", rental);
            tx.commit();
            i = 1;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return i;
    }

    /**
     * Gets all Rentals for a user.
     * @param userId The id for the user.
     * @return A list of (simple) rentals for the specified user.
     */
    public List<SimpleRental> getUserRentals(String userId) {
        List<SimpleRental> simpleRentals = new ArrayList<>();
        List<Rental> rentals;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        rentals = (List<Rental>) session.createCriteria(Rental.class)
                        .add(Restrictions.eq("userId", Integer.parseInt(userId))).list();
        for (Rental rental : rentals) {
            simpleRentals.add(rental.createSimpleRental());
        }

        session.close();

        return simpleRentals;

    }


    /**
     * Gets all rentals from the database.
     * @return A list of all the rentals.
     */
    public List<Rental> getAllRentals() {
        List<Rental> allRentals = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        allRentals = (List<Rental>) session.createCriteria(Rental.class).list();

        session.close();
        return allRentals;
    }


    /**
     * Gets the most recent rental for the specified book copy.
     * @param bookNumber The number for the book copy.
     * @param isbn The isbn of the book copy.
     * @return The most recent Rental of the book copy.
     */
    public Rental getRental(int bookNumber, String isbn) {
        Map<String, Object> propertiesMap = new HashMap<>();

        propertiesMap.put("bookNumber", bookNumber);
        propertiesMap.put("isbn", isbn);


        Rental rental = null;
        List<Rental> rentals;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();


        rentals = (List<Rental>) session.createCriteria(Rental.class)
                        .add(Restrictions.allEq(propertiesMap))
                        .addOrder(Order.desc("rentalId")).list();

        if (rentals.size() != 0) {
            rental = rentals.get(0);
        }


        session.close();
        return rental;

    }

    /**
     * Checks out a book to a user from the web form.
     * @param userId The user the book is being checked out to.
     * @param isbn The isbn of the book.
     * @param bookNumber The book number of the book.
     * @param days The number of days the book is being checked out for.
     * @return The results of the checkout.
     */
    public CheckoutResults checkoutFromForm(String userId, String isbn,
                                            String bookNumber, String days) {

        CheckoutResults results = new CheckoutResults();

        UserDAO userDAO = new UserDAO();
        User user = null;
        int id = 0;
        try {
            id = Integer.parseInt(userId);
            user = userDAO.getUserById(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (user == null) {
            results.addMessage("Error: Invalid user id");
        }

        BookDAO bookDAO = new BookDAO();
        BookCopy copy = null;
        int number = 0;
        try {
            number = Integer.parseInt(bookNumber);
            copy = bookDAO.getCopyById(number, isbn);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            results.addMessage("Error: Invalid book number");
        }
        if (copy == null) {
            results.addMessage("Error: Book not found");
        }
        if (results.getMessages().size() == 0) {
            Rental rental = new Rental();

            rental.setUserId(id);
            rental.setCheckoutDate(new Date());
            rental.setBookNumber(number);
            rental.setIsbn(isbn);

            int time = Integer.parseInt(days);

            rental.setRentalTime(time);

            int rentalId = addRental(rental);
            if (rentalId == -1 || rentalId == 0) {
                results.addMessage("Error, book is already checked out");
                return results;
            }
            Calendar calendar = new GregorianCalendar();

            calendar.add(Calendar.DAY_OF_MONTH, time);
            results.setReturnDate(calendar.getTime());
            results.setSuccess(true);
        }

        return results;
    }

    /**
     * Returns a book from the web form.
     * @param isbn The isbn of the book.
     * @param bookNumber The book number of the book.
     * @return The results of the return.
     */
    public ReturnResults returnFromForm(String isbn, String bookNumber) {
        ReturnResults results = new ReturnResults();

        UserDAO userDAO = new UserDAO();
        BookDAO bookDAO = new BookDAO();
        BookCopy copy = null;
        int number = 0;
        try {
            number = Integer.parseInt(bookNumber);
            copy = bookDAO.getCopyById(number, isbn);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (copy == null) {
            results.addMessage("Error: Book not found");
        }
        if (results.getMessages().size() == 0) {
            Rental rental;
            rental = getRental(number, isbn);
            if (rental == null) {
                results.addMessage("Error, book has not been checked out");
                return results;
            }

            if (returningRental(rental) < 0) {
                results.addMessage("Error, book has not been checked out");
                return results;
            }

            results.setBook(bookDAO.getSimpleCopyById(number, isbn));
            results.setUser(userDAO.getSimpleUserById(rental.getUserId()));
            results.setRentalTime(rental.getRentalTime());
            results.setReturnDate(new Date());
            results.setCheckoutDate(rental.getCheckoutDate());
            results.calculateDaysLate();

            results.setSuccess(true);

        }
        return results;
    }
}
