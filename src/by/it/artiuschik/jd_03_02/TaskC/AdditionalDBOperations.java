package by.it.artiuschik.jd_03_02.TaskC;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.*;
import by.it.artiuschik.jd_03_02.crud.*;

import java.sql.Connection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.lang.String.*;

public class AdditionalDBOperations {
    private static void createAllTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        //создание таблицы пользователей
        String createTableSQL =
                format("CREATE TABLE users (ID INT NULL AUTO_INCREMENT ,Name VARCHAR(500) NOT NULL ,Surname VARCHAR(100) NOT NULL ,Password INT NOT NULL,Tests_amount INT NOT NULL , Balls INT NOT NULL , FK_ROLE INT NOT NULL , PRIMARY KEY (ID))");
        statement.executeUpdate(createTableSQL);
        //создание таблицы ролей
        createTableSQL =
                format("CREATE TABLE roles (ID INT NULL AUTO_INCREMENT ,Role_name VARCHAR(500) NOT NULL , PRIMARY KEY (ID))");
        statement.executeUpdate(createTableSQL);
        //создание таблицы тестов
        createTableSQL =
                format("CREATE TABLE tests (ID INT NULL AUTO_INCREMENT , Name VARCHAR(500) NOT NULL , Subject VARCHAR(100) NOT NULL , Questions INT NOT NULL , PRIMARY KEY (ID))");
        statement.executeUpdate(createTableSQL);
        //создание таблицы вопросов
        createTableSQL =
                format("CREATE TABLE questions (ID INT NULL AUTO_INCREMENT , Text VARCHAR(500) NOT NULL , Subject VARCHAR(100) NOT NULL , Balls INT NOT NULL , PRIMARY KEY (ID))");
        statement.executeUpdate(createTableSQL);
    }

    private static void deleteAllTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        //Удаление таблицы ролей
        String deleteTableSQL =
                format("DROP TABLE IF EXISTS users ");
        statement.executeUpdate(deleteTableSQL);
        //Удаление таблицы пользователей
        deleteTableSQL =
                format("DROP TABLE IF EXISTS roles ");
        statement.executeUpdate(deleteTableSQL);
        //Удаление таблицы вопросов
        deleteTableSQL =
                format("DROP TABLE IF EXISTS questions ");
        statement.executeUpdate(deleteTableSQL);
        //Удаление таблицы тестов
        deleteTableSQL =
                format("DROP TABLE IF EXISTS tests ");
        statement.executeUpdate(deleteTableSQL);
    }

    //Заполнение через вызов конструктора  Bean
    private static void fillTables() throws SQLException {
        //заполнение  users
        UserCRUD userCRUD = new UserCRUD();
        User user = new User(0, "Петрова", "Анастасия", 1123, 1, 10, 1);
        userCRUD.create(user);
        user = new User(0, "Иван", "Иванов", 1232, 3, 30, 1);
        userCRUD.create(user);
        user = new User(0, "Петр", "Петров", 1245, 3, 30,1);
        userCRUD.create(user);
        user = new User(0, "Василий", "Васильев", 6785, 3, 30, 1);
        userCRUD.create(user);
        //заполнение  tests
        TestCRUD testCRUD=new TestCRUD();
        Test test = new Test(0,"Законы Ньютона","Физика",5);
        testCRUD.create(test);
        test = new Test(0,"Термодинамика","Физика",5);
        testCRUD.create(test);
        test = new Test(0,"Неметаллы","Химия",5);
        testCRUD.create(test);
        test = new Test(0,"Законы Ньютона","Физика",5);
        testCRUD.create(test);
    }

    //Заполнение через парсинг из  xml файла
    private static void fillTablesXML() {
        List<User> users;
        List<Test> tests;
        List<Question> questions;
        List<Role> roles;
        UserCRUD userCRUD = new UserCRUD();
        TestCRUD testCRUD = new TestCRUD();
        QuestionCRUD questionCRUD = new QuestionCRUD();
        RoleCRUD roleCRUD = new RoleCRUD();
        try {
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader fileReader = new FileReader("src/by/it/artiuschik/jd_03_02/extra" +
                    "/xml/Users.xml");
            Users us = (Users) u.unmarshal(fileReader);
            users = us.getUser();
            jc = JAXBContext.newInstance(Tests.class);
            u = jc.createUnmarshaller();
            fileReader = new FileReader("src/by/it/artiuschik/jd_03_02/extra" +
                    "/xml/Tests.xml");
            Tests ts = (Tests) u.unmarshal(fileReader);
            tests = ts.getTest();
            jc = JAXBContext.newInstance(Questions.class);
            u = jc.createUnmarshaller();
            fileReader = new FileReader("src/by/it/artiuschik/jd_03_02/extra" +
                    "/xml/Questions.xml");
            Questions qs = (Questions) u.unmarshal(fileReader);
            questions = qs.getQuestion();
            jc = JAXBContext.newInstance(Roles.class);
            u = jc.createUnmarshaller();
            fileReader = new FileReader("src/by/it/artiuschik/jd_03_02/extra" +
                    "/xml/Roles.xml");
            Roles rs = (Roles) u.unmarshal(fileReader);
            roles = rs.getRole();
            for (User user : users) {
                userCRUD.create(user);
            }
            for (Role role : roles) {
                roleCRUD.create(role);
            }
            for (Test test : tests) {
                testCRUD.create(test);
            }
            for (Question question : questions) {
                questionCRUD.create(question);
            }
        } catch (JAXBException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //данные для перезаполнения через конструктор
    public static void reset() throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        deleteAllTables(connection);
        createAllTables(connection);
        fillTables();
    }

    //данные для перезаполнения через XML
    public static void resetXML() throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        deleteAllTables(connection);
        createAllTables(connection);
        fillTablesXML();

    }
}
