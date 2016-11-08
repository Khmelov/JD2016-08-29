package by.it.vashukevich.jd03_03;

import by.it.vashukevich.jd03_03.beans.Role;
import by.it.vashukevich.jd03_03.beans.Users;
import by.it.vashukevich.jd03_03.dao.DAO;
import by.it.vashukevich.jd03_03.dao.UsersDAO;

import java.sql.SQLException;
import java.util.List;

public class Main {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<Users> users=new UsersDAO().getAll("");
        for (Users each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        Users user = new Users(0,"Петров", "240610", "petrovich@mail.ru",2);
        //добавим пользователя
        if (dao.users.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.users.getAll("WHERE Id>2").get(0);
        user.setLogin("петюха");
        if (dao.users.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.users.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}

