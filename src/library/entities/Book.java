package library.entities;

import java.util.*;

/**
 * Created by Student on 2/11/2016.
 */
public class Book {
    private int isbn;
    private String title;
    private String publisher;
    private int publishYear;
    private String edition;
    private int copies;
    private int availableCopies;
    private Set<Author> authors;
    private Set<Category> categories;

    public Book() {

    }
    public Book(int isbn, String title, String publisher, int publishYear, String edition, int copies) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.edition = edition;
        this.copies = copies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
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

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

}
