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

    private static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);
    }

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
        userUniDAO.getAll("").forEach(System.out::println);

        SingletonDAO dao = SingletonDAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0,"Сергей Иванович", "siivanov", "siivanov@mail.ru",2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setLogin("up_siivanov");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }

}

