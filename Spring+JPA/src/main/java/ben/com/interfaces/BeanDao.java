package ben.com.interfaces;

import ben.com.beans.Books;

import java.util.List;

public interface BeanDao {

    List findAll();
    List findListWith();
    Object findBeanById(long id);
    Object findBeanByName(String name);
    Object save(Books book);
    void delete(Books book);
}
