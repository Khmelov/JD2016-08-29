package by.it.vashukevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


public class CheckSelect {
    public static void main(String[] args) {
        try {
            Driver driver=new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection=
                     DriverManager.getConnection(CN.UR_DB,CN.USER_DB,CN.PASSWORD_DB);

             Statement statement=connection.createStatement();){
            statement.executeUpdate(
                    "INSERT INTO Students(Surname,Name,Age,Sex,FK_Cours,Role)"+
                            "VALUES('Чижиков','Владимир',31,'муж',2,2);"  );
                   // "DELETE FROM Students where IdStudents=6;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
