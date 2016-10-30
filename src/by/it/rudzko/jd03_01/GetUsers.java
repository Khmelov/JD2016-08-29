package by.it.rudzko.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetUsers {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            Map<String, Integer> users=new HashMap<>();
            ResultSet usersSet = statement.executeQuery("select * from users;");
            while (usersSet.next()) {
                users.put(usersSet.getString("Name"), usersSet.getInt("FK_Role"));
            }
            Map<Integer, String> roles=new HashMap<>();
            ResultSet rolesSet = statement.executeQuery("select * from roles;");
            while (rolesSet.next()) {
                roles.put(rolesSet.getInt("ID"), rolesSet.getString("Role"));
            }
            for (Map.Entry<String, Integer> x : users.entrySet()) {
                if (roles.containsKey(x.getValue())) {
                    System.out.println(x.getKey() + " - " + roles.get(x.getValue()));
                }
            }
            System.out.println("There are "+users.size()+" users and "+roles.size()+" roles for them in database.");

        } catch (SQLException e) {
            System.out.println("No connection.\n"+e.getMessage());
        }
    }
}
