package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Country;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends AbstractDAO implements InterfaceDAO<Country> {
    @Override
    public List<Country> getAll(String WHERE) {
        List<Country> countrys = new ArrayList<>();
        String sql = "SELECT * FROM countries " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setCountry(rs.getString("country"));
                countrys.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countrys;
    }

    @Override
    public Country read(int id) {
        List<Country> countries = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (countries.size() > 0) {
            return countries.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Country country) {
        String sql = String.format(
                "INSERT INTO countries (country) values('%s');", country.getCountry()
        );
        country.setId(executeUpdate(sql));
        return (country.getId() > 0);
    }

    @Override
    public boolean update(Country country) {
        String sql = String.format(
                "UPDATE countries SET country='%s' WHERE id=%d;",
                country.getCountry(), country.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Country country) {
        String sql = String.format(
                "DELETE FROM countries WHERE id=%d;", country.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
