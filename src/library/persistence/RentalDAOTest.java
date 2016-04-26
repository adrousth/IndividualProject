package library.persistence;

import library.entities.AddRentalResults;
import library.entities.Rental;
import library.entities.User;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/28/2016.
 */
public class RentalDAOTest {
    private RentalDAO dao;

    @Before
    public void setUp() {
        dao = new RentalDAO();
    }

    @Test
    public void testAddRental() throws Exception {
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

    @Test
    public void returningRental() {
        Rental rental = dao.getRental(1005, 3, "0006498523");
        System.out.println(rental.getRentalId());
        dao.returningRental(rental);
    }

    @Test
    public void getAllRentals() {
        List<Rental> rentals = dao.getAllRentals();
        System.out.println(rentals.size());
        System.out.println(rentals.get(1).getCheckoutDate());
        assertTrue(rentals.size() > 0);
    }

    @Test
    public void fromForm() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        AddRentalResults results = dao.checkoutFromForm("1005", "0006498523", "6", "6");
        System.out.println(results.getMessages().size());
        System.out.println(results.getDate());
        assertTrue(results != null);

    }



}