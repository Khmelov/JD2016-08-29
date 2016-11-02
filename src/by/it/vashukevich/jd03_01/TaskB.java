package by.it.vashukevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskB {
    public static void main(String[] args) {
        try {
            Driver driver=new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection=DriverManager.getConnection(
                CN.UR_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement=connection.createStatement();){
             ResultSet resultSet=statement.executeQuery("select * from Students,Role where Students.Role=Role.ID;");
            while(resultSet.next()){
               /* String out="ID"+resultSet.getInt("IdStudents")+"\n"+"Surname"+resultSet.getString("Surname")
                        +"\n"+"Name"+resultSet.getString("Name")+"\n"+"Email"+resultSet.getString("Email")+"\n"
                        +"Age"+resultSet.getString("Age")+"\n"+"Sex"+resultSet.getString("Sex")+"\n"+"FK_Coures"
                        +resultSet.getString("FK_Coures")+"\n"+"Role"+resultSet.getString("Role");*/
                System.out.printf("ID: %s; Surname: %s; Name: %s; E-mail: %s; Age: %s; Sex: %s; FK_Coures: %s; Role: %s\n",
                        resultSet.getInt("IdStudents"),resultSet.getString("Surname"),resultSet.getString("Name"),
                        resultSet.getString("Email"),resultSet.getString("Age"),resultSet.getString("Sex"),
                        resultSet.getString("FK_Coures"),resultSet.getString("Role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
