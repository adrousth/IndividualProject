package library.persistence;

import library.entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

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

}