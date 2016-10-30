package by.it.emelyanov.jd03_03;

import by.it.emelyanov.jd03_03.beans.Orders;
import by.it.emelyanov.jd03_03.beans.Rooms;
import by.it.emelyanov.jd03_03.beans.Users;
import by.it.emelyanov.jd03_03.connection.ConnectionCreator;
import by.it.emelyanov.jd03_03.dao.DAO;
import by.it.emelyanov.jd03_03.dao.RoomsDAO;

import java.sql.*;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users, roles WHERE users.FK_Role = roles.ID;");
            while (resultSet.next()) {
                System.out.printf("Роль: %s,Имя пользователя: %s\n",
                        resultSet.getString("roles.Name"), resultSet.getString("users.Login"));
            }
        }

        DAO dao = DAO.getDAO();

        /** Users*/
        System.out.println("Вывод всех пользователей");
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
        //read all
        List<Users> users = dao.getUsersDAO().getAll("");
        for (int i = 0; i <users.size()-1 ; i++) {
            System.out.println(users.get(i));
        }
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
        //create
        Users user = new Users(5, "Vaska", "kot123", "vaska_kot@gmail.com", 2);
        dao.getUsersDAO().create(user);
        System.out.printf("Создание пользователя %s\n", user);
        //read
        System.out.println("Чтение " +dao.getUsersDAO().read(user.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
        //update
        user.setLogin("doesntTest");
        user.setPassword("123qwe");
        dao.getUsersDAO().update(user);
        System.out.printf("Обновление данных пользователя %s\n", user);
        //read
        System.out.println("Чтение " +dao.getUsersDAO().read(user.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //delete
        System.out.println("Удаление пользователя "+dao.getUsersDAO().delete(user));
        //read
        System.out.println("Чтение " +dao.getUsersDAO().read(user.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");



        /** Rooms*/
        System.out.println("Вывод всех номеров");
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
        //read all
        List<Rooms> rooms = dao.getRoomsDAO().getAll("");
        for (int i = 0; i <rooms.size()-1 ; i++) {
            System.out.println(rooms.get(i));
        }
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //create
        Rooms room = new Rooms(5, 6, 66, 500f, 4);
        dao.getRoomsDAO().create(room);
        System.out.printf("Создание номера %s\n", room);
        //read
        System.out.println("Чтение " +dao.getRoomsDAO().read(room.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //update
        room.setRoom_Number(34);
        room.setfK_Type(3);
        dao.getRoomsDAO().update(room);
        System.out.printf("Обновление данных номера %s\n", room);
        //read
        System.out.println("Чтение " +dao.getRoomsDAO().read(room.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //delete
        System.out.println("Удаление номера "+dao.getRoomsDAO().delete(room));
        //read
        System.out.println("Чтение " +dao.getRoomsDAO().read(room.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        /** Orders*/
        System.out.println("Вывод всех заказов");
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
        //read all
        List<Orders> orders = dao.getOrdersDAO().getAll("");
        for (int i = 0; i <orders.size()-1 ; i++) {
            System.out.println(orders.get(i));
        }
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //create
        Orders order = new Orders(11, 2, 3, "2016-10-30", "2016-10-31", RoomsDAO.getCost(3));
        dao.getOrdersDAO().create(order);
        System.out.printf("Создание заказа %s\n", order);
        //read
        System.out.println("Чтение " +dao.getOrdersDAO().read(order.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //update
        order.setReturn_Date("2016-11-01");
        dao.getOrdersDAO().update(order);
        System.out.printf("Обновление заказа %s\n", order);
        //read
        System.out.println("Чтение " +dao.getOrdersDAO().read(order.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //delete
        System.out.println("Удаление заказа "+dao.getOrdersDAO().delete(order));
        //read
        System.out.println("Чтение " +dao.getOrdersDAO().read(order.getId()));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

    }
}
