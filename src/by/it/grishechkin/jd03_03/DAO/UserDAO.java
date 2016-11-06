package by.it.grishechkin.jd03_03.DAO;

import by.it.grishechkin.jd03_03.beans.User;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Yury on 30.10.2016.
 */
public class UserDAO implements IDAO <User> {

    @Override
    public int create(User user) {
        int key = 0;
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"INSERT INTO user (firstName, lastName, pasportNum, FK_Role)" +
                            " VALUES ('%s', '%s', '%s', '%d');",
                    user.getFirstName(), user.getLastName(), user.getPasportNum(), user.getFK_Role()), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            key = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    @Override
    public void read(int id) {

        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM user WHERE user.ID=" + id + ";"));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"UPDATE user SET firstName='%s', lastName='%s', pasportNum='%s', FK_Role='%d' WHERE user.ID=" + user.getID() + ";",
                    user.getFirstName(), user.getLastName(), user.getPasportNum(), user.getFK_Role()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"DELETE FROM user WHERE user.ID=" + user.getID() + ";"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAll() {
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM user;" ));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
