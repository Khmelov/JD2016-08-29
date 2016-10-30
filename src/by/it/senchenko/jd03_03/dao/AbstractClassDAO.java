package by.it.senchenko.jd03_03.dao;

import by.it.senchenko.jd03_03.CN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractClassDAO {
    protected int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {}
        return result;
    }
}
