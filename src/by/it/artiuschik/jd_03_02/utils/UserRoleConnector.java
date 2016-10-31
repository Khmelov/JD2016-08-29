package by.it.artiuschik.jd_03_02.utils;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRoleConnector {
    public static String getRole(int id,Connection connection) throws SQLException {
        String role = null;
        String sql = "SELECT*FROM roles WHERE ID=" + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                role = resultSet.getString("Role_name");
            }
        return role;
    }

    public static Integer getRoleID(String role) throws SQLException {
        Integer id = null;
        String sql = "SELECT*FROM roles WHERE Role_name=" + role+";";
        try (Connection connection = ConnectionCreator.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}

