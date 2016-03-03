package library.persistence;

import library.entities.Rental;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/28/2016.
 */
public class RentalDAOTest {

    @Test
    public void testAddRental() throws Exception {
        RentalDAO dao = new RentalDAO();
        Rental rental = new Rental(1234567890, 10101, 123, 2, 5, (float) 0.00, "");
        int i = dao.addRental(rental);
        System.out.println(i);
        assertTrue(i > 0);

    }
}