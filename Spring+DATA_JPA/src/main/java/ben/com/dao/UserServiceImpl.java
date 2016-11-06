package ben.com.dao;

import ben.com.beans.User;
import ben.com.interfaces.UserService;
import ben.com.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    public User findByFirstName(String name) {
        return userRepository.findByFirstName(name);
    }

    public User save(User user) {
        return null;
    }

    public long countAll() {
        return 0;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
