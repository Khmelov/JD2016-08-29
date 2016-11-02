package by.it.tsiamruk.project.java.DAO;

import by.it.tsiamruk.project.java.beans.User;
import by.it.tsiamruk.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by waldemar on 30/10/2016.
 */
public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public User read(int id) {
        String sql = "WHERE ID =" + id + "LIMIT 0,1";
        List<User> users = getAll(sql);
        if (users.size()>0)
            return users.get(0);
        else
            return null;
    }

    @Override
    public boolean create(User user) {
        String sql =String.format("insert INTO users(login,password,email,FK_role)" +
                " values('%s','%s','%s',%d);",
                user.getLogin(),user.getPassword(),user.getEmail(),user.getFk_role());
        user.setId(executeUpdate(sql));
        return (user.getId()>0);
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` SET `login` = '%s',`password` = '%s', `email` = '%s', `FK_role= '%d'`",
                user.getLogin(),user.getPassword(),user.getEmail(),user.getFk_role());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM users WHERE users.ID = %d",user.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<User> getAll(String where) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + where + ";";
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFk_role(rs.getInt("FK_role"));
                users.add(user);
            }

        } catch (SQLException e) {
            System.out.println(""+e.getMessage());;
        }

        return users;
    }

}
