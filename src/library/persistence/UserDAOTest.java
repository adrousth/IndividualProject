package library.persistence;

import library.entities.User;
import org.apache.bval.routines.EMailValidationUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
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
        /*
        ArrayList<String> messages = dao.newUserFromForm("","","2013-20-2","","","","","","","");
        for (String message : messages) {
            System.out.println(message);
        }
        assertTrue(messages.size() > 0);
        */
        //System.out.println("new user password: " + RandomStringUtils.random(6, true, true));

        System.out.println(EMailValidationUtils.isValid("testworld.ad"));

    }

}