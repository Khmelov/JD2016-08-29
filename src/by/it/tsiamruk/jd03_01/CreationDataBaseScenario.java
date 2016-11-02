package by.it.tsiamruk.jd03_01;

import by.it.tsiamruk.jd03_01.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by waldemar on 28/10/2016.
 */
public class CreationDataBaseScenario {
    static void creationDataBase(){

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("CREATE DATABASE IF NOT EXISTS wtsiamruk;"));
            statement.executeUpdate(String.format("CREATE TABLE IF NOT EXISTS wtsiamruk.role (" +
                    "  ID INT(1) NOT NULL," +
                    "  role VARCHAR(100) NULL DEFAULT NULL," +
                    "  PRIMARY KEY (ID)," +
                    "  UNIQUE INDEX ID_UNIQUE (ID ASC))" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("CREATE TABLE IF NOT EXISTS wtsiamruk.users (" +
                    "  ID INT(1) NOT NULL AUTO_INCREMENT," +
                    "  login VARCHAR(18) NOT NULL," +
                    "  password VARCHAR(18) NOT NULL," +
                    "  email VARCHAR(64) NOT NULL," +
                    "  FK_role INT(1) NOT NULL," +
                    "  PRIMARY KEY (ID)," +
                    "  UNIQUE INDEX email_UNIQUE (email ASC)," +
                    "  UNIQUE INDEX login_UNIQUE (login ASC)," +
                    "  UNIQUE INDEX ID_UNIQUE (ID ASC)," +
                    "  INDEX fk_users_role_idx (FK_role ASC)," +
                    "  CONSTRAINT fk_users_role" +
                    "    FOREIGN KEY (FK_role)" +
                    "    REFERENCES wtsiamruk.role (ID)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("CREATE TABLE IF NOT EXISTS wtsiamruk.accounts (" +
                    "  id INT(1) NOT NULL AUTO_INCREMENT," +
                    "  amount DECIMAL(1,0) NOT NULL," +
                    "  users_ID INT(1) NOT NULL," +
                    "  PRIMARY KEY (id)," +
                    "  UNIQUE INDEX id_UNIQUE (id ASC)," +
                    "  INDEX fk_accounts_users1_idx (users_ID ASC)," +
                    "  CONSTRAINT fk_accounts_users1" +
                    "    FOREIGN KEY (users_ID)" +
                    "    REFERENCES wtsiamruk.users (ID)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;"));
            //что бы не добавлял каждый раз нового тестового пользователя
//           statement.executeUpdate("INSERT INTO wtsiamruk.users " +
//            "(login, password, email, FK_role)" +
//                    " VALUES ('usertest4', 'passtest4', 'mailtest4@test.com', 2);");
            //для удаления таблиц раскоментировать метод с текстом drop ...
//            statement.executeUpdate("drop table role,users,accounts;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
