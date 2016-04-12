package library.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/10/2016.
 */
public class SearchResults {
    private List<Book> books;

    public SearchResults() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
