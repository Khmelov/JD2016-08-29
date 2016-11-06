package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Sex;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SexDAO extends AbstractDAO implements InterfaceDAO<Sex> {
    @Override
    public List<Sex> getAll(String WHERE) {
        List<Sex> types = new ArrayList<>();
        String sql = "SELECT * FROM sex " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Sex sex = new Sex();
                sex.setId(rs.getInt("id"));
                sex.setType(rs.getString("type"));
                types.add(sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    @Override
    public Sex read(int id) {
        List<Sex> types = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (types.size() > 0) {
            return types.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Sex sex) {
        String sql = String.format(
                "INSERT INTO sex (type) values('%s');", sex.getType()
        );
        sex.setId(executeUpdate(sql));
        return (sex.getId() > 0);
    }

    @Override
    public boolean update(Sex sex) {
        String sql = String.format(
                "UPDATE sex SET type='%s' WHERE id=%d;",
                sex.getType(), sex.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Sex sex) {
        String sql = String.format(
                "DELETE FROM sex WHERE id=%d;", sex.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
