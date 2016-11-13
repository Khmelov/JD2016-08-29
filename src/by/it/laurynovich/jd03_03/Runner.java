package by.it.laurynovich.jd03_03;

import by.it.laurynovich.jd03_03.beans.Flights;
import by.it.laurynovich.jd03_03.beans.Role;
import by.it.laurynovich.jd03_03.beans.Tickets;
import by.it.laurynovich.jd03_03.beans.User;
import by.it.laurynovich.jd03_03.connection.ConnectionCreator;
import by.it.laurynovich.jd03_03.dao.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {

//        try (
//                Connection connection = ConnectionCreator.getConnection();
//                Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM user,role WHERE user.Role = role.idRole;");
//            while (resultSet.next()) {
//                System.out.printf("Роль: %s,Имя пользователя: %s\n",
//                        resultSet.getString("role.role"), resultSet.getString("user.login"));
//            }
//        }
//
        DAO dao = DAO.getDAO();
//
//        /** User   */
//        System.out.println("Вывод всех пользователей");
//        System.out.println("_________________________________________________________________________________");
//        //read all
//        List<User> users = dao.getUserDAO().getAll("");
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(users.get(i));
//        }
//        System.out.println("_________________________________________________________________________________");
//        User user = new User(1,"user3", "654321", "ivan@gmail.com", "ivanov", "ivan", "NN1223654", 1, 1);
//        dao.getUserDAO().create(user);
//
//        System.out.printf("Создание пользователя \n%s\n", user);
//
//
//
//        //read
//        System.out.println("Чтение \n" + dao.getUserDAO().read(user.getId()));
//        System.out.println("_________________________________________________________________________________");
//        //update
//        user.setLogin("doesntTest");
//        user.setPassword("123qwe");
//        dao.getUserDAO().update(user);
//        System.out.printf("Обновление данных пользователя \n%s\n", user);
//        //read
//        System.out.println("Чтение " +dao.getUserDAO().read(user.getId()));
//        System.out.println("_________________________________________________________________________________");
//
//        //delete
//        System.out.println("Удаление пользователя "+dao.getUserDAO().delete(user));
//
//
//        /** Tickets*/
//        System.out.println("Вывод всех билетов");
//        System.out.println("_________________________________________________________________________________");
//        //read all
//        List<Flights> flight = dao.getFlightsDAO().getAll("");
//        for (int i = 0; i <flight.size()-1 ; i++) {
//            System.out.println(flight.get(i));
//        }
//        System.out.println("_________________________________________________________________________________");


//        try (
//                Connection connection = ConnectionCreator.getConnection();
//                Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM flights ");
//            while (resultSet.next()) {
//                System.out.printf("полет: %s,from_p : %s, to_p : %s\n", resultSet.getString("flights.idFlight"), resultSet.getString("flights.from_p"),
//                        resultSet.getString("flights.to_p"));
//            }
//        }
//
//        //create
//        Flights flights = new Flights(0, "Minsk", "London", "02/08/2017", "02/09/2016");
//        dao.getFlightsDAO().create(flights);
//        System.out.printf("Создание рейса %s\n", flights);
//        //read
//        System.out.println("Чтение " +dao.getFlightsDAO().read(flights.getIdFlight()));
//        System.out.println("_________________________________________________________________________________");
//
//        Flights flights2 = new Flights(0, "Minsk", "Paris", "03/08/2017", "03/09/2016");
//        dao.getFlightsDAO().create(flights2);
//        System.out.printf("Создание рейса %s\n", flights2);
////        //update
//        flights.setDate_return("02/08/2017");
//        dao.getFlightsDAO().update(flights);
//        System.out.printf("Обновление данных рейса \n%s\n", flights);
////     flights   //read
//        System.out.printf("Чтение %s\n", dao.getFlightsDAO().read(flights.getIdFlight()));
//        System.out.println("_________________________________________________________________________________");


//        try (
//                Connection connection = ConnectionCreator.getConnection();
//                Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM tickets");
//            while (resultSet.next()) {
//                System.out.printf("Билет: %s,Имя пользователя: %s\n",
//                        resultSet.getString("tickets.idTicket"), resultSet.getString("tickets.user"));
//            }
//        }

        //create
//        Tickets ticket = new Tickets(0,7,650,33);
//        dao.getTicketsDAO().create(ticket);
//        System.out.printf("create ticket: %s\n", ticket );
//        //read
//        System.out.println(dao.getTicketsDAO().read(ticket.getIdTicket()));
//        System.out.println("_________________________________________________________________________________");
//
//        //update
//        ticket.setPrice(500);
//        dao.getTicketsDAO().update(ticket);
//        System.out.printf("Обновление данных билета \n%s\n", ticket);
//
//        //delete
//        System.out.println("Удаление пользователя "+dao.getTicketsDAO().delete(ticket));
//

     try (
    Connection connection = ConnectionCreator.getConnection();
    Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM role");
        while (resultSet.next()) {
            System.out.printf("IdRole: %s, Role: %s\n",
                    resultSet.getString("role.idRole"), resultSet.getString("role.role"));
        }
    }
//
//    //create
//    Role role = new Role(0,"user");
//    dao.getRoleDAO().create(role);
//    Role role1 = new Role(0,"admin");
//        dao.getRoleDAO().create(role1);
//        System.out.printf("create ticket: %s\n,%s\n", role ,role1);

}
}