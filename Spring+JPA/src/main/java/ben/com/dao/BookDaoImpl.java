package ben.com.dao;

import ben.com.beans.Author;
import ben.com.beans.Books;
import ben.com.interfaces.BeanDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Scanner;

@Service("bookDao")
@Transactional
@Repository
public class BookDaoImpl implements BeanDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List findAll() {
        return em.createNamedQuery("findAllBooks", Books.class).getResultList();
    }

    public List findListWith() {
        return em.createNamedQuery("booksWithAuthors", Books.class).getResultList();
    }

    public Books findBeanById(long id) {
        return em.createNamedQuery("booksWithAuthorsById", Books.class).setParameter("id", id).getSingleResult();
    }

    public Books findBeanByName(String name) {
        return em.createNamedQuery("booksWithAuthorsByName", Books.class).setParameter("name", name).getSingleResult();
    }

    public Books save(Books book) {

        if (book.getId() == 0) {
            em.persist(book);
        }else {
            em.merge(book);
        }
        return book;
    }

    public void delete(Books book) {
        Books mergedBook = em.merge(book);
        em.remove(mergedBook);
    }
}
