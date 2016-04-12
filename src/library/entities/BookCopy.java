package library.entities;
import java.io.Serializable;

/**
 * Created by Student on 2/11/2016.
 */
public class BookCopy implements Serializable{
    //private Book bookInfo;
    private String isbn;
    private int bookNumber;
    private String bookCondition;
    private char checkoutStatus; // char use single quotes - 'A' not "A"

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

   /* public Book getBookInfo() {
        return bookInfo;
    }*/

    /*public void setBookInfo(Book bookInfo) {
        this.bookInfo = bookInfo;
    }*/

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public char getCheckoutStatus() {
        return checkoutStatus;
    }

    public void setCheckoutStatus(char checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
