package ben.com.interfaces;

import ben.com.beans.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByFirstName(String name);
    User save(User user);
    long countAll();
}
