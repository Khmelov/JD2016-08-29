package by.it.emelyanov.project.java.dao;



import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.connection.ConnectionCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDAO implements InterfaceDAO<Users> {

    @Override
    public Users read(int id) {
        List<Users> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Users user) {
        String sql = String.format(
                "INSERT INTO users(Login,Password,Email,FK_Role)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getfK_Role()
        );
        user.setId(executeUpdate(sql));
        return (user.getId() > 0);
    }

    @Override
    public boolean update(Users user) {
        String sql = String.format(
                "UPDATE `users` SET `Login` = '%s', `Password` = '%s', `Email` = '%s', `FK_Role` = '%d' WHERE `users`.`ID` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getfK_Role(), user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Users user) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Users> getAll(String WHERE) {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("ID"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setfK_Role(rs.getInt("FK_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return users;
    }
}
