package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.CN;
import by.it.rudzko.jd03_02.POJO.Role;
import by.it.rudzko.jd03_02.POJO.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UserCRUD {

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
            System.out.println("No connection. Can't create row in table Users.\n"+e.getMessage());
        }
        return us;
    }

    public User read(int id)  {
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
        } catch (SQLException e) {
            System.out.println("No connection. Can't read row from table Users.\n"+e.getMessage());
        }
        return userRes;
    }

    public User update(User us){
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
            System.out.println("No connection. Can't update row in table Users.\n"+e.getMessage());
        }
        return userRes;
    }

    public boolean delete(User us)  {
        boolean res=false;
        String deleteUser = String.format(Locale.ENGLISH, "DELETE FROM Users WHERE Users.ID = %d", us.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res= (statement.executeUpdate(deleteUser) == 1);
        } catch (SQLException e) {
            System.out.println("No connection. Can't remove row from table Users.\n"+e.getMessage());
        }
        return res;
    }

}
