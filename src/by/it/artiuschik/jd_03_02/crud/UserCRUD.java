package by.it.artiuschik.jd_03_02.crud;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
    public User create(User user) throws SQLException {
        user.setID(0);
        //составление строки createUserSQL по данным Bean User
        String createUserSQL = String.format(
                "insert into users(Name,Surname,Password,Tests_amount,Balls,FK_ROLE) values('%s','%s','%d','%d','%d','%d');",
                user.getName(), user.getSurname(), user.getPassword(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE()
        );
        try (
                //соединение с базой
                Connection connection = ConnectionCreator.getConnection();
                //объект для обращения к базе
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(createUserSQL) == 1) {
                /*LAST_INSERT_ID() Возвращает последнюю автоматически
                сгенерированную величину, которая была внесена в столбец
                AUTO_INCREMENT*/
                //извлечение строки с последним  id
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet первую строку
                if (resultSet.next())
                    user.setID(resultSet.getInt(1));
            }
        }
        return user;
    }

    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM users where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getInt("Password"),
                        resultSet.getInt("Tests_amount"),
                        resultSet.getInt("Balls"),
                        resultSet.getInt("FK_ROLE"));
            }
        }
        return userResult;
    }

    public User update(User user) throws SQLException {
        User userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET Name = '%s', Surname = '%s', Password = '%d', Tests_amount='%d', Balls='%d', FK_ROLE=%d WHERE users.ID = %d",
                user.getName(), user.getSurname(), user.getPassword(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE(), user.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        }
        return userResult;
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        }
    }

}
