package by.it.emelyanov.jd03_02;

import by.it.emelyanov.jd03_02.crud.ConnectionCreator;

import java.sql.*;

public class SearchByRole {
    public static void searchId(String role) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT roles.ID FROM emelyanov.roles WHERE roles.Name ='" + role + "'");
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("ID"));
            }
        }
    }
}
