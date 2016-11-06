import beans.User;
import ben.com.interfaces.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Start.xml");

        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        User user = new User();
        user.setUsername("WarLord");
        user.setPassword("666");
        //userDAO.insert(user);

        User user1 = userDAO.findByUserId(1);
        User user4 = userDAO.findByUserId(4);
        User user5 = userDAO.findByUserId(5);
        User user6 = userDAO.findByUserId2(5);

        System.out.println(user1.getUsername() + " " + user1.getPassword());
        System.out.println(user4.getUsername() + " " + user4.getPassword());
        System.out.println(user5.getUsername() + " " + user5.getPassword());
        System.out.println(user6.getUsername() + " " + user6.getPassword());

        for (User x : userDAO.findAll()) {
            System.out.println(x.getId() + " " + x.getUsername() + " " + x.getPassword());
        }

        for (User x : userDAO.findAll2()) {
            System.out.println(x.getId() + " " + x.getUsername() + " " + x.getPassword());
        }

        System.out.println(userDAO.findUserNameById(1));

        System.out.println(userDAO.findTotalUser());
    }
}
