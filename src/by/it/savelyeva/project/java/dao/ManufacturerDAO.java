package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Manufacturer;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO extends AbstractDAO implements InterfaceDAO<Manufacturer> {
    @Override
    public List<Manufacturer> getAll(String WHERE) {
        List<Manufacturer> manufacturers = new ArrayList<>();
        String sql = "SELECT * FROM car_manufacturers " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(rs.getInt("id"));
                manufacturer.setManufacturer(rs.getString("manufacturer"));
                manufacturers.add(manufacturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    @Override
    public Manufacturer read(int id) {
        List<Manufacturer> manufacturers = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (manufacturers.size() > 0) {
            return manufacturers.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Manufacturer manufacturer) {
        String sql = String.format(
                "INSERT INTO car_manufacturers (manufacturer) values('%s');", manufacturer.getManufacturer()
        );
        manufacturer.setId(executeUpdate(sql));
        return (manufacturer.getId() > 0);
    }

    @Override
    public boolean update(Manufacturer manufacturer) {
        String sql = String.format(
                "UPDATE car_manufacturers SET manufacturer='%s' WHERE id=%d;",
                manufacturer.getManufacturer(), manufacturer.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Manufacturer manufacturer) {
        String sql = String.format(
                "DELETE FROM car_manufacturers WHERE id=%d;", manufacturer.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
