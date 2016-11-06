package ben.com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name = "booksWithAuthors", query = "select distinct b from Books b left join fetch b.authorSet a"),
        @NamedQuery(name = "booksWithAuthorsById", query = "select distinct b from Books b left join fetch b.authorSet a where b.id = :id"),
        @NamedQuery(name = "booksWithAuthorsByName", query = "select distinct b from Books b left join fetch b.authorSet a where b.name_book = :name")
})

public class Books implements Serializable{

    private long id;
    private String Name_book;
    private String Year_publishing;
    private Set<Author> authorSet = new HashSet<Author>();

    public Books() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "Name_book")
    public String getName_book() {
        return Name_book;
    }

    public void setName_book(String name_book) {
        Name_book = name_book;
    }

    @Column(name = "Year_publishing")
    public String getYear_publishing() {
        return Year_publishing;
    }

    public void setYear_publishing(String year_publishing) {
        Year_publishing = year_publishing;
    }

    @ManyToMany(cascade=CascadeType.ALL)//(fetch=FetchType. EAGER) - Самый простой но ресурсоемкий способ, выборка всех данных делается сразу при создании а не при целевом запросе
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author"))
    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public void addAuthor(Author author) {
        authorSet.add(author);
    }

    public String toString() {
        return String.format("Name book : %s %n" + "Year publishing : %s", getName_book(), getYear_publishing());
    }
}
