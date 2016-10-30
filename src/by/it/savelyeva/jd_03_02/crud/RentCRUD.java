package by.it.savelyeva.jd_03_02.crud;

/**
 * Created by nato on 10/29/16.
 */

import by.it.savelyeva.jd_03_02.ConnectionCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RentCRUD {

    public Rent create(Rent rent) throws SQLException {
        rent.setId(0);

        String createRentSQL = String.format(
                "INSERT INTO rents (" +
                        "car_id, user_id, start_date, end_date, cost, paid" +
                        ") VALUES (%d, %d, '%s', '%s', %d, %s);",
                rent.getIdCar(), rent.getIdUser(),
                rent.getStartDate(), rent.getEndDate(),
                rent.getCost(), (rent.isPaid() ? true : false)
        );
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createRentSQL) == 1)
            {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    rent.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return rent;
    }

    public Rent read(int id) throws SQLException {
        Rent rentResult = null;
        String readRentSQL = "SELECT * FROM rents WHERE id=" + id;
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readRentSQL);
            if (resultSet.next()) {
                rentResult = new Rent(
                        resultSet.getInt("id"),
                        resultSet.getInt("car_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"),
                        resultSet.getInt("cost"),
                        resultSet.getBoolean("paid")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return rentResult;
    }

    public Rent update(Rent rent) throws SQLException {
        Rent rentResult = null;
        String updateRentSQL = String.format(
                "UPDATE rents SET " +
                        "car_id=%d, user_id=%d, start_date='%s', end_date='%s', " +
                        "cost=%d, paid=%s " +
                        "WHERE id=%d;",
                rent.getIdCar(), rent.getIdUser(),
                rent.getStartDate(), rent.getEndDate(),
                rent.getCost(), (rent.isPaid() ? true : false),
                rent.getId()
        );
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateRentSQL) == 1)
                rentResult = rent;
        } catch (SQLException e) {
            throw e;
        }
        return rentResult;
    }

    public boolean delete(Rent rent) throws SQLException {
        String deleteRentSQL = String.format("DELETE FROM rents WHERE id = %d", rent.getId());
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteRentSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}

