package by.it.savelyeva.jd_03_03.custom_dao;

import by.it.savelyeva.jd_03_03.SingletonLogger;
import by.it.savelyeva.jd_03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO{

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
        //System.out.println(result+":"+sql);
        return result;
    }
}
