package by.it.grishechkin.jd03_03.DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Yury on 31.10.2016.
 */
public class AbstractDAO {

    public static void readResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    System.out.print(resultSetMetaData.getColumnLabel(i) + "=" + resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
