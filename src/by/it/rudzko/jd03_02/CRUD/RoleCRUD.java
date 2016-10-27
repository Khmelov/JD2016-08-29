package by.it.rudzko.jd03_02.CRUD;

import by.it.rudzko.jd03_02.CN;
import by.it.rudzko.jd03_02.POJO.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {
    public Role create(Role r) throws SQLException {
        r.setID(0);
        String createRole = String.format(
                "insert into Roles(Role) value('%s');",
                r.getParticipant()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createRole) == 1) {
                ResultSet rs = statement.executeQuery(String.format("SELECT LAST_INSERT_ID();"));
                if (rs.next())
                    r.setID(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return r;
    }

    public Role read(int id) throws SQLException {
        Role rRes = null;
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet rs = statement.executeQuery("SELECT * FROM Roles WHERE ID=" + id);
            if (rs.next()) {
                rRes = new Role();
                rRes.setID(rs.getInt("ID"));
                rRes.setParticipant(rs.getString("Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return rRes;
    }

    public Role update(Role r) throws SQLException {
        Role rRes = null;
        String updateRole = String.format(
                "UPDATE Roles.Role= '%s' WHERE Roles.ID = %d",
                r.getParticipant(), r.getID()
        );
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateRole) == 1)
                rRes = r;
        } catch (SQLException e) {
            throw e;
        }
        return rRes;
    }

    public boolean delete(Role r) throws SQLException {
        String deleteRole = String.format("DELETE FROM Roles WHERE Roles.ID = %d", r.getID());
        try (
                Connection connection = CN.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteRole) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
