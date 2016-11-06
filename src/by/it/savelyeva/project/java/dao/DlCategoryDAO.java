package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.DlCategory;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DlCategoryDAO extends AbstractDAO implements InterfaceDAO<DlCategory> {
    @Override
    public List<DlCategory> getAll(String WHERE) {
        List<DlCategory> dls = new ArrayList<>();
        String sql = "SELECT * FROM dl_categories " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                DlCategory dl = new DlCategory();
                dl.setId(rs.getInt("id"));
                dl.setCategory(rs.getString("category"));
                dls.add(dl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dls;
    }

    @Override
    public DlCategory read(int id) {
        List<DlCategory> dls = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (dls.size() > 0) {
            return dls.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(DlCategory dl) {
        String sql = String.format(
                "INSERT INTO dl_categories (category) values('%s');", dl.getCategory()
        );
        dl.setId(executeUpdate(sql));
        return (dl.getId() > 0);
    }

    @Override
    public boolean update(DlCategory dl) {
        String sql = String.format(
                "UPDATE dl_categories SET category='%s' WHERE id=%d;",
                dl.getCategory(), dl.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(DlCategory dl) {
        String sql = String.format(
                "DELETE FROM dl_categories WHERE id=%d;", dl.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
