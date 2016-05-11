package library.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Student on 2/11/2016.
 */
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "author_id")
    private String authorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy="authors")
    private Set<Book> books;

    public Author() {
        books = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
