package by.it.rudzko.DataBase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

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
             Statement statement = connection.createStatement();) {
            ArrayList <String> users=new ArrayList<>();
            ArrayList <Integer> rolesNums=new ArrayList<>();
            ResultSet usersSet = statement.executeQuery("select * from users;");
            while (usersSet.next()) {
                users.add(usersSet.getString("Name"));
                rolesNums.add(Integer.valueOf(usersSet.getString("FK_Role")));
            }
            ArrayList <String> roles=new ArrayList<>();
            ArrayList <Integer> id=new ArrayList<>();
            ResultSet rolesSet = statement.executeQuery("select * from roles;");
//            while (rolesSet.next()) {
//                users.add(usersSet.getString("Role"));
//                rolesNums.add(Integer.valueOf(usersSet.getString("ID")));
//            }
//            for (int i=0; i<rolesNums.size(); i++){
//                for (int j=0; j<roles.size(); j++){
//                    if (id.get(j)==rolesNums.get(i)){
//                        System.out.println(users.get(i)+" - "+roles.get(j));
//                    }
//                }
//            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
