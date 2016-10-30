package by.it.rudzko.jd03_03;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CN {

    private static final String URL_DB = "jdbc:mysql://127.0.0.1:3306/Olgarudzko"+
                                        "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    static {
        Driver driver;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("error: not register driver");
        }
    }

    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            }
        }
        return connection;
    }
}
