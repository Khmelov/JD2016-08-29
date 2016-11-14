package by.it.laurynovich.jd03_03.dao;

import by.it.laurynovich.jd03_03.connection.ConnectionCreator;

import java.sql.*;

public abstract class AbstractDAO {
    protected int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
                System.out.println("test insert "+result);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        System.out.println(result+":"+sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }
}

