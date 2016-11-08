package by.it.grishechkin.jd03_03.DAO;

import by.it.grishechkin.jd03_03.beans.Auto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                    auto.getModel(), auto.isAvailability(), auto.getMark(), auto.getYear()), Statement.RETURN_GENERATED_KEYS);
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
    public void read(int id) {
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM auto WHERE auto.ID=" + id ));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Auto auto) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"UPDATE auto SET Model='%s', Availability='%d', Mark='%s', Year='%d' WHERE auto.ID=" + auto.getID() + ";",
                    auto.getModel(), auto.isAvailability(), auto.getMark(), auto.getYear()));
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
    public void getAll() {
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM auto;"));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
