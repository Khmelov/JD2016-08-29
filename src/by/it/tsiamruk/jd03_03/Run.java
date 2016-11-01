package by.it.tsiamruk.jd03_03;

import by.it.tsiamruk.jd03_03.DAO.SingletonDAO;
import by.it.tsiamruk.jd03_03.DAO.UserDAO;
import by.it.tsiamruk.jd03_03.beans.Role;
import by.it.tsiamruk.jd03_03.beans.User;
import by.it.tsiamruk.jd03_03.unversalDAO.UniversalDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by waldemar on 01/11/2016.
 */
public class Run {

    public static void main(String[] args) throws SQLException {
        UniversalDAO<User> userUniDAO = new UniversalDAO<>(new User(),"users");
        User usertest=new User(0,"ТестовыйЛогин","ТестовыйПароль","Тестовый Email",1);
        userUniDAO.create(usertest);
        System.out.println("Создан: " + usertest);

        userUniDAO.update(usertest);
        usertest.setEmail("Новый Email");
        System.out.println("Обновлен: "+usertest);

        if (userUniDAO.delete(usertest))
            System.out.println("Удален: " + usertest);

        System.out.println("\nСписок всех записей:");
        for (User current: userUniDAO.getAll("")) {
            System.out.println(current);
        }

    }
}
