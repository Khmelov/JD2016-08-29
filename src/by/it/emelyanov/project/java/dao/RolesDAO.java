package by.it.emelyanov.project.java.dao;

import by.it.emelyanov.project.java.beans.Roles;
import by.it.emelyanov.project.java.connection.ConnectionCreator;

import java.sql.*;
import java.util.*;


public class RolesDAO extends AbstractDAO implements InterfaceDAO<Roles> {

    @Override
    public Roles read(int id) {
        List<Roles> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Roles role) {
        String sql = String.format(
                "insert INTO roles(Name) values('%s',);", role.getName()
        );
        role.setId(executeUpdate(sql));
        return (role.getId() > 0);
    }

    @Override
    public boolean update(Roles role) {
        String sql = String.format(
                "UPDATE `roles` SET `Role` = '%s', WHERE `roles`.`ID` = %d",
                role.getName(), role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Roles role) {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`ID` = %d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Roles> getAll(String WHERE) {
            List<Roles> roles = new ArrayList<>();
            String sql = "SELECT * FROM roles " + WHERE + " ;";
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()
            ) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Roles role = new Roles();
                    role.setId(rs.getInt("ID"));
                    role.setName(rs.getString("Name"));
                    roles.add(role);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return roles;
    }
}
