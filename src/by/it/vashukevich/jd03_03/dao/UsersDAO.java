package by.it.vashukevich.jd03_03.dao;

import by.it.vashukevich.jd03_03.beans.Users;
import by.it.vashukevich.jd03_03.connection.ConnectionCreater;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDAO implements InterfaceDAO<Users>{
    @Override
    public List<Users> getAll(String WHERE) {
    List<Users> std=new ArrayList<>();
    String sql = "SELECT * FROM users " + WHERE + " ;";
    try (Connection connection= ConnectionCreater.getConnection();
         Statement statement=connection.createStatement())
    {
        ResultSet res=statement.executeQuery(sql);
        while (res.next()){
            Users users =new Users();

            users.setId(res.getInt("Id"));
            users.setLogin(res.getString("Login"));
            users.setPassword(res.getString("Password"));
            users.setEmail(res.getString("Email"));
            users.setRole(res.getInt("Role"));
            std.add(users);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return std;
}
    @Override
    public Users read(int id) {
        List<Users> userses = getAll("WHERE Id=" + id + " LIMIT 0,1");
        if (userses.size() > 0) {
            return userses.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Users users) {
        String sql = String.format(
                "insert INTO users(Login,Password,Email,Role)" +
                        "\n values('%s', '%s', '%s', '%d');",
                users.getLogin(),
                users.getPassword(),
                users.getEmail(),
                users.getRole()
        );
        users.setId(executeUpdate(sql));
        return (users.getId() > 0);
    }

    @Override
    public boolean update(Users users) {
        String sql = String.format(
                "UPDATE 'users' SET" +
                        " 'Login' = '%s'," +
                        " 'Password' = '%s'," +
                        " 'Email' = '%s'," +
                        " 'Role' = %d," +
                        " WHERE 'users'.'IdStudents' = %d",
                users.getLogin(),
                users.getPassword(),
                users.getEmail(),
                users.getRole(),
                users.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Users users) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`Id`=%d;", users.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
