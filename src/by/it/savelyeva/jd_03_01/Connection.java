package by.it.savelyeva.jd_03_01;

import java.sql.DriverManager;

/**
 * Created by nato on 10/25/16.
 */
public class Connection {
    public static void main(String[] args) {
        try (java.sql.Connection connection =
                     DriverManager.getConnection
                             (Config.URL_DB, Config.USER_DB, Config.PASSWORD_DB);) {
            if (!connection.isClosed())
                System.out.println("Connected!");
            connection.close();
            if (connection.isClosed())
                System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
