package ben.com.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Author")
@NamedQueries({
        @NamedQuery(name = "findAllAuthor", query = "select a from Author a"),
        @NamedQuery(name = "authorsWithBooks", query = "select distinct a from Author a left join fetch a.booksSet b"),
        @NamedQuery(name = "authorsWithBooksById", query = "select distinct a from Author a left join fetch a.booksSet b where a.id = :id"),
        @NamedQuery(name = "authorsWithBooksByName", query = "select distinct a from Author a left join fetch a.booksSet b where a.name = :name")
})

public class Author implements Serializable{

    private long id;
    private String Name;
    private String Surname;
    private Date Date_birth;
    private Set<Books> booksSet = new HashSet<Books>();

    public Author() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(name = "Surname")
    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Date_birth")
    public Date getDate_birth() {
        return Date_birth;
    }

    public void setDate_birth(Date date_birth) {
        Date_birth = date_birth;
    }

    @ManyToMany
    @JoinTable(name = "Books_Authors",
            joinColumns = @JoinColumn(name = "id_author"),
            inverseJoinColumns = @JoinColumn(name = "id_book"))
    public Set<Books> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<Books> booksSet) {
        this.booksSet = booksSet;
    }

    public void resToString() {
        System.out.printf("Author name : %s %s %nDate birth : %s", getName(), getSurname(), getDate_birth());
    }

    public String toString() {
        return String.format("Author name : %s %s %nDate birth : %s", getName(), getSurname(), getDate_birth());
    }
}
