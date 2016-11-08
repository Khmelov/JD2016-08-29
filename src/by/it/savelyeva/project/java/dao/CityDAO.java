package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.City;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends AbstractDAO implements InterfaceDAO<City> {
    @Override
    public List<City> getAll(String WHERE) {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM cities " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setIdCountry(rs.getInt("idCountry"));
                city.setCity(rs.getString("city"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City read(int id) {
        List<City> cities = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (cities.size() > 0) {
            return cities.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(City city) {
        String sql = String.format(
                "INSERT INTO cities (idCountry, city) values(%s, '%s');", city.getIdCountry(), city.getCity()
        );
        city.setId(executeUpdate(sql));
        return (city.getId() > 0);
    }

    @Override
    public boolean update(City city) {
        String sql = String.format(
                "UPDATE cities SET idCountry=%s, city='%s' WHERE id=%d;",
                city.getIdCountry(), city.getCity(), city.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(City city) {
        String sql = String.format(
                "DELETE FROM cities WHERE id=%d;", city.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
