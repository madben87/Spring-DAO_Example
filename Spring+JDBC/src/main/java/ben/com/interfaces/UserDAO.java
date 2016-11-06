package ben.com.interfaces;

import beans.User;

import java.util.List;

public interface UserDAO {

    public void insert(User user);
    public User findByUserId(int id);
    public List<User> findAll();
}
