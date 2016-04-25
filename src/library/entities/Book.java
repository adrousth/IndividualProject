package library.entities;

import java.util.*;

/**
 * Created by Student on 2/11/2016.
 */
public class Book {
    private String isbn;
    private String title;
    private String publisher;
    private String publishYear;
    private String edition;
    private int totalCopies;
    private int availableCopies;
    private String numberPages;
    private String format;
    private String description;
    private Set<BookCopy> bookCopies;
    private Set<Author> authors;
    private Set<Category> categories;

    public Book() {
        authors = new HashSet<>();
        categories = new HashSet<>();
        bookCopies = new HashSet<>();
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

}
