package by.it.vashukevich.project.java.dao;


import by.it.vashukevich.project.java.beans.Courses;
import by.it.vashukevich.project.java.connection.ConnectionCreater;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoursesDAO extends AbstractDAO implements InterfaceDAO<Courses> {
    @Override
    public Courses read(int id) {
        List<Courses> courses = getAll("WHERE IdCourses=" + id + " LIMIT 0,1");
        if (courses.size() > 0) {
            return courses.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Courses courses) {
        String sql = String.format(
                "insert INTO courses(Name)" +
                        "\n values('%s');",
                courses.getName()

        );
        courses.setId(executeUpdate(sql));
        return (courses.getId() > 0);
    }

    @Override
    public boolean update(Courses courses) {
        String sql = String.format(
                "UPDATE 'courses' SET" +
                        " 'Name' = '%s'," +
                        " WHERE 'courses'.'IdCourses' = %d",
                courses.getName(),
                courses.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Courses courses) {
        String sql = String.format(
                "DELETE FROM `courses` WHERE `courses`.`Id=%d;", courses.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Courses> getAll(String WHERE) {
        List<Courses> std=new ArrayList<>();
        String sql = "SELECT * FROM courses " + WHERE + " ;";
        try (Connection connection= ConnectionCreater.getConnection();
             Statement statement=connection.createStatement())
        {
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Courses courses=new Courses();
                courses.setId(resultSet.getInt("Id"));
                courses.setName(resultSet.getString("Name"));
                courses.setUser(resultSet.getInt("User"));
                std.add(courses);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return std;
    }
}
