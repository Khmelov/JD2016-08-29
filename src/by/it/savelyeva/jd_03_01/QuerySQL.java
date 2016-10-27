package by.it.savelyeva.jd_03_01;

import java.sql.*;
import java.sql.DriverManager;
/**
 * Created by nato on 10/25/16.
 */
public class QuerySQL {

    public static void runQuery(String sql) {
        try (java.sql.Connection connection = DriverManager.getConnection(Config.URL_DB, Config.USER_DB, Config.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runQuery(String[] sqls) {
        try (java.sql.Connection connection = DriverManager.getConnection(Config.URL_DB, Config.USER_DB, Config.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            for (String sql: sqls) {
                System.out.println(sql);
                statement.executeUpdate(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runQueryAndGetResults(String sql) {
        try (java.sql.Connection connection = DriverManager.getConnection(Config.URL_DB, Config.USER_DB, Config.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metadata = resultSet.getMetaData();
            int colsCount = metadata.getColumnCount();
            while (resultSet.next()) {
                for (int i=1; i<=colsCount; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}