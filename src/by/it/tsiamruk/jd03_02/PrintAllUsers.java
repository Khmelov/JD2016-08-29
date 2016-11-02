package by.it.tsiamruk.jd03_02;

import by.it.tsiamruk.jd03_01.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by waldemar on 30/10/2016.
 */
public class PrintAllUsers {
    static void print(){
            String sqlRequest = "SELECT * FROM users, role WHERE users.FK_role = role.ID;";

            try(Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sqlRequest);
                while (resultSet.next()){
                    System.out.printf(Locale.ENGLISH, "ID = %d | Login: %s | Password: %s | Email: %s | RoleID: %d| RoleName: %s %n",
                            resultSet.getInt("ID"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getInt("FK_role"),
                            resultSet.getString("role"));
                }
                System.out.print("Общее число пользователей: " + resultSet.getMetaData().getColumnCount());
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){
            String request = "SELECT * FROM role;";
            ResultSet resultSet1 = statement.executeQuery(request);
            System.out.println(" всего возможных ролей: " + resultSet1.getMetaData().getColumnCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

