package by.it.vashukevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Check_Connection {
    public static void main(String[] args) {
        try {
            Driver driver=new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection=DriverManager.getConnection
                (CN.UR_DB,CN.USER_DB,CN.PASSWORD_DB);){
            if(!connection.isClosed())
                System.out.println("Соединение установлено");
            connection.close();
            if(connection.isClosed())
                System.out.println("Соединение прервано");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
