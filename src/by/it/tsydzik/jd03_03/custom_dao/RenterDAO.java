package by.it.tsydzik.jd03_03.custom_dao;


import by.it.tsydzik.jd03_03.beans.Renter;
import by.it.tsydzik.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RenterDAO extends AbstractDAO implements InterfaceDAO<Renter> {
    @Override
    public List<Renter> getAll(String WHERE) {
        List<Renter> renters = new ArrayList<>();
        String sql = "SELECT * FROM renter " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Renter renter = new Renter();
                renter.setId(rs.getInt("id"));
                renters.add(renter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return renters;
    }

    @Override
    public Renter read(int id) {
        List<Renter> renters = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (renters.size() > 0) {
            return renters.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Renter renter) {
        String sql = String.format(
                "insert INTO renter values();"
        );
        renter.setId(executeUpdate(sql));
        return (renter.getId() > 0);
    }

    @Override
    public boolean update(Renter renter) {
        return true;
    }

    @Override
    public boolean delete(Renter renter) {
        return true;
    }
}
