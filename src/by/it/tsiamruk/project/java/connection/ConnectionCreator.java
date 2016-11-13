package by.it.tsiamruk.project.java.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static final String URL_DB = "jdbc:mysql://127.0.0.1:3306/wtsiamruk?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB ="root";
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
            synchronized (URL_DB){
                if (connection==null || connection.isClosed())
                    connection = DriverManager.getConnection(
                            URL_DB, USER_DB, PASSWORD_DB);
            }
        }
        return connection;
    }
}
