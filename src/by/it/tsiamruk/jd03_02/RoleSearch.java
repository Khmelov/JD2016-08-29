package by.it.tsiamruk.jd03_02;

import by.it.tsiamruk.jd03_01.connection.ConnectionCreator;

import java.sql.*;

/**
 * Created by waldemar on 30/10/2016.
 */
public class RoleSearch {

    static void roleSearch(String search){
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT role.ID FROM wtsiamruk.role WHERE role.role ='" + search + "'");
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("ID"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        if (search.equals("exit"))
            System.exit(0);
    }
}