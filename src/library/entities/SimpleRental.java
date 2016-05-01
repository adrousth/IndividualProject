package library.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Alex on 4/29/2016.
 */
public class SimpleRental {
    private static final DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
    private String bookNumber;
    private String title;
    private String checkout;
    private String returned;
    private String dueBy;
    private Date checkoutDate;
    private Date returnDate;
    private int rentalTime;

    public SimpleRental() {

    }

    public void formatDates() {
        if (checkoutDate != null) {
            checkout = format.format(checkoutDate);
        }
        if (returnDate != null) {
            returned = format.format(returnDate);
        }
        formatDueBy();
    }

    public void formatDueBy() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(checkoutDate);
        calendar.add(Calendar.DAY_OF_MONTH, rentalTime);
        dueBy = format.format(calendar.getTime());
    }

    public String getDueBy() {
        return dueBy;
    }

    public void setDueBy(String dueBy) {
        this.dueBy = dueBy;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getReturned() {
        return returned;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
