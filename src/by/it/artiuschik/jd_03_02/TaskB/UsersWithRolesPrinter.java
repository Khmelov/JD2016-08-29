package by.it.artiuschik.jd_03_02.TaskB;
import by.it.artiuschik.jd_03_02.utils.UserRoleConnector;
import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersWithRolesPrinter {
    public static void main(String[] args)
    {
        int usersCount;
        int rolesCount;
        try{
            Connection connection= ConnectionCreator.getConnection();
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM users";
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next())
            {
                String out = resultSet.getString("Name") + ", " + resultSet.getString("Surname") +", "+UserRoleConnector.getRole(resultSet.getInt("FK_ROLE"),connection);
                System.out.println(out);
            }
            //Count of users&roles
            resultSet=statement.executeQuery(sql);
            resultSet.last();//указатель на последней строчке resultSet
            usersCount=resultSet.getRow();//номер этой строчки,т.е. размер resultSet
            System.out.println("Количество пользователей: "+usersCount);
            sql="SELECT * FROM roles";
            resultSet=statement.executeQuery(sql);
            resultSet.last();
            rolesCount=resultSet.getRow();
            System.out.println("Количество ролей: "+rolesCount);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
