package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.CN;
import by.it.rudzko.jd03_02.POJO.Role;
import by.it.rudzko.jd03_02.POJO.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public User create(User us) throws SQLException {
        us.setID(0);
        String createUser = String.format(
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
        }
        return us;
    }

    public User read(int id) throws SQLException {
        User userRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet rs = statement.executeQuery("SELECT * FROM Users where ID=" + id);
            if (rs.next()) {
                userRes = new User();
                userRes.setID(rs.getInt("ID"));
                userRes.setName(rs.getString("Name"));
                Role role=new Role();
                int r=rs.getInt("FK_Role");
                role.setID(r);
                userRes.setBirthYear(rs.getInt("BirthYear"));
                userRes.setSex(rs.getString("Sex"));
                final ResultSet rolesSet = statement.executeQuery("SELECT * FROM Roles where ID=" + r);
                if (rolesSet.next()){
                    role.setParticipant(rolesSet.getString("Role"));
                }
                userRes.setRole(role);

            }
        }
        return userRes;
    }

    public User update(User us) throws SQLException {
        User userRes = null;
        String updateUser = String.format(
                "UPDATE Users SET Name = '%s', FK_Role = '%d', BirthYear='%d', Sex='%s' WHERE Users.ID = %d",
                us.getName(), us.getRole().getID(), us.getBirthYear(), us.getSex(), us.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateUser) == 1)
                userRes = us;
        }
        return userRes;
    }

    public boolean delete(User us) throws SQLException {
        String deleteUser = String.format("DELETE FROM Users WHERE Users.ID = %d", us.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUser) == 1);
        }
    }

}
