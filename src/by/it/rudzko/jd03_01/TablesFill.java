package by.it.rudzko.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.Locale;

public class TablesFill {


    public static void main(String[ ] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);

            Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "INSERT INTO roles (ID, Role) " +
                            "VALUES (NULL, 'Admin'), (NULL, 'Reader') ")
            );
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "INSERT INTO users (ID, Name, FK_Role, BirthDate, Sex) " +
                            "VALUES (NULL, 'First_Admin', '1', '1970', 'M'), (NULL, 'Ivanova', '2', '2000', 'F') ")
            );
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "INSERT INTO readership (ID, Audience) " +
                            "VALUES (NULL, 'Adults'), (NULL, 'Men'), (NULL, 'Women'), (NULL, 'Teens'), (NULL, 'Children') ")
            );
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "INSERT INTO periodicals (ID, Title, SubIndex, FK_Readership, FK_Added) " +
                            "VALUES (NULL, 'Дзеяслоў', '74813', '1', '1'), (NULL, 'Алеся', '74995', '3', '1'), " +
                            "(NULL, 'Беларусь Сегодня', '63889', '1', '1'), (NULL, 'Прессбол', '63115', '2', '1'), " +
                            "(NULL, 'Маладосць', '74957', '4', '1') ")
            );
            statement.executeUpdate(
                    String.format(Locale.ENGLISH, "INSERT INTO subscription (ID, FK_Subscriber, FK_Periodical) " +
                            "VALUES (NULL, '2', '2'), (NULL, '2', '5') ")
            );
        } catch (SQLException e) {
            System.out.println("No connection.\n"+e.getMessage());
        }

        System.out.println("Tables filled.");

    }
}
