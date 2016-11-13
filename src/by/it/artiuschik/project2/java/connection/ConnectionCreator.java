package by.it.artiuschik.project2.java.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    //Памятка. Корректно держать настройки соединения вне кода (!)
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/artiuschik"
                    + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";
    private static volatile Connection connection = null;

    static {
        try { //один раз регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
