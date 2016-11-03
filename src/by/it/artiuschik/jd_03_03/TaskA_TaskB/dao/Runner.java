package by.it.artiuschik.jd_03_03.TaskA_TaskB.dao;

import by.it.artiuschik.jd_03_03.beans.Role;
import by.it.artiuschik.jd_03_03.beans.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0, "Сергеев", "Сергей", 111111, 1, 0, 1);
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();
        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setBalls(100);
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}
