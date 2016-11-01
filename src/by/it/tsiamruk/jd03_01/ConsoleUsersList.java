package by.it.tsiamruk.jd03_01;

import by.it.tsiamruk.jd03_01.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by waldemar on 27/10/2016.
 */
public class ConsoleUsersList {
    static void readUsersList() throws SQLException{
        String sqlRequest = "SELECT * FROM users, role WHERE users.FK_role = role.ID;";

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sqlRequest);
            while (resultSet.next()){
                System.out.printf(Locale.ENGLISH, "ID = %d | Login: %s | Password: %s | Email: %s | RoleID: %d| RoleName: %s %n",
                        resultSet.getInt("ID"),resultSet.getString("login"),resultSet.getString("password"),resultSet.getString("email"),resultSet.getInt("FK_role"),resultSet.getString("Role"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
