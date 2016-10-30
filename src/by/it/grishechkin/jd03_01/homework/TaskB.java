package by.it.grishechkin.jd03_01.homework;

import java.sql.*;

/**
 * Created by Yury on 30.10.2016.
 */
public class TaskB {

    public void getUsers() {

        final String URL_DB = "jdbc:mysql://127.0.0.1:2016/grishechkin"+
                "?useUnicode=true&amp;characterEncoding=UTF-8";
        final String USER_DB = "root";
        final String PASSWORD_DB = "";

        try (
                Connection connetcion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                Statement statement = connetcion.createStatement()
                ){

            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM user INNER JOIN role ON user.FK_Role=role.ID"));
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
                    System.out.print(resultSetMetaData.getColumnLabel(i) + "=" + resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
