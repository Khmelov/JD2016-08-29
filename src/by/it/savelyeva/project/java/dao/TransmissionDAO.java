package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Transmission;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransmissionDAO extends AbstractDAO implements InterfaceDAO<Transmission> {
    @Override
    public List<Transmission> getAll(String WHERE) {
        List<Transmission> types = new ArrayList<>();
        String sql = "SELECT * FROM car_transmissions " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Transmission transmission = new Transmission();
                transmission.setId(rs.getInt("id"));
                transmission.setType(rs.getString("type"));
                types.add(transmission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    @Override
    public Transmission read(int id) {
        List<Transmission> types = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (types.size() > 0) {
            return types.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Transmission transmission) {
        String sql = String.format(
                "INSERT INTO car_transmissions (type) values('%s');", transmission.getType()
        );
        transmission.setId(executeUpdate(sql));
        return (transmission.getId() > 0);
    }

    @Override
    public boolean update(Transmission transmission) {
        String sql = String.format(
                "UPDATE car_transmissions SET type='%s' WHERE id=%d;",
                transmission.getType(), transmission.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Transmission transmission) {
        String sql = String.format(
                "DELETE FROM car_transmissions WHERE id=%d;", transmission.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
