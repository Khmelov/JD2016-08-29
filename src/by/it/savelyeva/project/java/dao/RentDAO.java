package by.it.savelyeva.project.java.dao;

import by.it.savelyeva.project.java.beans.Rent;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RentDAO extends AbstractDAO implements InterfaceDAO<Rent> {
    @Override
    public Rent read(int id) {
        List<Rent> rents = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (rents.size() > 0) {
            return rents.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Rent rent) {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO rents (idCar, idUser, startDate, endDate, cost, paid) " +
                        " VALUES (%d, %d, '%s', '%s', %d, %d);",
                rent.getIdCar(),
                rent.getIdUser(),
                rent.getStartDate(),
                rent.getEndDate(),
                rent.getCost(),
                (rent.isPaid() ? 1 : 0)
        );
        rent.setId(executeUpdate(sql));
        return (rent.getId() > 0);
    }

    @Override
    public boolean update(Rent rent) {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE rents SET " +
                        "idCar=%d, " +
                        "idUser=%d, " +
                        "startDate='%s', " +
                        "endDate='%s', " +
                        "cost=%d, " +
                        "paid=%d " +
                 "WHERE id=%d;",
                rent.getIdCar(),
                rent.getIdUser(),
                rent.getStartDate(),
                rent.getEndDate(),
                rent.getCost(),
                (rent.isPaid() ? 1 : 0),
                rent.getId()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Rent rent) {
        String sql = String.format(
                "DELETE FROM rents WHERE id=%d;", rent.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Rent> getAll(String WHERE) {
        List<Rent> rents = new ArrayList<>();
        String sql = "SELECT * FROM rents " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Rent rent = new Rent();
                rent.setId(rs.getInt("id"));
                rent.setIdCar(rs.getInt("idCar"));
                rent.setIdUser(rs.getInt("idUser"));
                rent.setStartDate(rs.getString("startDate"));
                rent.setEndDate(rs.getString("endDate"));
                rent.setCost(rs.getInt("cost"));
                rent.setPaid(rs.getBoolean("paid"));
                rents.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rents;
    }

    public int getCount(String where) {
        int res = 0;
        String sql = "SELECT COUNT(*) FROM rents " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            if (rs.next()) {
                res = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

}
