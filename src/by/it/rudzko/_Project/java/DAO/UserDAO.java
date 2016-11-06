package by.it.rudzko._Project.java.DAO;

import by.it.rudzko._Project.java.ConnectionCreator;
import by.it.rudzko._Project.java.beans.Role;
import by.it.rudzko._Project.java.beans.User;

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
                "insert into Users(Name, Password, FK_Role, BirthYear, Sex) values('%s', '%s', '%d', '%d', '%s');",
                us.getName(), us.getPassword(), us.getRole().getID(), us.getBirthYear(), us.getSex()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
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
        return getAll("WHERE ID="+id).get(0);
    }

    @Override
    public User update(User us) {
        User userRes = null;
        String updateUser = String.format(Locale.ENGLISH,
                "UPDATE Users SET Name = '%s', Password='%s', FK_Role = '%d', BirthYear='%d', Sex='%s' WHERE Users.ID = %d",
                us.getName(), us.getPassword(), us.getRole().getID(), us.getBirthYear(), us.getSex(), us.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
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
    public boolean delete(User us) {
        boolean res = false;
        String deleteUser = String.format(Locale.ENGLISH, "DELETE FROM Users WHERE Users.ID = %d", us.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res = (statement.executeUpdate(deleteUser) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<User> getAll(String condition) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users " + condition;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement st = connection.createStatement()
        ) {
            ResultSet rs = st.executeQuery(sql);
            int amount=0;
            while (rs.next()){
                amount++;
            }
            for (int i=0; i<amount; i++) {
                ResultSet userSet = st.executeQuery(sql);
                for (int j=-1; j<i; j++){
                    userSet.next();
                }
                User userRes = new User();
                userRes.setID(userSet.getInt("ID"));
                userRes.setName(userSet.getString("Name"));
                userRes.setPassword(userSet.getString("Password"));
                Role role = new Role();
                int r = userSet.getInt("FK_Role");
                role.setID(r);
                userRes.setBirthYear(userSet.getInt("BirthYear"));
                userRes.setSex(userSet.getString("Sex"));
                ResultSet rolesSet = st.executeQuery("SELECT * FROM Roles where ID=" + r);
                if (rolesSet.next()) {
                    role.setParticipant(rolesSet.getString("Role"));
                }
                userRes.setRole(role);
                users.add(userRes);
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't read table Users.\n" + e.getMessage());
        }
        return users;
    }
}
