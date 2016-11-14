package by.it.laurynovich.jd03_03.dao;


import by.it.laurynovich.jd03_03.beans.User;
import by.it.laurynovich.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    public UserDAO() {

    }

    @Override
    public User read(int id_User) {
        List<User> users = getAll("WHERE ID=" + id_User + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(User user) {
        String sql = String.format(
                "insert INTO user (login,password,email,first_name,last_name,n_passport,bag,role)" +
                        " values('%s','%s','%s','%s','%s','%s','%d','%d');",
        user.getLogin(), user.getPassword(), user.getEmail(),user.getFirst_name(), user.getLast_name(),
                user.getN_passport(), user.getBag(), user.getRole(), user.getId());
        user.setId(executeUpdate(sql));
        int id = user.getId();
        user.setBag(id);

        return (user.getId() > 0);
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE `user` SET `login` = '%s', `password` = '%s', `email` = '%s', `first_name` = '%s'," +
                        "`last_name` = '%s',`n_passport` = '%s',`bag` = '%d',`role` = '%d' where id_User=%d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFirst_name(),
                user.getLast_name(), user.getN_passport(),user.getBag(), user.getRole(), user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM `user` WHERE `user`.`id_User` = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<User> getAll(String WHERE) {
            List<User> users = new ArrayList<>();
            String sql = "SELECT * FROM user " + WHERE + " ;";
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()
            ) {
                ResultSet rs = statement.executeQuery(sql);
                System.out.println("test:"+sql);
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id_User"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setFirst_name(rs.getString("first_name"));
                    user.setLast_name(rs.getString("last_name"));
                    user.setBag(rs.getInt("bag"));
                    user.setRole(rs.getInt("role"));
                    users.add(user);
                }
            } catch (SQLException e) {
                //тут нужно логгирование SQLException(e);
            }
            return users;
    }
}
