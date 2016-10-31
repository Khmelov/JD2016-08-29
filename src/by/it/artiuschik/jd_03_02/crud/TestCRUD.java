package by.it.artiuschik.jd_03_02.crud;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCRUD {
    public Test create(Test test) throws SQLException {
        test.setID(0);
        //составление строки createUserSQL по данным Bean User
        String createUserSQL = String.format(
                "insert into tests(Name,Subject,Questions) values('%s','%s','%d');",
                test.getName(), test.getSubject(),test.getQuestions()
        );
        try (
                //соединение с базой
                Connection connection = ConnectionCreator.getConnection();
                //объект для обращения к базе
                Statement statement = connection.createStatement()
        ) {
            int addedTests = statement.executeUpdate(createUserSQL);
            if (addedTests == 1) {
                /*LAST_INSERT_ID() Возвращает последнюю автоматически
                сгенерированную величину, которая была внесена в столбец
                AUTO_INCREMENT*/
                //извлечение строки с последним  id
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet первую строку
                if (resultSet.next())
                    test.setID(resultSet.getInt(1));
            }
        }
        return test;
    }

    public Test read(int id) throws SQLException {
        Test testResult = null;
        String readTestSQL = "SELECT * FROM tests where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readTestSQL);
            if (resultSet.next()) {
                testResult = new Test(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Subject"),
                        resultSet.getInt("Questions"));
            }
        }
        return testResult;
    }

    public Test update(Test test) throws SQLException {
        Test testResult = null;
        String updateUserSQL = String.format(
                "UPDATE tests SET Name = '%s', Subject = '%s', Questions = '%d', Tests_amount='%d' WHERE tests.ID = %d",
                test.getName(), test.getSubject(), test.getQuestions(), test.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                testResult = test;
        }
        return testResult;
    }

    public boolean delete(Test test) throws SQLException {
        String deleteTestSQL = String.format("DELETE FROM tests WHERE tests.ID = %d", test.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteTestSQL) == 1);
        }
    }

}

