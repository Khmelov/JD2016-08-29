package by.it.artiuschik.jd_03_02.crud;

import by.it.artiuschik.jd_03_02.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.it.artiuschik.jd_03_02.utils.Updater.executeUpdate;

public class RoleCRUD {
    public boolean create(Role role) {
        role.setID(0);
        String createRoleSQL = String.format(
                "insert into roles(Role_name) values('%s');",
                role.getRole_name()
        );
        role.setID(executeUpdate(createRoleSQL));
        return (role.getID() > 0);
    }
    public Role read(int id) {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }
    public boolean update(Role role) {
        String updateRoleSQL = String.format(
                "UPDATE roles SET Name = '%s' WHERE roles.ID = %d",
                role.getRole_name(), role.getID()
        );
        return (0 < executeUpdate(updateRoleSQL));
    }
    public boolean delete(Role role) {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getID());
        return (0 < executeUpdate(deleteRoleSQL));
    }
    public List<Role> getAll(String WHERE) {
        List<Role> roles = new ArrayList<>();
        String sql = String.format("SELECT * FROM roles %s ;",WHERE);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setRole_name(rs.getString("Role_name"));
                role.setID(rs.getInt("ID"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

}
