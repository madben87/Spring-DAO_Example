package ben.com.repository;

import ben.com.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByFirstName(String name);
}
