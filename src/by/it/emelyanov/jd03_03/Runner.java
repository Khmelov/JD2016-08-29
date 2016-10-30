package by.it.emelyanov.jd03_03;

import by.it.emelyanov.jd03_03.beans.Users;
import by.it.emelyanov.jd03_03.connection.ConnectionCreator;
import by.it.emelyanov.jd03_03.dao.DAO;

import java.sql.*;

public class Runner {
    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();)
        {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users, roles WHERE users.FK_Role = roles.ID;");
            while (resultSet.next()) {
                System.out.printf("Роль: %s,Имя пользователя: %s\n",
                        resultSet.getString("roles.Name"), resultSet.getString("users.Login"));
            }
        }

        DAO dao = DAO.getDAO();
        Users user = new Users(5,"Vaska","kot123","vaska_kot@gmail.com",2);
        dao.getUserDAO().create(user);
        System.out.printf("%s", user);
    }
}
