package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.CN;
import by.it.rudzko.jd03_02.POJO.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RoleCRUD {
    public Role create(Role r){
        r.setID(0);
        String createRole = String.format(Locale.ENGLISH,
                "insert into Roles(Role) value('%s');",
                r.getParticipant()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createRole, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    r.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't create row in table Roles.\n"+e.getMessage());
        }
        return r;
    }

    public Role read(int id){
        Role rRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet rs = statement.executeQuery("SELECT * FROM Roles WHERE ID=" + id);
            if (rs.next()) {
                rRes = new Role();
                rRes.setID(rs.getInt("ID"));
                rRes.setParticipant(rs.getString("Role"));
            }
        } catch (SQLException e) {
            System.out.println("No connection. Can't read row from table Roles.\n"+e.getMessage());
        }
        return rRes;
    }

    public Role update(Role r){
        Role rRes = null;
        String updateRole = String.format(Locale.ENGLISH,
                "UPDATE Roles SET Role= '%s' WHERE Roles.ID = %d",
                r.getParticipant(), r.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateRole) == 1)
                rRes = r;
        } catch (SQLException e) {
            System.out.println("No connection. Can't update row in table Roles.\n"+e.getMessage());
        }
        return rRes;
    }

    public boolean delete(Role r){
        boolean res=false;
        String deleteRole = String.format(Locale.ENGLISH, "DELETE FROM Roles WHERE Roles.ID = %d", r.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement()
        ) {
            res= (statement.executeUpdate(deleteRole) == 1);
        } catch (SQLException e) {
            System.out.println("No connection. Can't remove row from table Roles.\n"+e.getMessage());
        }
        return res;
    }
}
