package by.it.artiuschik.jd_03_02.utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRoleConnector {
    public static String getRole(int id,Connection connection) throws SQLException {
        String role = null;
        String sql = String.format("SELECT*FROM roles WHERE ID=%d;",id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                role = resultSet.getString("Role_name");
            }
        return role;
    }
}

