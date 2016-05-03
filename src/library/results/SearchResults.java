package library.results;

import library.entities.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alex on 4/10/2016.
 */
public class SearchResults extends Results {
    private List<Book> books;
    private int count;

    public SearchResults() {
        super();
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        books.sort(Comparator.nullsFirst(null));
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}