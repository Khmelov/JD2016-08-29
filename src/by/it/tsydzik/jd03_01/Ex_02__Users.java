package by.it.tsydzik.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Ex_02__Users {


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
             Statement statement = connection.createStatement();) {
            //вставляем пользователей
            statement.executeUpdate(
                    "INSERT INTO users (ID, Login, Pass, Email, FK_Role)\n" +
                            "VALUES (NULL, 'admin', 'admin', 'admin@mail.ru', '1');"
            );
            statement.executeUpdate(
                    "insert into users(Login,Pass,Email,FK_ROLE)" +
                            " values('usertest','usertest','usertest@mail.ru',2);"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
