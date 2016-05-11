package library.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Student on 2/11/2016.
 */
@Entity
@Table(name = "book_copies")
public class BookCopy implements Serializable{
    @Id
    @Column(name = "isbn")
    private String isbn;
    @Id
    @Column(name = "book_number")
    private int bookNumber;
    @Column(name = "book_condition")
    private String bookCondition;
    @Column(name = "checkout_status")
    private char checkoutStatus; // char use single quotes - 'A' not "A"

    @ManyToOne
    @JoinColumn(name = "isbn", insertable = false, updatable = false )
    private Book book;

    @OneToMany(mappedBy = "bookCopy")
    private Set<Rental> rentals;

    public BookCopy() {
        rentals = new TreeSet<>();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

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

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }
}
