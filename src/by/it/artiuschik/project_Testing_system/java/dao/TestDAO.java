package by.it.artiuschik.project_Testing_system.java.dao;

import by.it.artiuschik.project_Testing_system.java.beans.Test;
import by.it.artiuschik.project_Testing_system.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Author Artiuschik Elena
 */
public class TestDAO extends AbstractDAO implements InterfaceDAO<Test> {
    /**
     *
     * @param test test to add to database
     * @return success of adding
     */
    //CREATE
    @Override
    public boolean create(Test test) {
        test.setID(0);
        String createTestSQL = String.format(
                "insert into tests(Name,Subject,Questions) values('%s','%s','%d');",
                test.getName(), test.getSubject(), test.getQuestions()
        );
        test.setID(executeUpdate(createTestSQL));
        return (test.getID() > 0);
    }

    /**
     *
     * @param id test  id
     * @return read test
     */
    //READ
    @Override
    public Test read(int id) {
        List<Test> tests = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (tests.size() > 0) {
            return tests.get(0);
        } else
            return null;
    }

    /**
     *
     * @param test test to update
     * @return success of updating
     */
    //UPDATE
    @Override
    public boolean update(Test test) {
        String updateUserSQL = String.format(
                "UPDATE tests SET Name = '%s', Subject = '%s', Questions = '%d', WHERE tests.ID = %d",
                test.getName(), test.getSubject(), test.getQuestions(), test.getID()
        );
        return (0 < executeUpdate(updateUserSQL));
    }

    /**
     *
     * @param test to delete
     * @return success of deleting
     */
    //DELETE
    @Override
    public boolean delete(Test test) {
        String deleteTestSQL = String.format("DELETE FROM tests WHERE tests.ID = %d", test.getID());
        return (0 < executeUpdate(deleteTestSQL));
    }

    /**
     *
     * @param WHERE condition
     * @return tests answer condition
     */
    @Override
    public List<Test> getAll(String WHERE) {
        List<Test> tests = new ArrayList<>();
        String sql = "SELECT * FROM tests " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Test test = new Test();
                test.setID(rs.getInt("ID"));
                test.setName(rs.getString("Name"));
                test.setSubject(rs.getString("Subject"));
                test.setQuestions(rs.getInt("Questions"));
                tests.add(test);
            }
        } catch (SQLException e) {
            //логгирование SQLException(e);
        }
        return tests;
    }

    /**
     *
     * @param ID test id
     * @return test with id
     */
    public Test getTest(int ID)
    {
        List<Test> tests = getAll("WHERE ID=" + ID + " LIMIT 0,1");
        if (tests.size() > 0) {
            return tests.get(0);
        } else
            return null;
    }


}