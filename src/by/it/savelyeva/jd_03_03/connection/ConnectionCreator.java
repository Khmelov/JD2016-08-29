package by.it.savelyeva.jd_03_03.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/savelyeva"+
                    "?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";
    private static volatile Connection connection = null;

    static {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        return connection;
    }
}

