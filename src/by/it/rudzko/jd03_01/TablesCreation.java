package by.it.rudzko.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TablesCreation {


    public static void main(String[ ] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate(
                    String.format("CREATE TABLE olgarudzko.Roles ( ID INT NULL AUTO_INCREMENT , Role VARCHAR(20) ," +
                            " PRIMARY KEY (ID)) ENGINE = InnoDB;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE olgarudzko.Users ( ID INT NULL AUTO_INCREMENT , Name VARCHAR(30) " +
                            "NOT NULL , FK_Role INT NOT NULL , BirthDate YEAR NOT NULL , Sex CHAR NOT NULL , " +
                            "PRIMARY KEY (ID), FOREIGN KEY (FK_Role) REFERENCES Roles(ID)) ENGINE = InnoDB;")
            );

            statement.executeUpdate(
                    String.format("CREATE TABLE olgarudzko.Readership ( ID INT NULL AUTO_INCREMENT , Audience VARCHAR(20)" +
                            " NOT NULL , PRIMARY KEY (ID)) ENGINE = InnoDB;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE olgarudzko.Periodicals ( ID INT NULL AUTO_INCREMENT , Title VARCHAR(20)" +
                            " NOT NULL , SubIndex INT NOT NULL , FK_Readership INT NOT NULL , FK_Added INT " +
                            "NOT NULL , PRIMARY KEY (ID) , FOREIGN KEY (FK_Readership) REFERENCES Readership(ID) , " +
                            "FOREIGN KEY (FK_Added) REFERENCES Users(ID)) ENGINE = InnoDB;")
            );
            statement.executeUpdate(
                    String.format("CREATE TABLE olgarudzko.Subscription ( ID INT NULL AUTO_INCREMENT , FK_Subscriber INT " +
                            "NOT NULL , FK_Periodical INT NOT NULL , PRIMARY KEY (ID) , FOREIGN KEY (FK_Subscriber)" +
                            " REFERENCES Users(ID) , FOREIGN KEY (FK_Periodical) REFERENCES Periodicals(ID)) ENGINE = InnoDB;")
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Tables created.");

    }
}
