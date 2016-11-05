package by.it.vashukevich.jd03_03;

import by.it.vashukevich.jd03_03.beans.Users;

import java.sql.SQLException;

public class UniversalMain {
    public static void main(String[] args) throws SQLException {
        UniversalDAO<Users> dao=new UniversalDAO<>(new Users(),"users");
        Users user=new Users(0,"ТестовыйЛогин","ТестовыйПароль","Тестовый Email",1);

        dao.create(user);
        System.out.println("Создан: " + user);

        dao.update(user);
        user.setEmail("Новый Email");
        System.out.println("Обновлен: "+user);

        if (dao.delete(user))
            System.out.println("Удален: " + user);

        System.out.println("\nСписок всех записей:");
        for (Users current: dao.getAll("")) {
            System.out.println(current);
        }
    }
}
