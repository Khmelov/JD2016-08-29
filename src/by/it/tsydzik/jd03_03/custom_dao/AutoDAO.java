package by.it.tsydzik.jd03_03.custom_dao;


import by.it.tsydzik.jd03_03.beans.Auto;
import by.it.tsydzik.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AutoDAO extends AbstractDAO implements InterfaceDAO<Auto> {
    @Override
    public Auto read(int id) {
        List<Auto> autos = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (autos.size() > 0) {
            return autos.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Auto auto) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "insert INTO auto(model,manufactureDate,number,enginePower,renterId)" +
                        "\n values('%s', '%d', '%s', '%.1f', '%d');",
                auto.getModel(),
                auto.getManufactureDate(),
                auto.getNumber(),
                auto.getEnginePower(),
                auto.getRenterId()
        );
        auto.setId(executeUpdate(sql));
        return (auto.getId() > 0);
    }

    @Override
    public boolean update(Auto auto) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `auto` SET " +
                        "`model`='%s' " +
                        ",`manufactureDate`=%d " +
                        ",`number`='%s' " +
                        ",`enginePower`='%.1f' " +
                        ",`renterId`=%d " +
                        " WHERE `auto`.`id` = %d",
                auto.getModel(),
                auto.getManufactureDate(),
                auto.getNumber(),
                auto.getEnginePower(),
                auto.getRenterId(),
                auto.getId()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Auto auto) {
        String sql = String.format(
                "DELETE FROM `auto` WHERE `auto`.`id`=%d;", auto.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Auto> getAll(String WHERE) {
        List<Auto> autos = new ArrayList<>();
        String sql = "SELECT * FROM auto " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Auto auto = new Auto();
                auto.setId(rs.getInt("id"));
                auto.setModel(rs.getString("model"));
                auto.setManufactureDate(rs.getInt("manufactureDate"));
                auto.setNumber(rs.getString("number"));
                auto.setEnginePower(rs.getDouble("enginePower"));
                auto.setRenterId(rs.getInt("renterId"));
                autos.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }
}
