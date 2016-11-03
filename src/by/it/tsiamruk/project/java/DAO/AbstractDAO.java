package by.it.tsiamruk.project.java.DAO;


import by.it.tsiamruk.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by waldemar on 30/10/2016.
 */
public class AbstractDAO {
    protected int executeUpdate(String sql){
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.print(""+e.getMessage());
        }
        //System.out.println(result+":"+sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }
}
