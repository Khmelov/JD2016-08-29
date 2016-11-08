package by.it.sukora.PROJECT.java.custom_dao;

import by.it.sukora.PROJECT.java.connection.ConnectionCreator;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO {
    //общая команда для Create Update Delete
    protected int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            SingletonLogger logger = SingletonLogger.getInstance();

            logger.log(e.getMessage() + "\t" + sql);
            System.out.println(e.getMessage());
        }
        //System.out.println(result+":"+sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }
}
