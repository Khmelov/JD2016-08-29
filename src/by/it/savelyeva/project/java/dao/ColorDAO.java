package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Color;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColorDAO extends AbstractDAO implements InterfaceDAO<Color> {
    @Override
    public List<Color> getAll(String WHERE) {
        List<Color> colors = new ArrayList<>();
        String sql = "SELECT * FROM colors " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Color color = new Color();
                color.setId(rs.getInt("id"));
                color.setColor(rs.getString("color"));
                colors.add(color);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colors;
    }

    @Override
    public Color read(int id) {
        List<Color> colors = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (colors.size() > 0) {
            return colors.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Color color) {
        String sql = String.format(
                "INSERT INTO colors (color) values('%s');", color.getColor()
        );
        color.setId(executeUpdate(sql));
        return (color.getId() > 0);
    }

    @Override
    public boolean update(Color color) {
        String sql = String.format(
                "UPDATE colors SET color='%s' WHERE id=%d;",
                color.getColor(), color.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Color color) {
        String sql = String.format(
                "DELETE FROM colors WHERE id=%d;", color.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
