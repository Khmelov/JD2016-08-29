package by.it.artiuschik.project2.java.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Artiuschik Elena
 */
public class ConnectionCreator {
    private static volatile Connection connection = null;

    static {
        try { //один раз регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return connection to database
     * @throws SQLException SQL exception
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    ConnectionSettings.URL_DB, ConnectionSettings.USER_DB, ConnectionSettings.PASSWORD_DB
            );
        return connection;
    }
}
