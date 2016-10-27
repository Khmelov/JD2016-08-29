package by.it.emelyanov.jd03_02;


import by.it.emelyanov.jd03_02.crud.ConnectionCreator;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class CreateAndDrop {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }try (Connection connection =
                     DriverManager.getConnection
                             (ConnectionCreator.URL_DB, ConnectionCreator.USER_DB, ConnectionCreator.PASSWORD_DB);
              Statement statement = connection.createStatement()) {

            /** Создание БД */
            statement.execute("CREATE DATABASE emelyanov");

            /** Удаление БД */
            //statement.execute("DROP DATABASE emelyanov");

            /** Создание таблицы users */
            statement.execute("CREATE TABLE emelyanov.users (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Login` varchar(100) NOT NULL,\n" +
                    "  `Password` varchar(100) NOT NULL,\n" +
                    "  `Email` varchar(100) NOT NULL,\n" +
                    "  `FK_Role` int(11) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            /** Создание таблицы roles */
            statement.execute("CREATE TABLE emelyanov.roles (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Name` varchar(100) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            /** Создание таблицы rooms */
            statement.execute("CREATE TABLE emelyanov.rooms (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Floor` int(11) NOT NULL,\n" +
                    "  `Room_Number` int(11) NOT NULL,\n" +
                    "  `Cost` decimal(10,2) NOT NULL,\n" +
                    "  `FK_Type` int(11) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            /** Создание таблицы types */
            statement.execute("CREATE TABLE emelyanov.types (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Room_Type` varchar(100) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            /** Создание таблицы orders */
            statement.execute("CREATE TABLE emelyanov.orders (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `FK_User` int(11) NOT NULL,\n" +
                    "  `FK_Room` int(11) NOT NULL,\n" +
                    "  `Arrive_Date` date NOT NULL,\n" +
                    "  `Return_Date` date NOT NULL,\n" +
                    "  `Bill` decimal(10,2) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            /** Добавление данных в orders */
            statement.execute("INSERT INTO emelyanov.orders (`ID`, `FK_User`, `FK_Room`, `Arrive_Date`, `Return_Date`, `Bill`) VALUES\n" +
                    "(1, 2, 4, '2016-10-26', '2016-10-27', '124.00'),\n" +
                    "(2, 3, 3, '2016-10-28', '2016-10-29', '532.00');");

            /** Добавление данных в users */
            statement.execute("INSERT INTO emelyanov.users (`ID`, `Login`, `Password`, `Email`, `FK_Role`) VALUES\n" +
                    "(1, 'admin', 'admin123', 'admin@gmail.com', 1),\n" +
                    "(2, 'client', 'client321', 'client@gmail.com', 2),\n" +
                    "(3, 'client2', 'client2', 'client2@gmail.com', 2),\n" +
                    "(4, 'client3', 'client3', 'client3@gmail.com', 2);");

            /** Добавление данных в roles */
            statement.execute("INSERT INTO emelyanov.roles (`ID`, `Name`) VALUES\n" +
                    "(1, 'Administrator'),\n" +
                    "(2, 'Client');");

            /** Добавление данных в rooms */
            statement.execute("INSERT INTO emelyanov.rooms (`ID`, `Floor`, `Room_Number`, `Cost`, `FK_Type`) VALUES\n" +
                    "(1, 1, 1, '85.20', 1),\n" +
                    "(2, 2, 20, '104.80', 2),\n" +
                    "(3, 3, 31, '184.67', 3),\n" +
                    "(4, 4, 45, '256.22', 4);");

            /** Добавление данных в types */
            statement.execute("INSERT INTO emelyanov.types (`ID`, `Room_Type`) VALUES\n" +
                    "(1, 'Single Room'),\n" +
                    "(2, 'Double Room'),\n" +
                    "(3, 'Twin Room'),\n" +
                    "(4, 'Double Double Room');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
