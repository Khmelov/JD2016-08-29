package by.it.tsiamruk.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static volatile Connection connection = null;

    static {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            synchronized (ConnectionName.URL_DB){
                if (connection==null || connection.isClosed())
                    connection = DriverManager.getConnection(
                            ConnectionName.URL_DB,
                            ConnectionName.USER_DB,
                            ConnectionName.PASSWORD_DB);
            }
        }
        return connection;
    }
}
