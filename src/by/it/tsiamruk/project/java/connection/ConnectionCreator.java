package by.it.tsiamruk.project.java.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static volatile Connection connection = null;

    static {
        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
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
