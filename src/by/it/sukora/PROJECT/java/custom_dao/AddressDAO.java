package by.it.sukora.PROJECT.java.custom_dao;


import by.it.sukora.PROJECT.java.beans.Address;
import by.it.sukora.PROJECT.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class AddressDAO extends AbstractDAO implements InterfaceDAO<Address> {

    @Override
    public Address read(int id) {
        List<Address> addresses = getAll("WHERE id=" + id + " LIMIT 0,5");
        if (addresses.size() > 0) {
            return addresses.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Address address) {
        String sql = String.format(
                "insert INTO address(" +
                        "City," +
                        "Country," +
                        "Flat," +
                        "Floor," +
                        "Street)" +
                        " values('%s','%s',%d,%d,'%s');",
                address.getCity(),
                address.getCountry(),
                address.getFlat(),
                address.getFloor(),
                address.getStreet()
        );
        address.setId(executeUpdate(sql));
        return (address.getId() > 0);
    }

    @Override
    public boolean update(Address address) {
        String sql = String.format(
                "UPDATE `address` SET" +
                        " `City` = '%s'," +
                        " `Country` = '%s'," +
                        " `Flat` = '%d'," +
                        " `Floor` = '%d'," +
                        " `Street` = '%s' " +
                        " WHERE `address`.`id` = %d",
                address.getCity(),
                address.getCountry(),
                address.getFlat(),
                address.getFloor(),
                address.getStreet(),
                address.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Address address) {
        String sql = String.format(
                "DELETE FROM `address` WHERE `address`.`ID` = %d;", address.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Address> getAll(String WHERE) {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM Address " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setCity(rs.getString("City"));
                address.setCountry(rs.getString("Country"));
                address.setFlat(rs.getInt("Flat"));
                address.setFloor(rs.getInt("Floor"));
                address.setStreet(rs.getString("Street"));
                addresses.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

}
