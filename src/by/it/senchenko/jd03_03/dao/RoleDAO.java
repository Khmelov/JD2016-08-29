package by.it.senchenko.jd03_03.dao;

import by.it.senchenko.jd03_03.beans.Role;
import by.it.senchenko.jd03_03.CN;

import java.sql.*;
import java.util.*;

public class RoleDAO extends AbstractClassDAO implements InterfaceForDAO<Role> {
    @Override
    public List<Role> getAll(String WHERE) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM role " + WHERE + " ;";
        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("ID"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Role role) {
        String sql = String.format(
                "insert INTO role(Role) values('%s',);",role.getRole()
        );
        role.setId(executeUpdate(sql));
        return (role.getId()>0);
    }

    @Override
    public boolean update(Role role) {
        String sql = String.format(
                "UPDATE `role` SET `Role` = '%s', WHERE `roles`.`ID` = %d",
                role.getRole(), role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) {
        String sql = String.format(
                "DELETE FROM `role` WHERE `roles`.`ID` = %d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }
}
