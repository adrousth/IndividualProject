package library.persistence;

import library.results.NewUserResults;
import library.entities.Rental;
import library.entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by Alex on 4/19/2016.
 */
public class UserDAOTest {
    private UserDAO dao;
    @Before
    public void setUp() throws Exception {
        dao = new UserDAO();
    }

    @Test
    public void addNewUser() throws Exception {
        User user = new User();
        user.setFirstName("Joe");
        user.setLastName("Smith");
        user.setAddressOne("123 helloworld ave");
        user.setPassword("foobar");
        int i = dao.addNewUser(user);
        System.out.println(i);
        assertTrue(i > 0);
    }

    @Test
    public void testAddnewUserFromForm() {
        NewUserResults results = dao.newUserFromForm("John", "Deerson", "2016-02-29", "hello@world.net", "777-7777", "5432 North street avenue", "", "Java town", "WI", "44444");
        for (String message : results.getMessages()) {
            System.out.println(message);
        }
        System.out.println(results.getNewUserId());
        System.out.println(results.getNewUserPassword());
        assertTrue(results.isSuccess());

    }

    @Test
    public void testing() {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        String email1 = "user@domain.com";
        String email2 = "user^domain.co.in";
        System.out.println(Pattern.matches(regex, email1));
        System.out.println(Pattern.matches(regex, ""));

    }

    @Test
    public void gettingRentals() {
        User user = dao.getUserById(1005);
        System.out.println(user.getRentals().size());
    }

    @Test
    public void updatingUser() {
        Date date = new Date();
        User user = dao.getUserById(1005);
        user.setAddressTwo("PO box 104");
        Rental rental = new Rental();
        rental.setIsbn("0006498523");
        rental.setBookNumber(3);
        rental.setCheckoutDate(date);
        rental.setUserId(1005);
        user.addRental(rental);
        dao.updateUser(user);
    }
}