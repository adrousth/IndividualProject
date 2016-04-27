package library.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alex on 4/26/2016.
 */
public class ReturnResults {
    private static final DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
    private ArrayList<String> messages;
    private Date returnDate;
    private String date;
    private boolean success;

    public ReturnResults() {
        messages = new ArrayList<>();
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.date = format.format(returnDate);
        this.returnDate = returnDate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = format.format(date);
    }
}
