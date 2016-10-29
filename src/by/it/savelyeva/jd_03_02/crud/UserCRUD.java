package by.it.savelyeva.jd_03_02.crud;

/**
 * Created by nato on 10/29/16.
 */

import by.it.savelyeva.jd_03_02.ConnectionCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public User create(User user) throws SQLException {
        user.setId(0);

        String createUserSQL = String.format(
                "INSERT INTO users (" +
                        "login, password, email, role_id, first_name, last_name, middle_name, " +
                        "date_of_birth, sex_id, passport, address_id, driver_license" +
                ") VALUES ('%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', %d, '%s', %d, '%s');",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole(),
                user.getFirstName(), user.getLastName(), user.getMiddleName(),
                user.getDateOfBirth(), user.getIdSex(), user.getPassport(),
                user.getIdAddress(), user.getIdDriverLicense()
        );
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createUserSQL) == 1)
            {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    user.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }

    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM users WHERE id=" + id;
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("role_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getInt("sex_id"),
                        resultSet.getString("passport"),
                        resultSet.getInt("address_id"),
                        resultSet.getString("driver_license")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public User update(User user) throws SQLException {
        User userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET " +
                    "login='%s', password='%s', email='%s', role_id=%d, " +
                     "first_name='%s', last_name='%s', middle_name='%s', " +
                     "date_of_birth='%s', sex_id=%d, passport='%s', address_id=%d, driver_license='%s' " +
                "WHERE id=%d;",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole(),
                user.getFirstName(), user.getLastName(), user.getMiddleName(),
                user.getDateOfBirth(), user.getIdSex(), user.getPassport(),
                user.getIdAddress(), user.getIdDriverLicense(),
                user.getId()
        );
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE id = %d", user.getId());
        try (
                java.sql.Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}

