package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car carTestGet = new Car("a", 100);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", carTestGet));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("b", 200)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("c", 300)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("d", 400)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car id= " + user.getCar().getId());
            System.out.println("Car model= " + user.getCar().getModel());
            System.out.println("Car series= " + user.getCar().getSeries());
            System.out.println();
        }

        User userTestGet = userService.get(carTestGet.getModel(), carTestGet.getSeries());
        System.out.println("Id = " + userTestGet.getId());
        System.out.println("First Name = " + userTestGet.getFirstName());
        System.out.println("Last Name = " + userTestGet.getLastName());
        System.out.println("Email = " + userTestGet.getEmail());
        System.out.println("Car id= " + userTestGet.getCar().getId());
        System.out.println("Car model= " + userTestGet.getCar().getModel());
        System.out.println("Car series= " + userTestGet.getCar().getSeries());
        System.out.println();

        context.close();
    }
}
