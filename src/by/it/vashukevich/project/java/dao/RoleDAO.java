package by.it.vashukevich.project.java.dao;

import by.it.vashukevich.project.java.beans.Role;
import by.it.vashukevich.project.java.connection.ConnectionCreater;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {
    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE Id=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Role role) {
        String sql = String.format(
                "insert INTO role(Name)" +
                        "\n values('%s');",
                role.getName()

        );
        role.setId(executeUpdate(sql));
        return (role.getId() > 0);
    }

    @Override
    public boolean update(Role role) {
        String sql = String.format(
                "UPDATE 'role' SET" +
                        " 'Name' = '%s'," +
                        " WHERE 'role'.'Id' = %d",
                role.getName(),
                role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) {
        String sql = String.format(
                "DELETE FROM `role` WHERE `role`.`Id=%d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Role> getAll(String WHERE) {
        List<Role> std=new ArrayList<>();
        String sql = "SELECT * FROM role " + WHERE + " ;";
        try (Connection connection= ConnectionCreater.getConnection();
             Statement statement=connection.createStatement()){
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Role role=new Role();
                role.setId(resultSet.getInt("Id"));
                role.setName(resultSet.getString("Name"));
                std.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return std;
    }
}
