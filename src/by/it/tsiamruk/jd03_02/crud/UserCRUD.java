package by.it.tsiamruk.jd03_02.crud;


import by.it.tsiamruk.jd03_01.connection.ConnectionCreator;
import by.it.tsiamruk.jd03_02.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;


/**
 * Created by waldemar on 26/10/2016.
 */
public class UserCRUD {


    public User create(User user) throws SQLException {
        user.setId(0);
        String createUserSQL = String.format("insert into users(Login,Password,Email,FK_Role)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createUserSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    user.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM wtsiamruk.users where ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(resultSet.getInt("ID"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("FK_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userResult;
    }

    public User update(User user) throws SQLException {
        User userResult = null;
        String updateUserSQL = String.format(
                Locale.ENGLISH,
                "UPDATE wtsiamruk.users SET login = '%s', password = '%s', email = '%s', FK_role = %d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role(), user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userResult;
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM wtsiamruk.users WHERE users.ID = %d", user.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}


