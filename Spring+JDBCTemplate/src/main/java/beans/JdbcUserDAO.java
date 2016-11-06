package beans;

import ben.com.interfaces.UserDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*public class JdbcUserDAO implements UserDAO{

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(User user) {

        String query = "insert into user_list (username, password) values (?, ?)";

        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(query, new Object[] {user.getUsername(), user.getPassword()});
    }

    public User findByUserId(int id) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }
}*/

//Or Use - extends JdbcDaoSupport (Recommended)

public class JdbcUserDAO extends JdbcDaoSupport implements UserDAO{

    public void insert(User user) {

        String query = "insert into user_list (username, password) values (?, ?)";

        getJdbcTemplate().update(query, new Object[] {user.getUsername(), user.getPassword()});
    }

    //1. Querying for Single Row
    public User findByUserId(int id) {  //1.1 Custom RowMapper

        String query = "select * from user_list where id = ?";

        User user = (User) getJdbcTemplate().queryForObject(query, new Object[] {id}, new UserRowMapper());

        return user;
    }

    public User findByUserId2(int id) {  //1.2 BeanPropertyRowMapper

        String query = "select * from user_list where id = ?";

        User user = (User) getJdbcTemplate().queryForObject(query, new Object[] {id}, new BeanPropertyRowMapper(User.class));

        return user;
    }

    //2. Querying for Multiple Rows
    public List<User> findAll() {  //2.1 Map it manually

        String query = "select * from user_list";

        ArrayList<User> user_list = new ArrayList<User>();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);

        for (Map row : rows) {
            User user = new User();
            user.setId((Integer)(row.get("id")));
            user.setUsername((String)(row.get("username")));
            user.setPassword((String)(row.get("password")));
            user_list.add(user);
        }

        return user_list;
    }

    public List<User> findAll2() {  //2.2 BeanPropertyRowMapper

        String query = "select * from user_list";

        List<User> user_list = getJdbcTemplate().query(query, new BeanPropertyRowMapper<User>(User.class));

        return user_list;
    }

    //3. Querying for a Single Value
    public String findUserNameById(int id) {  //3.1 Single column name

        String query = "select username from user_list where id = ?";

        String name = (String) getJdbcTemplate().queryForObject(query, new Object[] {id}, String.class);

        return name;
    }

    public int findTotalUser() {  //3.2 Total number of rows

        String query = "select count(*) from user_list";

        int total = getJdbcTemplate().queryForObject(query, Integer.class);

        return total;
    }
}
