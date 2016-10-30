package by.it.emelyanov.jd03_02.crud;

import java.sql.*;

public class UsersCRUD {
    public Users create(Users user) throws SQLException {

        String createUserSQL = String.format(
                "insert into users(Login,Password,Email,FK_Role) values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getfK_Role()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createUserSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    user.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }

    public Users read(int id) throws SQLException {
        Users userResult = null;
        String readUserSQL = "SELECT * FROM users where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new Users(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public Users update(Users user) throws SQLException {
        Users userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Email = '%s', FK_Role=%d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getfK_Role(), user.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public boolean delete(Users user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
