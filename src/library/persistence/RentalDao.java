package library.persistence;

import library.entities.AddRentalResults;
import library.entities.BookCopy;
import library.entities.Rental;
import library.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by Student on 2/28/2016.
 */
public class RentalDAO extends LibraryDAO {

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

    public void returningRental(Rental rental) {
        BookDAO bookDAO = new BookDAO();


        if (bookDAO.returnBookCopy(rental)) {
            rental.setReturnDate(new Date());
        }


        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update("Rental", rental);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }


    public List<Rental> getAllRentals() {
        List<Rental> allRentals = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        allRentals = (List<Rental>) session.createCriteria(Rental.class).list();

        session.close();
        return allRentals;
    }

    public Rental getRental(int userId, int bookNumber, String isbn) {
        Map<String, Object> propertiesMap = new HashMap<>();

        propertiesMap.put("userId", userId);
        propertiesMap.put("bookNumber", bookNumber);
        propertiesMap.put("isbn", isbn);


        Rental rental = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();


        rental = (Rental) session.createCriteria(Rental.class).add(Restrictions.allEq(propertiesMap)).addOrder(Order.desc("rentalId")).list().get(0);

        session.close();
        return rental;

    }

    public AddRentalResults checkoutFromForm(String userId, String isbn, String bookNumber, String days) {
        AddRentalResults results = new AddRentalResults();



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
            results.addMessage("Invalid user id");
        }

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
            results.addMessage("Book does not exist");
        }
        if (results.getMessages().size() == 0) {
            Rental rental = new Rental();
            rental.setUserId(id);
            rental.setCheckoutDate(new Date());
            rental.setBookNumber(number);
            rental.setIsbn(isbn);

            int rentalId = addRental(rental);
            if (rentalId == -1 || rentalId == 0) {
                results.addMessage("Error, book is already checked out");
                return results;
            }
            Calendar calendar = new GregorianCalendar();
            int time = Integer.parseInt(days);
            calendar.add(Calendar.DAY_OF_MONTH, time);
            results.setReturnDate(calendar.getTime());
            results.setSuccess(true);
        }

        return results;
    }
}
