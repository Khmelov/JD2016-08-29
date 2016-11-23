package by.it.artiuschik.jd_03_02.crud;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.it.artiuschik.jd_03_02.utils.Updater.executeUpdate;

public class TestCRUD {
    public boolean create(Test test) {
        test.setID(0);
        String createTestSQL = String.format(
                "insert into tests(Name,Subject,Questions) values('%s','%s','%d');",
                test.getName(), test.getSubject(), test.getQuestions()
        );
        test.setID(executeUpdate(createTestSQL));
        return (test.getID() > 0);
    }

    public Test read(int id) {
        List<Test> tests = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (tests.size() > 0) {
            return tests.get(0);
        } else
            return null;
    }

    public boolean update(Test test) {
        String updateUserSQL = String.format(
                "UPDATE tests SET Name = '%s', Subject = '%s', Questions = '%d', WHERE tests.ID = %d",
                test.getName(), test.getSubject(), test.getQuestions(), test.getID()
        );
        return (0 < executeUpdate(updateUserSQL));
    }
    public boolean delete(Test test) {
        String deleteTestSQL = String.format("DELETE FROM tests WHERE tests.ID = %d", test.getID());
        return (0 < executeUpdate(deleteTestSQL));
    }

    public List<Test> getAll(String WHERE) {
        List<Test> tests = new ArrayList<>();
        String sql = String.format("SELECT * FROM tests %s ;",WHERE);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Test test = new Test();
                test.setID(rs.getInt("ID"));
                test.setQuestions(rs.getInt("Questions"));
                test.setName(rs.getString("Name"));
                test.setSubject(rs.getString("Subject"));
                tests.add(test);
            }
        } catch (SQLException e) {
            //логгирование SQLException(e);
        }
        return tests;
    }
}

