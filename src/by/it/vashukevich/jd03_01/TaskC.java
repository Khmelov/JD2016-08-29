package by.it.vashukevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskC {
    public static void main(String[] args) {
        try {
            Driver driver=new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection=DriverManager.getConnection(CN.UR_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement=connection.createStatement();){
            String dropdb=String.format("drop database elective");
             statement.executeUpdate(dropdb);
            //создание БД
            String creatDB=String.format("create database elective;");
            statement.executeUpdate(creatDB);
            statement.executeUpdate(String.format("use elective"));

            //создаём таблицы
            statement.executeUpdate(String.format("create table Courses (\n" +
                    "  IdCourses INT NOT NULL AUTO_INCREMENT,\n" +
                    "  Name VARCHAR(250) NOT NULL,\n" +
                    "  PRIMARY KEY (IdCourses))"));

            statement.executeUpdate(String.format("create table Students (\n" +
                    "  IdStudents INT NOT NULL AUTO_INCREMENT,\n" +
                    "  Surname VARCHAR(128) NOT NULL,\n" +
                    "  Name VARCHAR(128) NOT NULL,\n" +
                    "  Email VARCHAR(45) NULL,\n" +
                    "  Age INT NULL,\n" +
                    "  Sex VARCHAR(10) NOT NULL,\n" +
                    "  FK_Coures INT NOT NULL,\n" +
                    "  Role INT NOT NULL,\n" +
                    "  PRIMARY KEY (IdStudents))"));

            statement.executeUpdate(String.format("create table Lecture (\n" +
                    "  IdLecture INT NOT NULL AUTO_INCREMENT,\n" +
                    "  Surname VARCHAR(128) NOT NULL,\n" +
                    "  Name VARCHAR(128) NOT NULL,\n" +
                    "  Patronymic VARCHAR(128) NOT NULL,\n" +
                    "  Email VARCHAR(45) NULL,\n" +
                    "  Sex VARCHAR(10) NOT NULL,\n" +
                    "  Course INT NOT NULL,\n" +
                    "  Role INT NOT NULL,\n" +
                    "  PRIMARY KEY (IdLecture))"));

            statement.executeUpdate(String.format("CREATE TABLE Role (\n" +
                    "  Id INT NOT NULL AUTO_INCREMENT,\n" +
                    "  Name VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (Id))"));

            //заполняем таблицы
            statement.executeUpdate("INSERT INTO Courses (IdCourses, Name) VALUES (1, 'Java Develope');");
            statement.executeUpdate("INSERT INTO Courses (IdCourses, Name) VALUES (2, 'Physics');");
            statement.executeUpdate("INSERT INTO Courses (IdCourses, Name) VALUES (3, 'Mathematics');");

            statement.executeUpdate("INSERT INTO Role (Id, Name) VALUES (1, 'преподаватель');");
            statement.executeUpdate("INSERT INTO Role (Id, Name) VALUES (2, 'студент');");

            statement.executeUpdate("INSERT INTO Students (IdStudents,Surname,Name,Email,Age,Sex,FK_Coures,Role) " +
                    "VALUES (1,'Вашукевич','Владимир','vashukevich@tut.by', 31, 'муж', 1, 2);");
            statement.executeUpdate("INSERT INTO Students (IdStudents,Surname,Name,Email,Age,Sex,FK_Coures,Role)" +
                    " VALUES (2, 'Сидоров', 'Андрей', 'cidor@yandex.ru', 25, 'муж', 1, 2);");
            statement.executeUpdate("INSERT INTO Students (IdStudents,Surname,Name,Email,Age,Sex,FK_Coures,Role)" +
                    " VALUES (3, 'Петров ', 'Петр', 'petyunya@mail.ru', 22, 'муж', 3, 2);");

            statement.executeUpdate("INSERT INTO Lecture (IdLecture,Surname,Name,Patronymic ,Email,Sex,Course,Role)" +
                    " VALUES (1, 'Хмелов', 'Александр', 'Геннадьевич', NULL, 'муж', 1, 1);");
            statement.executeUpdate("INSERT INTO Lecture(IdLecture,Surname,Name,Patronymic ,Email,Sex,Course,Role)" +
                    " VALUES (2, 'Алексеев', 'Алексей', 'Алексевич', NULL, 'муж', 2, 1);");
            statement.executeUpdate("INSERT INTO Lecture (IdLecture,Surname,Name,Patronymic ,Email,Sex,Course,Role)" +
                    " VALUES (3, 'Червякова', 'Алефтина', 'Петровна', NULL, 'жен', 3, 1);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
