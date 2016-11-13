package by.it.grishechkin.project.java.DAO;

import by.it.grishechkin.project.java.beans.Auto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yury on 31.10.2016.
 */
public class AutoDAO implements IDAO<Auto> {
    @Override
    public int create(Auto auto) {
        int key = 0;
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"INSERT INTO auto (Model, Availability, Mark, Year)" +
                            " VALUES ('%s', '%d', '%s', '%d');",
                    auto.getModel(), auto.getAvailability(), auto.getMark(), auto.getYear()), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            key = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(key);
        return key;
    }

    @Override
    public List<Auto> read(Auto auto) {
        List<Auto> autos = new ArrayList<>();
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM auto WHERE auto.ID=" + auto.getID() + ";" ));
            autos = exequte(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }

    @Override
    public void update(Auto auto) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"UPDATE auto SET Model='%s', Availability='%d', Mark='%s', Year='%d' WHERE auto.ID=" + auto.getID() + ";",
                    auto.getModel(), auto.getAvailability(), auto.getMark(), auto.getYear()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Auto auto) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"DELETE FROM auto WHERE auto.ID=" + auto.getID() + ";"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Auto> getAll() {
        List<Auto> autos = new ArrayList<>();
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM auto;"));
            autos = exequte(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }

    private List<Auto> exequte(ResultSet resultSet) {
        List<Auto> autos = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Auto auto = new Auto();
                auto.setID(resultSet.getInt("ID"));
                auto.setModel(resultSet.getString("Model"));
                auto.setAvailability(resultSet.getInt("Availability"));
                auto.setMark(resultSet.getString("Mark"));
                auto.setYear(resultSet.getInt("Year"));
                autos.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }
}
