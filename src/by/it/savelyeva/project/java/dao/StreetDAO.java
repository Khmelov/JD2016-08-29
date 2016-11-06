package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Street;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StreetDAO extends AbstractDAO implements InterfaceDAO<Street> {
    @Override
    public List<Street> getAll(String WHERE) {
        List<Street> cities = new ArrayList<>();
        String sql = "SELECT * FROM streets " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Street street = new Street();
                street.setId(rs.getInt("id"));
                street.setIdCity(rs.getInt("idCity"));
                street.setStreet(rs.getString("street"));
                cities.add(street);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public Street read(int id) {
        List<Street> cities = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (cities.size() > 0) {
            return cities.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Street street) {
        String sql = String.format(
                "INSERT INTO streets (idCity, street) values(%s, '%s');", street.getIdCity(), street.getStreet()
        );
        street.setId(executeUpdate(sql));
        return (street.getId() > 0);
    }

    @Override
    public boolean update(Street street) {
        String sql = String.format(
                "UPDATE streets SET idCity=%s, street='%s' WHERE id=%d;",
                street.getIdCity(), street.getStreet(), street.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Street street) {
        String sql = String.format(
                "DELETE FROM streets WHERE id=%d;", street.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
