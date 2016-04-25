package library.persistence;

import library.entities.Rental;
import library.entities.User;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/28/2016.
 */
public class RentalDAOTest {

    @Test
    public void testAddRental() throws Exception {
        RentalDAO dao = new RentalDAO();
        UserDAO userDAO = new UserDAO();
        Date date = new Date();
        //String isbn, int userId, int bookNumber, int rentalTime, float fees, String feesInfo, Date checkoutDate) {
        System.out.println(date);
        //Rental rental = new Rental("0006498523", 1001, 3, 5, (float) 0.00, "", date);
        Rental rental = new Rental();
        rental.setIsbn("0006498523");
        rental.setBookNumber(3);
        rental.setCheckoutDate(date);
        rental.setUserId(1005);
        //User user = userDAO.getUserById(1005);
        //user.


        int i = dao.addRental(rental);
        System.out.println(i);
        assertTrue(i > 0);

    }
}