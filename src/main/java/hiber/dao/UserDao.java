package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   User get(String carModel, int carSeries);
   List<User> listUsers();
}