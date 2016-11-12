package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.User;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setIdRole(rs.getInt("idRole"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setMiddleName(rs.getString("middleName"));
                user.setDateOfBirth(rs.getString("dateOfBirth"));
                user.setIdSex(rs.getInt("idSex"));
                user.setPassport(rs.getString("passport"));
                user.setIdAddress(rs.getInt("idAddress"));
                user.setIdDriverLicense(rs.getString("idDriverLicense"));
                users.add(user);
            }
        } catch (Exception e) {
            logger.log(e.getMessage()); //тут нужно логгирование SQLException(e);
        }
        return users;
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(User user) {
        String sql = String.format(
                "INSERT INTO users (login, password, email, idRole, firstName, lastName, middleName, " +
                                    "dateOfBirth, idSex, passport, idAddress, idDriverLicense) " +
                            "VALUES ('%s', '%s', '%s', %s, '%s', '%s', '%s', '%s', %d, '%s', %d, '%s');",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole(),
                user.getFirstName(), user.getLastName(), user.getMiddleName(),
                user.getDateOfBirth(), user.getIdSex(), user.getPassport(),
                user.getIdAddress(), user.getIdDriverLicense()
        );
        user.setId(executeUpdate(sql));
        return (user.getId()>0);
    }
    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE users SET " +
                        "login='%s', password='%s', email='%s', idRole=%s, firstName='%s', lastName='%s', middleName='%s', " +
                        "dateOfBirth='%s', idSex=%s, passport='%s', idAddress=%s, idDriverLicense='%s' " +
                "WHERE id=%s;",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole(),
                user.getFirstName(), user.getLastName(), user.getMiddleName(), user.getDateOfBirth(), user.getIdSex(),
                user.getPassport(), user.getIdAddress(), user.getIdDriverLicense(), user.getId()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM users WHERE id=%d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }


    public int getCount(String where) {
        int res = 0;
        String sql = "SELECT COUNT(*) FROM users " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            if (rs.next()) {
                res = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

}
