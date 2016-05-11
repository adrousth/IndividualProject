package library.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Student on 2/11/2016.
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publish_year")
    private String publishYear;
    @Column(name = "edition")
    private String edition;
    @Column(name = "copies")
    private int totalCopies;
    @Column(name = "copies_available")
    private int availableCopies;
    @Column(name = "number_pages")
    private String numberPages;
    @Column(name = "format")
    private String format;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookCopy> bookCopies;
    @ManyToMany
    @JoinTable(name="book_authors", joinColumns=@JoinColumn(name="isbn"),
            inverseJoinColumns=@JoinColumn(name="author_id"))
    private Set<Author> authors;

    public Book() {
        authors = new TreeSet<>();
        bookCopies = new TreeSet<>();
    }

    public void decreaseAvailableCopies() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    public void increaseAvailableCopies() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    public Set<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(Set<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public void addBookCopy(BookCopy copy) {
        bookCopies.add(copy);
    }

    public String getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(String numberPages) {
        this.numberPages = numberPages;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int copies) {
        this.totalCopies = copies;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

}
