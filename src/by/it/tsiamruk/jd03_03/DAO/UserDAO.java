package by.it.tsiamruk.jd03_03.DAO;

import by.it.tsiamruk.jd03_03.connection.ConnectionCreator;
import by.it.tsiamruk.jd03_03.Logger;
import by.it.tsiamruk.jd03_03.beans.User;

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
    private Logger logger;

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
        String sql =String.format("insert into wtsiamruk.users(login, password, email, FK_role)" +
                        "values(%s, %s, %s, %d",
                user.getLogin(),user.getPassword(),user.getEmail(),user.getFk_role());
        user.setId(executeUpdate(sql));
        return (user.getId()>0);
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(Locale.ENGLISH,
                "update `users` SET `login` = '%s',`password` = '%s', `email` = '%s', `FK_role= '%d'`",
                user.getLogin(),user.getPassword(),user.getEmail(),user.getFk_role());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format(Locale.ENGLISH, "delete from wtsiamruk.users where users.ID = %d",user.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List getAll(String where) {
        List<User> users = new ArrayList<>();
        String sql = "select * from wtsiamruk.users " + where + ";";
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
            }

        } catch (SQLException e) {
            logger.writeInLog(e.getMessage(), e);
        }

        return users;
    }

}
