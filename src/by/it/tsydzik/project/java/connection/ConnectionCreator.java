package by.it.tsydzik.project.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            Class.forName("com.mysql.jdbc.Driver");
//            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
