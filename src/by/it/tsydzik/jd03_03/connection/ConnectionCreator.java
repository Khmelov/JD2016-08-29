package by.it.tsydzik.jd03_03.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * @author Eugene Tsydzik
 * @since 30.10.16.
 */
public class ConnectionCreator {
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:3306/tsydzik"
                    + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "tsydzik";
    private static final String PASSWORD_DB = "root";
    private static volatile Connection connection = null;

    static {
        try { //один раз регистрируем драйвер
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    URL_DB, USER_DB, PASSWORD_DB
            );
        return connection;
    }
}
