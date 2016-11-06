package ben.com.interfaces;

import beans.User;

import java.util.List;

public interface UserDAO {

    public void insert(User user);
    public User findByUserId(int id);
    public User findByUserId2(int id);
    public List<User> findAll();
    public List<User> findAll2();
    public String findUserNameById(int id);
    public int findTotalUser();
}
