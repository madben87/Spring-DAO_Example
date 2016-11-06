package ben.com.entity.dao;

import ben.com.entity.Books;

import java.util.List;

public interface BookDao {

    List findBooks();
    List findBookWithAuthors();
    Books findBookWithAuthorById(long id);
    Books findBookWithAuthorByName(String name);
    Books save(Books book);
    void delete(Books book);
}
