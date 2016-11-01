package by.it.artiuschik.jd_03_03.TaskA_TaskB.dao;
import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {
    //CREATE
    @Override
    public boolean create(User user) {
        user.setID(0);
        String createUserSQL = String.format(
                "insert into users(Name,Surname,Password,Tests_amount,Balls,FK_ROLE) values('%s','%s','%d','%d','%d','%d');",
                user.getName(), user.getSurname(), user.getPassword(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE()
        );
        user.setID(executeUpdate(createUserSQL));
        return (user.getID()>0);
    }
    //READ
    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    //UPDATE
    @Override
    public boolean update(User user) {
        String updateUserSQL = String.format(
                "UPDATE users SET Name = '%s', Surname = '%s', Password = '%d', Tests_amount='%d', Balls='%d', FK_ROLE=%d WHERE users.ID = %d",
                user.getName(), user.getSurname(), user.getPassword(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE(), user.getID()
        );
        return (0 < executeUpdate(updateUserSQL));
    }
    //DELETE
    @Override
    public boolean delete(User user) {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getID());
        return (0 < executeUpdate(deleteUserSQL));
    }

    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        //String sql = String.format("SELECT * FROM users %s ;",WHERE);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setPassword(rs.getInt("Password"));
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
}

