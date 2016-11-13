package by.it.rudzko._Project.java.Strings;


public interface SqlRequests {

    String DROP_TABLES = "DROP TABLE IF EXISTS Subscription, Periodicals, Readership, Users, Roles";
    String CR_TABLE_ROLES = "CREATE TABLE olgarudzko.Roles ( ID INT NULL AUTO_INCREMENT , Role VARCHAR(20) ," +
            " PRIMARY KEY (ID)) ENGINE = InnoDB;";
    String CR_TABLE_USERS = "CREATE TABLE olgarudzko.Users ( ID INT NULL AUTO_INCREMENT , Name VARCHAR(30) " +
            "NOT NULL , Password VARCHAR(30) NOT NULL, FK_Role INT NOT NULL , BirthYear INT(4) NOT NULL , Sex CHAR NOT NULL , " +
            "PRIMARY KEY (ID), FOREIGN KEY (FK_Role) REFERENCES Roles(ID)) ENGINE = InnoDB;";
    String CR_TABLE_READERSHIP = "CREATE TABLE olgarudzko.Readership ( ID INT NULL AUTO_INCREMENT , Audience VARCHAR(20)" +
            " NOT NULL , PRIMARY KEY (ID)) ENGINE = InnoDB;";
    String CR_TABLE_PERIODICALS = "CREATE TABLE olgarudzko.Periodicals ( ID INT NULL AUTO_INCREMENT , Title VARCHAR(30)" +
            " NOT NULL , SubIndex INT NOT NULL , FK_Readership INT NOT NULL , FK_Added INT " +
            "NOT NULL , PRIMARY KEY (ID) , FOREIGN KEY (FK_Readership) REFERENCES Readership(ID) , " +
            "FOREIGN KEY (FK_Added) REFERENCES Users(ID)) ENGINE = InnoDB;";
    String CR_TABLE_SUBSCRIPTION = "CREATE TABLE olgarudzko.Subscription ( ID INT NULL AUTO_INCREMENT , FK_Subscriber INT " +
            "NOT NULL , FK_Periodical INT NOT NULL , PRIMARY KEY (ID) , FOREIGN KEY (FK_Subscriber)" +
            " REFERENCES Users(ID) , FOREIGN KEY (FK_Periodical) REFERENCES Periodicals(ID)) ENGINE = InnoDB;";
    String WHERE_READERSHIP = "WHERE Periodicals.FK_Readership='%d'";
    String WHERE_ADDED = "WHERE Periodicals.FK_Added='%d'";
    String WHERE_SUBSCRIBER_AND_PERIODICAL = "WHERE FK_Subscriber='%d' and FK_Periodical='%d'";
    String WHERE_ADMINISTRATOR = "WHERE Roles.Role='Administrator'";
    String WHERE_ROLE = "WHERE Users.FK_Role='%d'";
    String WHERE_NOT_ROLE = "WHERE Users.FK_Role!='%d'";
    String WHERE_NAME_PASSWORD = "WHERE Name='%s' and Password='%s'";
    String WHERE_SUBSCRIBER = "WHERE FK_Subscriber='%d'";
    String WHERE_NAME = "WHERE Name='%s'";
    String WHERE_ROLE_IS_SUBSCRIBER = "WHERE Role='Subscriber'";
    String INSERT_INTO_READERSHIP = "insert into Readership(Audience) value('%s');";
    String WHERE_ID = "WHERE ID='%d'";
    String UPDATE_READERSHIP_SET = "UPDATE Readership SET Audience= '%s' WHERE Readership.ID = %d";
    String DELETE_FROM_READERSHIP = "DELETE FROM Readership WHERE Readership.ID = %d";
    String DELETE_FROM_PERIODICALS = "DELETE FROM Periodicals WHERE Periodicals.ID = %d";
    String WHERE_PERIODICAL = "WHERE Subscription.FK_Periodical='%d'";
    String DB_FKADDED = "FK_Added";
    String SELECT_FROM_READERSHIP_WHERE_ID = "SELECT * FROM Readership WHERE ID='%d'";
    String SELECT_FROM_ROLES_WHERE_ID = "SELECT * FROM Roles WHERE ID='%d'";
    String UPDATE_PERIODICALS_SET = "UPDATE Periodicals SET Title = '%s', SubIndex = '%d', FK_Readership='%d', FK_Added='%d' WHERE Periodicals.ID = %d";
    String INSERT_INTO_PERIODICALS = "insert into Periodicals(Title, SubIndex, FK_Readership, FK_Added) values('%s', '%d', '%d', '%d');";
    String SELECT_FROM_PERIODICALS = "SELECT * FROM Periodicals ";
    String SELECT_FROM_USERS_WHERE_ID = "SELECT * FROM Users WHERE ID='%d'";
    String SELECT_FROM_ROLES = "SELECT * FROM Roles ";
    String DELETE_FROM_ROLES = "DELETE FROM Roles WHERE Roles.ID = %d";
    String UPDATE_ROLES_SET = "UPDATE Roles SET Role= '%s' WHERE Roles.ID = '%d'";
    String INSERT_INTO_ROLES = "insert into Roles(Role) value('%s');";
    String INSERT_INTO_SUBSCRIPTION = "insert into Subscription(FK_Subscriber, FK_Periodical) values('%d', '%d');";
    String UPDATE_SUBSCRIPTION_SET = "UPDATE Subscription SET FK_Subscriber = '%d', FK_Periodical='%d' WHERE Subscription.ID = '%d'";
    String DELETE_FROM_SUBSCRIPTION = "DELETE FROM Subscription WHERE Subscription.ID = '%d'";
    String SELECT_FROM_SUBSCRIPTION = "SELECT * FROM Subscription ";
    String SELECT_FROM_PERIODICALS_WHERE_ID = "SELECT * FROM Periodicals WHERE ID='%d'";
    String SELECT_FROM_READERSHIP = "SELECT * FROM Readership ";
    String UPDATE_USERS_SET = "UPDATE Users SET Name = '%s', Password='%s', FK_Role = '%d', BirthYear='%d', Sex='%s' WHERE Users.ID = '%d'";
    String DELETE_FROM_USERS = "DELETE FROM Users WHERE Users.ID = '%d'";
    String INSERT_INTO_USERS = "insert into Users(Name, Password, FK_Role, BirthYear, Sex) values('%s', '%s', '%d', '%d', '%s');";
    String SELECT_FROM_USERS = "SELECT * FROM Users ";
}
