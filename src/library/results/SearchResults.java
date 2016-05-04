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
    private int maxPages;
    private int halfMaxPages;
    private int currentPage;
    private int booksPerPage;
    private String searchTerm;
    private String searchValue;
    private int numberOfPages;
    private String params;

    public SearchResults() {
        super();
        books = new ArrayList<>();
        booksPerPage = 20;
        maxPages = 10;
    }


    public int getBooksPerPage() {
        return booksPerPage;
    }

    public void setBooksPerPage(int booksPerPage) {
        this.booksPerPage = booksPerPage;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getMaxPages() {
        return maxPages;
    }

    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }

    public int getHalfMaxPages() {
        return halfMaxPages;
    }

    public void setHalfMaxPages(int halfMaxPages) {
        this.halfMaxPages = halfMaxPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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
