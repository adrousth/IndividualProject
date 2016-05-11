package library.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Student on 2/11/2016.
 */
@Entity
@Table(name = "rentals")
public class Rental implements Serializable {
    @Id @GeneratedValue
    @Column(name = "rental_id")
    private int rentalId;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "book_number")
    private int bookNumber;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "isbn", insertable = false, updatable = false),
                  @JoinColumn(name = "book_number", insertable = false, updatable = false)})
    private BookCopy bookCopy;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "checkout_date")
    private Date checkoutDate;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "rental_time")
    private int rentalTime;
    @Column(name = "fees")
    private float fees;
    @Column(name = "fees_info")
    private String feesInfo;

    public Rental() {
        returnDate = null;
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

    public SimpleRental createSimpleRental() {
        SimpleRental rental = new SimpleRental();
        rental.setRentalTime(rentalTime);
        rental.setCheckoutDate(checkoutDate);
        rental.setBookNumber(isbn + "-" + bookNumber);
        rental.setReturnDate(returnDate);
        rental.formatDates();
        return rental;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
}
