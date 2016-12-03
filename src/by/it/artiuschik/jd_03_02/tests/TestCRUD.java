package by.it.artiuschik.jd_03_02.tests;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.User;
import by.it.artiuschik.jd_03_02.crud.UserCRUD;

import java.sql.Connection;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;

public class TestCRUD {
    private UserCRUD userCRUD=new UserCRUD();
    private User user=new User(0, "Петрова", "Анастасия", "Login","11111", 1, 10, 1);
    @Test
    public void testCreate() throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
        if (resultSet.next())
            user.setID(resultSet.getInt(1));
        assertTrue("Не работает Create()", userCRUD.create(user));
    }

    @Test
    public void testRead() throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String createUserSQL = String.format(
                "insert into users(Name,Surname,Password,Tests_amount,Balls,FK_ROLE) values('%s','%s','%s','%d','%d','%d');",
                user.getName(), user.getSurname(), user.getPassword(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE()
        );
        statement.executeUpdate(createUserSQL);
        ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
        resultSet.next();
        int id = resultSet.getInt(1);
        assertTrue("Не работает read()", userCRUD.read(id) != null);
    }

    @Test
    public void testDelete() throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String createUserSQL = String.format(
                "insert into users(Name,Surname,Password,Tests_amount,Balls,FK_ROLE) values('%s','%s','%s','%d','%d','%d');",
                user.getName(), user.getSurname(), user.getPassword(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE()
        );
        statement.executeUpdate(createUserSQL);
        ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
        resultSet.next();
        int id = resultSet.getInt(1);
        user.setID(id);
        assertTrue("Не работает delete()", userCRUD.delete(user));
    }

    @Test
    public void testUpdate() throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String createUserSQL = String.format(
                "insert into users(Name,Surname,Password,Tests_amount,Balls,FK_ROLE) values('%s','%s','%s','%d','%d','%d');",
                user.getName(), user.getSurname(), user.getPassword(), user.getTests_amount(), user.getBalls(), user.getFK_ROLE()
        );
        statement.executeUpdate(createUserSQL);
        ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
        resultSet.next();
        int id = resultSet.getInt(1);
        user.setID(id);
        user.setSurname("Иванова");
        assertTrue("Не работает update()", userCRUD.update(user));
    }

}

