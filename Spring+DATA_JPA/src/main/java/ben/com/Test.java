package ben.com;

import ben.com.beans.User;
import ben.com.interfaces.UserService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("Start_JPA.xml");

        UserService userService = context.getBean("userService", UserService.class);

        List<User> list = userService.findAll();

        for (User user : list) {
            System.out.println(user);
        }

        System.out.println(userService.findById(1L));

        System.out.println(userService.findByFirstName("Ben"));
    }
}
