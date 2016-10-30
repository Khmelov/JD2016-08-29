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
            String request = "SELECT * FROM role;";
            ResultSet resultSet = statement.executeQuery(request);
            ResultSetMetaData rsm = resultSet.getMetaData();
            while (resultSet.next()){
                if (search.equals("user")){
                    if ((resultSet.getInt("ID") == 2))
                        System.out.println("ID этого типа пользователя: " +resultSet.getInt("ID"));
                }
                if (search.equals("admin")){
                    if ((resultSet.getInt("ID"))==1)
                        System.out.println("ID этого типа пользователя: "+ resultSet.getInt("ID"));
                }
            }
            if (!search.equals("admin" )&& !search.equals("user"))
                System.out.println("Такого типа пользователя не существует");
            if (search.toLowerCase().equals("exit"))
                System.exit(0);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}