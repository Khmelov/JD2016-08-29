package by.it.sukora.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Sukora Stas.
 */
public class TaskB {
    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/hospital" +
            "?useUnicode=true&amp;characterEncoding=UTF-8";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            statement.execute("insert into role(Profession)\n" +
                    "            values('director'),\n" +
                    "                    ('Administrator'),\n" +
                    "                    ('doctor therapist'),\n" +
                    "                    ('Gynecologist');");

            statement.execute("insert into users(FirsName,LastName,Email,id_role,id_logpass)\n" +
                    "            values('Sukora','Stas','st.sukora@gmail.com',10,1),\n" +
                    "                    ('Nikita','Chekita','Nikita@mail.ru',11,1),\n" +
                    "                    ('Ivanov','Petya','Ivanov@yandex.tu',11,1),\n" +
                    "                    ('Sasha','Belonog','Belonog@gmail.com',13,1)" + ";");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {

                System.out.printf("ID: %s; Profession: %s;\n",

                        resultSet.getInt("id"), resultSet.getString("Profession"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
