package by.it.artiuschik.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

class CreateDataBase {
    private static String getRole(String id) throws SQLException {
        String res = null;
        Connection connection = DriverManager.getConnection
                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from roles WHERE ID=" + id);
        if (resultSet.next())
            res = resultSet.getString("Role_name");
        return res;
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection
                    (CN.URL_DB_2, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE IF EXISTS artiuschik");
            statement.executeUpdate("CREATE DATABASE artiuschik CHARACTER SET utf8 COLLATE utf8_german2_ci");
            if (!connection.isClosed())
                System.out.println("БАЗА ДАННЫХ СОЗДАНА");
            connection = DriverManager.getConnection
                    (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            if (!connection.isClosed())
                System.out.println("СОЕДИНЕНИЕ С БАЗОЙ...");
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS users ");
            //создание таблицы пользователей
            String createTableSQL =
                    String.format("CREATE TABLE users (ID INT NULL AUTO_INCREMENT ,Name VARCHAR(100) NOT NULL ,Surname VARCHAR(100) NOT NULL ,Password VARCHAR(100) NOT NULL, Login VARCHAR(100) NOT NULL, Tests_amount INT NOT NULL , Balls INT NOT NULL , FK_ROLE INT NOT NULL , PRIMARY KEY (ID))");
            statement.executeUpdate(createTableSQL);
            //создание таблицы ролей
            createTableSQL =
                    String.format("CREATE TABLE roles (ID INT NULL AUTO_INCREMENT ,Role_name VARCHAR(100) NOT NULL , PRIMARY KEY (ID))");
            statement.executeUpdate(createTableSQL);
            //создание таблицы тестов
            createTableSQL =
                    String.format("CREATE TABLE tests (ID INT NULL AUTO_INCREMENT , Name VARCHAR(100) NOT NULL , Subject VARCHAR(100) NOT NULL , Questions INT NOT NULL , PRIMARY KEY (ID))");
            statement.executeUpdate(createTableSQL);
            //создание таблицы вопросов
            createTableSQL =
                    String.format("CREATE TABLE questions (ID INT NULL AUTO_INCREMENT , Text VARCHAR(100) NOT NULL , Subject VARCHAR(100) NOT NULL , Balls INT NOT NULL , FK_TEST INT NOT NULL, PRIMARY KEY (ID))");
            statement.executeUpdate(createTableSQL);
            //заполнение  users
            statement.executeUpdate("INSERT INTO users (ID, Name, Surname, Password, Login, Tests_amount, Balls, FK_ROLE) VALUES (NULL, 'Иван', 'Иванов', '1232', 'ivaniv97', '3', '30', '1')");
            statement.executeUpdate("INSERT INTO users (ID, Name, Surname, Password, Login, Tests_amount, Balls, FK_ROLE) VALUES (NULL, 'Петр', 'Петров', '1245', 'petrp96', '3', '30', '2')");
            statement.executeUpdate("INSERT INTO users (ID, Name, Surname, Password, Login, Tests_amount, Balls, FK_ROLE) VALUES (NULL, 'Василий', 'Васильев', '6785', 'vasilvas98', '3', '30', '2')");
            //заполнение  roles
            statement.executeUpdate("INSERT INTO roles (ID, Role_name) VALUES (NULL, 'Студент')");
            statement.executeUpdate("INSERT INTO roles (ID, Role_name) VALUES (NULL, 'Тьютор')");
            //заполнение  tests
            statement.executeUpdate("INSERT INTO tests (ID, Name, Subject, Questions) VALUES (NULL, 'Тест 1', 'Физика', '5')");
            statement.executeUpdate("INSERT INTO tests (ID, Name, Subject, Questions) VALUES (NULL, 'Тест 2', 'Математика', '5')");
            statement.executeUpdate("INSERT INTO tests (ID, Name, Subject, Questions) VALUES (NULL, 'Тест 3', 'Химия', '5')");
            //заполнение  questions
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Balls, FK_TEST) VALUES (NULL, 'Вопрос', 'Математика', '5', '1')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Balls, FK_TEST) VALUES (NULL, 'Вопрос', 'Физика', '3', '1')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Balls, FK_TEST) VALUES (NULL, 'Вопрос', 'Химия', '2', '1')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Balls, FK_TEST) VALUES (NULL, 'Вопрос', 'Математика', '1', '1')");
            //вывод users
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("Name") + ", " + resultSet.getString("Surname") + ", " + getRole(resultSet.getString("FK_ROLE"));
                System.out.println(out);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
