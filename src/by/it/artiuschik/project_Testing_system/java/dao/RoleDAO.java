package by.it.artiuschik.project_Testing_system.java.dao;
import by.it.artiuschik.project_Testing_system.java.beans.Role;
import by.it.artiuschik.project_Testing_system.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artiuschik Elena
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {
    /**
     *
     * @param role role to add
     * @return success of adding
     */
    //CREATE
    @Override
    public boolean create(Role role) {
        role.setID(0);
        String createRoleSQL = String.format(
                "insert into roles(Role_name) values('%s');",
                role.getRole_name()
        );
        role.setID(executeUpdate(createRoleSQL));
        return (role.getID() > 0);
    }

    /**
     *
     * @param id id of role
     * @return read role
     */
    //READ
    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    /**
     *
     * @param role role to update
     * @return success of updating
     */
    //UPDATE
    @Override
    public boolean update(Role role) {
        String updateRoleSQL = String.format(
                "UPDATE roles SET Name = '%s' WHERE roles.ID = %d",
                role.getRole_name(), role.getID()
        );
        return (0 < executeUpdate(updateRoleSQL));
    }

    /**
     *
     * @param role to delete
     * @return success of deleting
     */
    //DELETE
    @Override
    public boolean delete(Role role) {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getID());
        return (0 < executeUpdate(deleteRoleSQL));
    }

    /**
     *
     * @param WHERE condition
     * @return roles answer condition
     */
    @Override
    public List<Role> getAll(String WHERE) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id=rs.getInt("ID");
                String roleName=rs.getString("Role_name");
                Role role = new Role(id,roleName);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

}
