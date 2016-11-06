import beans.User;
import ben.com.interfaces.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Start.xml");

        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        User user = new User();
        user.setUsername("mkyong");
        user.setPassword("76675");
        //userDAO.insert(user);

        User user1 = userDAO.findByUserId(1);
        User user4 = userDAO.findByUserId(4);

        System.out.println(user1.getUsername() + " " + user1.getPassword());
        System.out.println(user4.getUsername() + " " + user4.getPassword());

        for (User x : userDAO.findAll()) {
            System.out.println(x.getId() + " " + x.getUsername() + " " + x.getPassword());
        }
    }
}
