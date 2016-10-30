package by.it.emelyanov.jd03_02;

import by.it.emelyanov.jd03_02.crud.*;

import java.sql.SQLException;
import java.util.Locale;

public class CRUDTester {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en_EN"));

        /** CRUD тест Users*/
        Users user = new Users(66, "testLogin", "testPass", "test@gmail.com", 2);
        UsersCRUD userCRUD = new UsersCRUD();
        try {
            user = userCRUD.create(user);
            user = userCRUD.read(user.getId());
            System.out.println(user);
            user.setLogin("doesntTest");
            user.setPassword("123qwe");
            user = userCRUD.update(user);
            System.out.println(user);
            System.out.print("Состояние удаления ");
            System.out.println(userCRUD.delete(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        /** CRUD тест Orders*/
        Orders order = new Orders(4, 2, 3, "26-10-2017", "27-10-2017", 567.2f);
        OrdersCRUD orderCRUD = new OrdersCRUD();
        try {
            order = orderCRUD.create(order);
            order = orderCRUD.read(order.getId());
            System.out.println(order);
            order.setfK_Room(55);
            order.setReturn_Date("28-10-2017");
            order = orderCRUD.update(order);
            System.out.println(order);
            System.out.print("Состояние удаления ");
            System.out.println(orderCRUD.delete(order));

        } catch (SQLException e) {
            e.printStackTrace();
        }


        /** CRUD тест Rooms*/
        Rooms room = new Rooms(6,3,35,578.5f,4);
        RoomsCRUD roomCRUD = new RoomsCRUD();
        try {
            room = roomCRUD.create(room);
            room = roomCRUD.read(room.getId());
            System.out.println(room);
            room.setRoom_Number(34);
            room.setfK_Type(3);
            room=roomCRUD.update(room);
            System.out.println(room);
            System.out.print("Состояние удаления ");
            System.out.println(roomCRUD.delete(room));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        /** Создание таблиц и их связей в БД*/
        try {
            CreateInsertAndDrop.createDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /** Заполение наблиц в БД*/
        try {
            CreateInsertAndDrop.insertToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /** Удаление таблиз из БД*/
        try {
            CreateInsertAndDrop.drobDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /** Поиск по роли */
        try {
            SearchByRole.searchId("Client");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
