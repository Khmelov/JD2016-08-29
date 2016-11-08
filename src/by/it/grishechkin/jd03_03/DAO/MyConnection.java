package by.it.grishechkin.jd03_03.DAO;

import java.sql.*;

/**
 * Created by Yury on 30.10.2016.
 */
public class MyConnection {

    private static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/grishechkin"+
            "?useUnicode=true&amp;characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

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
