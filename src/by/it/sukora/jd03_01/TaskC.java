package by.it.sukora.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Sukora Stas.
 */
public class TaskC {
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

            // Создание БД
            statement.execute(String.format("CREATE DATABASE test_hospital"));
            System.out.println("База данных test_hospital создана");
            //использование БД
            statement.execute(String.format("USE test_hospital"));
            System.out.println("Использвание базы данных test_hospital");
            // Удаление БД
            //        statement.execute(String.format("DROP DATABASE test_hospital"));
            //      System.out.println("БД test_hospital удалена");


            // Создание таблицы logpas
            statement.execute("CREATE TABLE logpas (\n" +
                    " id int NOT NULL AUTO_INCREMENT,\n" +
                    " Login varchar(100) NOT NULL,\n" +
                    " Password varchar(100) NOT NULL,\n" +
                    " PRIMARY KEY (id)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1\n");
            System.out.println("Таблица logpas создана");

            // Добавление данных в logpas
            statement.execute("INSERT INTO logpas (Login,Password) VALUES\n" +
                    "('test','test'),\n" +
                    "('stas','123'),\n" +
                    "('123','321'),\n" +
                    "('123321','123321');");
            System.out.println("Таблица logpas заполнена");

            // Создание таблицы address
            statement.execute(String.format("CREATE TABLE address (\n" +
                    " id int NOT NULL AUTO_INCREMENT, \n" +
                    " Country varchar(30) NOT NULL,\n" +
                    " City varchar(30) NOT NULL,\n" +
                    " Street varchar(100) NOT NULL,\n" +
                    " Floor int(11) NOT NULL,\n" +
                    " Flat int(11) NOT NULL,\n PRIMARY KEY (`id`)\n) ENGINE=InnoDB DEFAULT CHARSET=latin1"));
            System.out.println("Таблица address создана");

            // Добавление данных в address
            statement.execute("INSERT INTO address (Country,City,Street,Floor,Flat) VALUES\n" +
                    "('Беларусь','Минск','Одоевского',5,93),\n" +
                    "('Беларусь','Могилёв','Комсомольская',4,16),\n" +
                    "('Беларусь','Минск','Кропоткина',16,31),\n" +
                    "('Германия','Берлин','Побеждённая',40,55);");
            System.out.println("Таблица address заполнена");

            //Создание таблицы diagnosis
            statement.execute("CREATE TABLE diagnosis (\n" +
                    " id int NOT NULL AUTO_INCREMENT,\n" +
                    " Disease varchar(100) NOT NULL,\n" +
                    " Siptomps varchar(200) NOT NULL,\n" +
                    " PeriodStart date NOT NULL,\n" +
                    " PeriodEnd date NOT NULL,\n" +
                    " Recipe varchar(200) NOT NULL,\n" +
                    " PRIMARY KEY (id)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1");
            System.out.println("Таблица diagnosis создана");

            //Добавление данных в diagnosis
            statement.execute("INSERT INTO diagnosis (Disease,Siptomps,PeriodStart,PeriodEnd,Recipe) VALUES\n" +
                    "('Gripp','Head bol','2015-01-01','2015-01-08','purgen'),\n" +
                    "('test','test','2015-01-01','2015-01-08','test');");
            System.out.println("Таблица diagnosis заполнена");

            // Создание таблицы patients
            statement.execute("CREATE TABLE patients (\n" +
                    " id int NOT NULL AUTO_INCREMENT,\n" +
                    " FirstName varchar(100) NOT NULL,\n" +
                    " LastName varchar(100) NOT NULL,\n" +
                    " DateOfBirth date NOT NULL,\n" +
                    " Sex varchar(3) NOT NULL,\n" +
                    " Email varchar(100) NOT NULL,\n" +
                    " PasportNum varchar(100) NOT NULL,\n" +
                    " id_logpass int NOT NULL,\n" +
                    " id_address int NOT NULL,\n" +
                    " PRIMARY KEY (id)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1");
            System.out.println("Таблица patients создана");

            // Добавление данных в patients
            statement.execute("INSERT INTO patients (FirstName,LastName,DateOfBirth,Sex,Email,PasportNum,id_logpass,id_address) VALUES\n" +
                    "('Sukora','Stas','1997-05-16','M','st.sukora','VP3245583',1,1),\n" +
                    "('Sasha','Belonog','1997-04-21','M','@bel.com','gh945235',1,1),\n" +
                    "('Tarasova','Alena','1995-11-06','M','fghfgh','fghfgh',1,1),\n" +
                    "('gfsdgs','sfgsfdg','1888-01-01','fgd','dfg','dfg',1,1);");
            System.out.println("Таблица patients заполнена");

            // Создание таблицы medicalcard
            statement.execute("CREATE TABLE medicalcard (\n" +
                    " id int NOT NULL AUTO_INCREMENT,\n" +
                    " id_patient int NOT NULL,\n" +
                    " id_diagnosis int NOT NULL,\n" +
                    " PRIMARY KEY (id)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1");
            System.out.println("Таблица medicalcard создана");

            // Добавление данных в medicalcard
            statement.execute("INSERT INTO medicalcard (id_patient,id_diagnosis) VALUES\n" +
                    "(1, 2),\n" +
                    "(2, 3);");
            System.out.println("Таблица medicalcard заполнена");

            // Создание таблицы role
            statement.execute("CREATE TABLE role (\n" +
                    " id int NOT NULL AUTO_INCREMENT,\n" +
                    " Profession varchar(100) NOT NULL,\n" +
                    " PRIMARY KEY (id)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1");
            System.out.println("Таблица role создана");

            // Добавление данных в role
            statement.execute("insert into role(Profession)\n" +
                    "values('director'),\n" +
                    "('Administrator'),\n" +
                    "('doctor therapist'),\n" +
                    "('Gynecologist');");
            System.out.println("Таблица role заполнена");

            // Создание таблицы users
            statement.execute("CREATE TABLE users (\n" +
                    " id int NOT NULL AUTO_INCREMENT,\n" +
                    " FirsName varchar(100) NOT NULL,\n" +
                    " LastName varchar(100) NOT NULL,\n" +
                    " Email varchar(150) NOT NULL,\n" +
                    " id_role int NOT NULL,\n" +
                    " id_logpass int NOT NULL,\n" +
                    " PRIMARY KEY (id)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1\n");
            System.out.println("Таблица users создана");

            // Добавление данных в users
            statement.execute("insert into users(FirsName,LastName,Email,id_role,id_logpass)\n" +
                    "            values('Sukora','Stas','st.sukora@gmail.com',10,1),\n" +
                    "                    ('Nikita','Chekita','Nikita@mail.ru',11,1),\n" +
                    "                    ('Ivanov','Petya','Ivanov@yandex.tu',11,1),\n" +
                    "                    ('Sasha','Belonog','Belonog@gmail.com',13,1)" + ";");
            System.out.println("Таблица users заполнена");

            System.out.println("Готово");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//
    }
}
