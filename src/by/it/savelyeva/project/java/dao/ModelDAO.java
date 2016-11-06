package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Model;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelDAO extends AbstractDAO implements InterfaceDAO<Model> {
    @Override
    public List<Model> getAll(String WHERE) {
        List<Model> models = new ArrayList<>();
        String sql = "SELECT * FROM car_models " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Model model = new Model();
                model.setId(rs.getInt("id"));
                model.setIdManufacturer(rs.getInt("idManufacturer"));
                model.setModel(rs.getString("model"));
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public Model read(int id) {
        List<Model> models = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (models.size() > 0) {
            return models.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Model model) {
        String sql = String.format(
                "INSERT INTO car_models (idManufacturer, model) values(%s, '%s');",
                model.getIdManufacturer(), model.getModel()
        );
        model.setId(executeUpdate(sql));
        return (model.getId() > 0);
    }

    @Override
    public boolean update(Model model) {
        String sql = String.format(
                "UPDATE car_models SET idManufacturer=%s, model='%s' WHERE id=%d;",
                model.getIdManufacturer(), model.getModel(), model.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Model model) {
        String sql = String.format(
                "DELETE FROM car_models WHERE id=%d;", model.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
