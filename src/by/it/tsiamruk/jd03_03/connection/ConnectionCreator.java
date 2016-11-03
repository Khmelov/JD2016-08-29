package by.it.tsiamruk.jd03_03.connection;

import by.it.tsiamruk.jd03_03.Logger;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static Logger logger;

    private static volatile Connection connection = null;

    static {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            logger.writeInLog(e.getMessage() + e.getSQLState(),e);
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
