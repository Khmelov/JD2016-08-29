package by.it.laurynovich.jd03_03.dao;

import by.it.laurynovich.jd03_03.beans.Role;
import by.it.laurynovich.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nadabratb on 11/9/2016.
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

    @Override
    public Role read(int id) {
        List<Role> role = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (role.size() > 0) {
            return role.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Role role) {
        String sql = String.format(
                "insert INTO role(role)" +
                        " values('%s);",
                role.getRole());
        role.setIdRole(executeUpdate(sql));
        return (role.getIdRole() > 0);
    }

    @Override
    public boolean update(Role role) {
        String sql = String.format(
                "UPDATE `role` SET `role` = '%s'",
                role.getRole()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) {
        String sql = String.format(
                "DELETE FROM `role` WHERE `role`.`idRole` = %d;", role.getIdRole());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Role> getAll(String WHERE) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setRole(rs.getNString("roles"));
                roles.add(role);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return roles;
    }
}
