package by.it.artiuschik.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.Statement;

class DeleteDataBase {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection
                    (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            if (!connection.isClosed())
                System.out.println("СОЕДИНЕНИЕ С БАЗОЙ ДАННЫХ...");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS users ");
            statement.executeUpdate("DROP TABLE IF EXISTS roles ");
            statement.executeUpdate("DROP TABLE IF EXISTS questions ");
            statement.executeUpdate("DROP TABLE IF EXISTS tests ");
            connection=DriverManager.getConnection
                    (CN.URL_DB_2, CN.USER_DB, CN.PASSWORD_DB);
            statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE IF EXISTS artiuschik");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
