package by.it.tsiamruk.jd03_03;


import by.it.tsiamruk.jd03_01.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Created by waldemar on 30/10/2016.
 */
public class AbstractDAO {
    private static Logger log = Logger.getLogger(AbstractDAO.class.getName());
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
           log.info(e.getMessage());
        }
        //System.out.println(result+":"+sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }
}
