package library.results;

import library.entities.SimpleBook;
import library.entities.SimpleUser;
import org.joda.time.DateTime;
import org.joda.time.Days;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alex on 4/26/2016.
 */
public class ReturnResults extends Results {
    private static final DateFormat format = new SimpleDateFormat("MM-dd-yyyy");

    private Date returnDate;
    private String formattedReturnDate;
    private Date checkoutDate;
    private String formattedCheckoutDate;

    private int daysLate;
    private int rentalTime;

    private SimpleUser user;
    private SimpleBook book;


    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        this.formattedReturnDate = format.format(returnDate);
    }

    public String getFormattedReturnDate() {
        return formattedReturnDate;
    }

    public void setFormattedReturnDate(String formattedReturnDate) {
        this.formattedReturnDate = formattedReturnDate;
    }

    public String getFormattedCheckoutDate() {
        return formattedCheckoutDate;
    }

    public void setFormattedCheckoutDate(String formattedCheckoutDate) {
        this.formattedCheckoutDate = formattedCheckoutDate;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    public void calculateDaysLate() {
        daysLate = Days.daysBetween(new DateTime(checkoutDate), new DateTime(returnDate)).getDays() - rentalTime;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
        this.formattedCheckoutDate = format.format(checkoutDate);
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(int daysLate) {
        this.daysLate = daysLate;
    }

    public SimpleBook getBook() {
        return book;
    }

    public void setBook(SimpleBook book) {
        this.book = book;
    }

    public SimpleUser getUser() {
        return user;
    }

    public void setUser(SimpleUser user) {
        this.user = user;
    }

    public ReturnResults() {
        messages = new ArrayList<>();
    }

    public Date getReturnDate() {
        return returnDate;
    }

}
