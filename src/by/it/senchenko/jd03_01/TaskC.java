package by.it.senchenko.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskC {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE DATABASE testDatabase"); //создаем БД
            statement.execute("CREATE TABLE testDatabase.ad (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Name` text NOT NULL,\n" +
                    "  `Autor` text NOT NULL,\n" +
                    "  `Date` text NOT NULL,\n" +
                    "  `FK_User` int(11) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("INSERT INTO testDatabase.ad (`ID`, `Name`, `Autor`, `Date`, `FK_User`) VALUES\n" +
                    "(1, 'Name1', 'Autor1', 'Date1', 1),\n" +
                    "(2, 'Name2', 'Autor2', 'Date2', 2);");
            statement.execute("CREATE TABLE testDatabase.role (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Name` text NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("INSERT INTO testDatabase.role (`ID`, `Name`) VALUES\n" +
                    "(1, 'admin'),\n" +
                    "(2, 'user');");
            statement.execute("CREATE TABLE testDatabase.users (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Login` varchar(100) NOT NULL,\n" +
                    "  `Password` varchar(100) NOT NULL,\n" +
                    "  `Email` varchar(100) NOT NULL,\n" +
                    "  `FK_Role` int(11) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            statement.execute("INSERT INTO testDatabase.users (`ID`, `Login`, `Password`, `Email`, `FK_Role`) VALUES\n" +
                    "(1, 'admin1', 'admin1Pass', 'admin1@mail.ru', 1),\n" +
                    "(2, 'client1', 'client1Pass', 'client1@mail.ru', 2);");
            //statement.execute("DROP DATABASE testDatabase"); //удаляем БД
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}