package ben.com.dao;

import ben.com.beans.Author;
import ben.com.beans.Books;
import ben.com.interfaces.BeanDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Scanner;

@Service("authorDao")
@Transactional
@Repository
public class AuthorDaoImpl implements BeanDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List findAll() {
        return em.createNamedQuery("findAllAuthor", Author.class).getResultList();
    }

    public List findListWith() {
        return em.createNamedQuery("authorsWithBooks", Author.class).getResultList();
    }

    public Author findBeanById(long id) {
        return em.createNamedQuery("authorsWithBooksById", Author.class).setParameter("id", id).getSingleResult();
    }

    public Author findBeanByName(String name) {
        return em.createNamedQuery("authorsWithBooksByName", Author.class).setParameter("name", name).getSingleResult();
    }

    public Books save(Books book) {
        return null;
    }

    public void delete(Books book) {

    }
}
