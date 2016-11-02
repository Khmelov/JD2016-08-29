package by.it.tsiamruk.project.java.DAO;

import by.it.tsiamruk.project.java.beans.Role;
import by.it.tsiamruk.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waldemar on 01/11/2016.
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

    @Override
    public Role read(int id) {
        String sql =String.format("WHERE id = %d;", id);
        List<Role> roles= getAll(sql);
        if (roles.size()>0)
            return roles.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Role bean) {
        String sql =String.format("insert INTO role(role) values(%s);",bean.getRole());
        bean.setId(executeUpdate(sql));
        return (bean.getId()>0);
    }

    @Override
    public boolean update(Role bean) {
        String sql = String.format("UPDATE role SET role %s", bean.getRole());
        return (bean.getId()>0);
    }

    @Override
    public boolean delete(Role bean) {
        return false;
    }

    @Override
    public List<Role> getAll(String where) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * role " + where + " ;";
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement =  connection.createStatement();
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("ID"));
                role.setRole(rs.getString("role"));
                roles.add(role);
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return roles;
    }
}
