package library.entities;

/**
 * Created by Alex on 4/27/2016.
 */
public class SimpleBook {
    private String isbn;
    private int bookNumber;
    private String title;
    private String edition;
    private String format;

    public SimpleBook() {

    }

    public SimpleBook(Book book) {
        isbn = book.getIsbn();
        title = book.getTitle();
        edition = book.getEdition();
        format = book.getFormat();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
