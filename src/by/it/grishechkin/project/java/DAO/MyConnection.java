package by.it.grishechkin.project.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Yury on 30.10.2016.
 */
public class MyConnection {

    private static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/grishechkin"+
            "?useUnicode=true&amp;characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";


    static {
        try { //один раз регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

}
