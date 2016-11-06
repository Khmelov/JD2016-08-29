package by.it.grishechkin.jd03_03.TestDAO;

import by.it.grishechkin.jd03_03.DAO.UserDAO;
import by.it.grishechkin.jd03_03.beans.User;

/**
 * Created by Yury on 30.10.2016.
 */
public class UserDAOTest {

    public static void main(String[] args) {

        User user = new User(0, "Alex", "Drobush", "KH56369852", 1);
        UserDAO object = new UserDAO();
        object.getAll();
        user.setID(object.create(user));
        System.out.println("Before update");
        object.read(user.getID());
        user.setFirstName("Drobao");

        object.update(user);
        System.out.println("After update");
        object.read(user.getID());
        object.delete(user);
        System.out.println("After deleting");
        object.getAll();
    }
}
