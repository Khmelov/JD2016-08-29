package by.it.sukora.PROJECT.java.custom_dao;

import by.it.sukora.PROJECT.java.beans.Users;
import by.it.sukora.PROJECT.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDAO implements InterfaceDAO<Users> {
    @Override
    public List<Users> getAll(String WHERE) {
        List<Users> userses = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("Email"));
                user.setFirsName(rs.getString("FirsName"));
                user.setLastName(rs.getString("LastName"));
                user.setId_logpass(rs.getInt("id_logpass"));
                user.setId_role(rs.getInt("id_role"));
                userses.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userses;
    }

    @Override
    public Users read(int id) {
        List<Users> userses = getAll("WHERE id=" + id + " LIMIT 0,5");
        if (userses.size() > 0) {
            return userses.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Users users) {
        String sql = String.format(
                "insert INTO users(" +
                        "FirsName," +
                        "LastName," +
                        "Email," +
                        "id_role," +
                        "id_logpass)" +
                        " values('%s','%s','%s',%d,%d);",
                users.getFirsName(),
                users.getLastName(),
                users.getEmail(),
                users.getId_role(),
                users.getId_logpass()
        );
        users.setId(executeUpdate(sql));
        return (users.getId()>0);
    }
    @Override
    public boolean update(Users users) {
        String sql = String.format(
                "UPDATE `users` SET" +
                        " `FirsName` = '%s'," +
                        " `LastName` = '%s'," +
                        " `Email` = '%s'," +
                        " `id_role` = '%d'," +
                        " `id_logpass` = '%d'" +
                        " WHERE `users`.`id` = %d",
                users.getFirsName(),
                users.getLastName(),
                users.getEmail(),
                users.getId_role(),
                users.getId_logpass(),
                users.getId()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Users users) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", users.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
