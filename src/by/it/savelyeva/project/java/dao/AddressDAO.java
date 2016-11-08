package by.it.savelyeva.project.java.dao;

/**
 * Created by nato on 11/5/16.
 */

import by.it.savelyeva.project.java.beans.Address;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO extends AbstractDAO implements InterfaceDAO<Address> {
    @Override
    public List<Address> getAll(String WHERE) {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM addresses " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setIdStreet(rs.getInt("idStreet"));
                address.setBuilding(rs.getString("building"));
                address.setBuilding(rs.getString("flat"));
                addresses.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Address read(int id) {
        List<Address> addresses = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (addresses.size() > 0) {
            return addresses.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Address address) {
        String sql = String.format(
                "INSERT INTO addresses (idStreet, building, flat) values(%s, '%s', '%s');",
                address.getIdStreet(), address.getBuilding(), address.getFlat()
        );
        address.setId(executeUpdate(sql));
        return (address.getId() > 0);
    }

    @Override
    public boolean update(Address address) {
        String sql = String.format(
                "UPDATE addresses SET idStreet=%s, building='%s', flat='%s' WHERE id=%d;",
                address.getIdStreet(), address.getBuilding(), address.getFlat()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Address address) {
        String sql = String.format(
                "DELETE FROM addresses WHERE id=%d;", address.getId()
        );
        return (0 < executeUpdate(sql));
    }


}

