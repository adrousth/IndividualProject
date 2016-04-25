package library.entities;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Student on 2/11/2016.
 */
public class Rental implements Serializable {

    private int rentalId;
    private String isbn;
    private int userId;
    private int bookNumber;
    private Book book;
    private Date checkoutDate;
    private Date returnDate;
    private int rentalTime;
    private float fees;
    private String feesInfo;

    public Rental() {

    }

    public Rental(String isbn, int userId, int bookNumber, int rentalTime, float fees, String feesInfo, Date checkoutDate) {
        this.isbn = isbn;
        this.userId = userId;
        this.bookNumber = bookNumber;
        this.rentalTime = rentalTime;
        this.fees = fees;
        this.feesInfo = feesInfo;
        this.checkoutDate = checkoutDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getRentalId() {
        return rentalId;
    }


    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    public String getFeesInfo() {
        return feesInfo;
    }

    public void setFeesInfo(String feesInfo) {
        this.feesInfo = feesInfo;
    }
}
