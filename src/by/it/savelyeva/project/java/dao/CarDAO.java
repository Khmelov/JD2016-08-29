package by.it.savelyeva.project.java.dao;

/**
 * Created by nato on 11/5/16.
 */

import by.it.savelyeva.project.java.beans.Car;
import by.it.savelyeva.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends AbstractDAO implements InterfaceDAO<Car> {
    @Override
    public List<Car> getAll(String WHERE) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setIdModel(rs.getInt("idModel"));
                car.setIdTransmission(rs.getInt("idTransmission"));
                car.setIdColor(rs.getInt("idColor"));
                car.setYear(rs.getInt("year"));
                car.setFullPrice(rs.getInt("fullPrice"));
                car.setDayPrice(rs.getInt("dayPrice"));
                car.setComment(rs.getString("comment"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car read(int id) {
        List<Car> cars = getAll("WHERE id=" + id + " LIMIT 0,1;");
        if (cars.size() > 0) {
            return cars.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Car car) {
        String sql = String.format(
                "INSERT INTO cars (idModel, idTransmission, idColor, year, fullPrice, dayPrice, comment) " +
                        "VALUES (%s, %s, %s, %s, %s, %s, '%s');",
                car.getIdModel(), car.getIdTransmission(), car.getIdColor(),
                car.getYear(), car.getFullPrice(), car.getDayPrice(), car.getComment()
        );
        car.setId(executeUpdate(sql));
        return (car.getId() > 0);
    }

    @Override
    public boolean update(Car car) {
        String sql = String.format(
                "UPDATE cars SET " +
                    "idModel=%s, idTransmission=%s, idColor=%s, year=%s, fullPrice=%s, dayPrice=%s, comment='%s' " +
                "WHERE id=%d;",
                car.getIdModel(), car.getIdTransmission(), car.getIdColor(),
                car.getYear(), car.getFullPrice(), car.getDayPrice(), car.getComment()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Car car) {
        String sql = String.format(
                "DELETE FROM cars WHERE id=%d;", car.getId()
        );
        return (0 < executeUpdate(sql));
    }


}

