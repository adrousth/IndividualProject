package library.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alex on 4/26/2016.
 */
public class CheckoutResults extends Results {
    private static final DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
    private Date returnDate;
    private String date;

    public CheckoutResults() {
        super();
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.date = format.format(returnDate);
        this.returnDate = returnDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = format.format(date);
    }
}
