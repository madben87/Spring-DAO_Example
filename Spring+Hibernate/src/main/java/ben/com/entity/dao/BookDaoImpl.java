package ben.com.entity.dao;

import ben.com.entity.Author;
import ben.com.entity.Books;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("bookDao")
public class BookDaoImpl implements BookDao{

    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Books> findBooks() {
        return sessionFactory.getCurrentSession().createQuery("from ben.com.entity.Books").list();
    }

    public List findBookWithAuthors() {
        return sessionFactory.getCurrentSession().getNamedQuery("booksWithAuthors").list();
    }

    public Books findBookWithAuthorById(long id) {
        return (Books) sessionFactory.getCurrentSession().getNamedQuery("booksWithAuthorsById").setParameter("id", id).uniqueResult();
    }

    public Books findBookWithAuthorByName(String name) {
        return (Books) sessionFactory.getCurrentSession().getNamedQuery("booksWithAuthorsByName").setParameter("name", name).uniqueResult();
    }

    public Books save(Books book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
        return book;
    }

    public void delete(Books book) {
        sessionFactory.getCurrentSession().delete(book);
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
