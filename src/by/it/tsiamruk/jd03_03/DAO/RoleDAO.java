package by.it.tsiamruk.jd03_03.DAO;

import by.it.tsiamruk.jd03_03.Logger;
import by.it.tsiamruk.jd03_03.beans.Role;
import by.it.tsiamruk.jd03_03.connection.ConnectionCreator;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by waldemar on 01/11/2016.
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {
    private Logger logger;

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
        String sql =String.format("INSERT INTO role(role) VALUES(%s)",bean.getRole());
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
            }

        } catch (SQLException e) {
            logger.writeInLog(e.getMessage(),e);
        }
        return roles;
    }
}
