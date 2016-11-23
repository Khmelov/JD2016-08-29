package by.it.artiuschik.project_Testing_system.java.dao;

import by.it.artiuschik.project_Testing_system.java.beans.User;
import by.it.artiuschik.project_Testing_system.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artiuschik Elena
 */
public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {
    /**
     *
     * @param user user to add to database
     * @return success of adding
     */
    //CREATE
    @Override
    public boolean create(User user) {
        user.setID(0);
        String createUserSQL = String.format(
                "insert into users(Name,Surname,Password,Login,Tests_amount,Balls,FK_ROLE) values('%s','%s','%s','%s','%d','%d','%d');",
                user.getName(), user.getSurname(), user.getPassword(), user.getLogin(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE()
        );
        user.setID(executeUpdate(createUserSQL));
        return (user.getID() > 0);
    }

    /**
     *
     * @param id user id
     * @return read user
     */
    //READ
    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    /**
     *
     * @param user to update
     * @return  updated user
     */
    //UPDATE
    @Override
    public boolean update(User user) {
        String updateUserSQL = String.format(
                "UPDATE users SET Name = '%s', Surname = '%s', Password = '%s', Login = '%s', Tests_amount='%d', Balls='%d', FK_ROLE=%d WHERE users.ID = %d",
                user.getName(), user.getSurname(), user.getPassword(), user.getLogin(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE(), user.getID()
        );
        return (0 < executeUpdate(updateUserSQL));
    }

    /**
     *
     * @param user to delete
     * @return success of deleting
     */
    //DELETE
    @Override
    public boolean delete(User user) {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getID());
        return (0 < executeUpdate(deleteUserSQL));
    }

    /**
     *
     * @param WHERE condition
     * @return users answer condition
     */
    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setPassword(rs.getString("Password"));
                user.setLogin(rs.getString("Login"));
                user.setTests_amount(rs.getInt("Tests_amount"));
                user.setBalls(rs.getInt("Balls"));
                user.setFK_ROLE(rs.getInt("FK_ROLE"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     *
     * @param login user login
     * @param password user password
     * @return user with login and password
     */
    public List<User> getAll(String login, String password) {
        return getAll(
                String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                        login,
                        password
                ));
    }
}

