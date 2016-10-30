package by.it.senchenko.jd03_03.dao;

import by.it.senchenko.jd03_03.beans.Role;
import by.it.senchenko.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.List;

public class Run {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        SingletonDAO dao = SingletonDAO.getSingletonDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0,"Денис Васильевич", "senchenko", "senchenko@gmail.com",2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email senchenko@gmail.com
        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setLogin("up_senchenko");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}
