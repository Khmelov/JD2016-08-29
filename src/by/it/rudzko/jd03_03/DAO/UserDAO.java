package by.it.rudzko.jd03_03.DAO;


import by.it.rudzko.jd03_03.Beans.Role;
import by.it.rudzko.jd03_03.Beans.User;
import by.it.rudzko.jd03_03.CN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDAO implements InterfaceDAO<User> {

    @Override
    public User create(User us) {
        us.setID(0);
        String createUser = String.format(Locale.ENGLISH,
                "insert into Users(Name, FK_Role, BirthYear, Sex) values('%s', '%d', '%d', '%s');",
                us.getName(), us.getRole().getID(), us.getBirthYear(), us.getSex()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createUser, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    us.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public User read(int id) {
        User userRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Users where ID=" + id);
            if (rs.next()) {
                userRes = new User();
                userRes.setID(rs.getInt("ID"));
                userRes.setName(rs.getString("Name"));
                Role role=new Role();
                int r=rs.getInt("FK_Role");
                role.setID(r);
                userRes.setBirthYear(rs.getInt("BirthYear"));
                userRes.setSex(rs.getString("Sex"));
                ResultSet rolesSet = statement.executeQuery("SELECT * FROM Roles where ID=" + r);
                if (rolesSet.next()){
                    role.setParticipant(rolesSet.getString("Role"));
                }
                userRes.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRes;
    }

    @Override
    public User update(User us)  {
        User userRes = null;
        String updateUser = String.format(Locale.ENGLISH,
                "UPDATE Users SET Name = '%s', FK_Role = '%d', BirthYear='%d', Sex='%s' WHERE Users.ID = %d",
                us.getName(), us.getRole().getID(), us.getBirthYear(), us.getSex(), us.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateUser) == 1)
                userRes = us;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRes;
    }

    @Override
    public boolean delete(User us)  {
        boolean res=false;
        String deleteUser = String.format(Locale.ENGLISH, "DELETE FROM Users WHERE Users.ID = %d", us.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res= (statement.executeUpdate(deleteUser) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<User> getAll(String condition) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users " + condition;
        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User userRes = new User();
                userRes.setID(rs.getInt("ID"));
                userRes.setName(rs.getString("Name"));
                Role role=new Role();
                int r=rs.getInt("FK_Role");
                role.setID(r);
                userRes.setBirthYear(rs.getInt("BirthYear"));
                userRes.setSex(rs.getString("Sex"));
                ResultSet rolesSet = statement.executeQuery("SELECT * FROM Roles where ID=" + r);
                if (rolesSet.next()){
                    role.setParticipant(rolesSet.getString("Role"));
                }
                userRes.setRole(role);
                users.add(userRes);
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't read table Users.\n"+e.getMessage());
        }
        return users;
    }
}
