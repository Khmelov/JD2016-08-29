package by.it.savelyeva.jd_03_03.custom_dao;

import by.it.savelyeva.jd_03_03.beans.Rent;
import by.it.savelyeva.jd_03_03.connection.ConnectionCreator;

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
                        "\n VALUES (%d, %d, '%s', '%s', %d, %s);",
                rent.getIdCar(),
                rent.getIdUser(),
                rent.getStartDate(),
                rent.getEndDate(),
                rent.getCost(),
                rent.isPaid()
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
                        "paid=%s " +
                 "WHERE id=%d;",
                rent.getIdCar(),
                rent.getIdUser(),
                rent.getStartDate(),
                rent.getEndDate(),
                rent.getCost(),
                rent.isPaid()
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
}
