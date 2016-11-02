package by.it.rudzko.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.Locale;


public class TablesDelete {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "DROP TABLE Subscription, Periodicals, Readership, Users, Roles")
            );
        } catch (SQLException e) {
            System.out.println("No connection.\n"+e.getMessage());

        }

        System.out.println("Tables removed.");

    }
}
