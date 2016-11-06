package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.SingletonLogger;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO {

    public static SingletonLogger logger = SingletonLogger.getInstance();

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
            logger.log(e.getMessage() + ": " + sql);
        }
        //System.out.println(result+":"+sql);
        return result;
    }
}
