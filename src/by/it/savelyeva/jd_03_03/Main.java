package by.it.savelyeva.jd_03_03;

import by.it.savelyeva.jd_03_03.connection.ConnectionCreator;
import by.it.savelyeva.jd_03_03.beans.User;
import by.it.savelyeva.jd_03_03.beans.Role;
import by.it.savelyeva.jd_03_03.beans.Rent;
import by.it.savelyeva.jd_03_03.custom_dao.DAO;
import by.it.savelyeva.jd_03_03.custom_dao.UserDAO;
import by.it.savelyeva.jd_03_03.generics_dao.UniversalDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by nato on 10/30/16.
 */
public class Main {

    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();
        recreateDB();
        try {
            demoUsersCustomDAO();

            demoUsersUniversalDAO();
            demoRolesUniversalDAO();
            demoRentsUniversalDAO();

        } catch (SQLException e) {
            logger.log(e.getMessage());
            e.printStackTrace();
        }


    }

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nTable 'users' - all entries:");
        List<User> users = new UserDAO().getAll("");
        for (User each: users) {
            System.out.println(each);
        }
    }

    public static void demoUsersCustomDAO() throws SQLException {
        DAO dao = DAO.getDAO();
        System.out.println("Users' roles: ");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0, "test_login", "test_password", "test-customDAO@example.com", 2,
                "Иван", "Иванов", null, "1970-01-01", 1, "TT000001", 1, "TT000002");

        if (dao.user.create(user)) System.out.println("\nCreated:" + user);
        showUsers();

        user = dao.user.getAll("WHERE email='test-customDAO@example.com'").get(0);
        user.setEmail("new-email@example.com");
        if (dao.user.update(user)) System.out.println("\nUpdated:" + user);
        showUsers();

        if (dao.user.delete(user)) System.out.println("\nDeleted:" + user);
        showUsers();
    }

    private static void demoUsersUniversalDAO() throws SQLException {

        UniversalDAO<User> dao = new UniversalDAO<>(new User(), "users");
        User user = new User(0, "test_login", "test_password", "test-universalDAO@example.com", 2,
                "Иван", "Иванов", null, "1970-01-01", 1, "TT000001", 1, "TT000002");

        dao.create(user);
        System.out.println("Created: " + user);

        dao.update(user);
        user.setEmail("new-email@example.com");
        System.out.println("Updated: " + user);

        if (dao.delete(user))
            System.out.println("Deleted: " + user);
        else System.out.println("Could not delete user \n" + user);

        System.out.println("\nAll entries:");
        for (User current: dao.getAll("")) {
            System.out.println(current);
        }

        int id = 1;
        System.out.printf("\nEntry N %d:\n", id);
        System.out.println(dao.read(id));
    }

    private static void demoRolesUniversalDAO() throws SQLException {

        UniversalDAO<Role> dao = new UniversalDAO<>(new Role(), "roles");
        Role role = new Role(0, "МодераторЪ");

        dao.create(role);
        System.out.println("Created: " + role);

        dao.update(role);
        role.setRole("Модератор");
        System.out.println("Updated: " + role);

        if (dao.delete(role))
            System.out.println("Deleted: " + role);
        else System.out.println("Could not delete role \n" + role);

        System.out.println("\nAll entries:");
        for (Role current: dao.getAll("")) {
            System.out.println(current);
        }

        int id = 2;
        System.out.printf("\nEntry N %d:\n", id);
        System.out.println(dao.read(id));
    }

    private static void demoRentsUniversalDAO() throws SQLException {

        UniversalDAO<Rent> dao = new UniversalDAO<>(new Rent(), "rents");
        Rent rent = new Rent(0, 3, 5, "2016-10-21", "2016-10-25", 70, true);

        dao.create(rent);
        System.out.println("Created: " + rent);

        dao.update(rent);
        rent.setEndDate("2016-10-28");
        System.out.println("Updated: " + rent);

        if (dao.delete(rent))
            System.out.println("Deleted: " + rent);
        else System.out.println("Could not delete rent \n" + rent);

        System.out.println("\nAll entries:");
        for (Rent current: dao.getAll("")) {
            System.out.println(current);
        }

        int id = 1;
        System.out.printf("\nEntry N %d:\n", id);
        System.out.println(dao.read(id));
    }

    private static void recreateDB() {
        for (String sql : getAllDropSQLs()) {
            //System.out.println(sql);
            runExecuteQuery(sql);
        }
        for (String sql : getAllCreateSQLs()) {
            //System.out.println(sql);
            runExecuteQuery(sql);
        }
        for (String sql : getAllInsertSQLs()) {
            //System.out.println(sql);
            runExecuteQuery(sql);
        }
    }

    private static void runExecuteQuery(String sql) {
        try(
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String[] getAllDropSQLs() {
        return new String[] {
                "DROP TABLE IF EXISTS addresses;",
                "DROP TABLE IF EXISTS cars;",
                "DROP TABLE IF EXISTS car_manufacturers;",
                "DROP TABLE IF EXISTS car_models;",
                "DROP TABLE IF EXISTS car_photos;",
                "DROP TABLE IF EXISTS car_transmissions;",
                "DROP TABLE IF EXISTS cities;",
                "DROP TABLE IF EXISTS colors;",
                "DROP TABLE IF EXISTS countries;",
                "DROP TABLE IF EXISTS dl_categories;",
                "DROP TABLE IF EXISTS driver_licenses;",
                "DROP TABLE IF EXISTS rents;",
                "DROP TABLE IF EXISTS roles;",
                "DROP TABLE IF EXISTS sex;",
                "DROP TABLE IF EXISTS streets;",
                "DROP TABLE IF EXISTS users;",
        };
    }

    private static String[] getAllCreateSQLs() {
        return new String[] {
                "CREATE TABLE IF NOT EXISTS addresses (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  idStreet int(11) NOT NULL,\n" +
                        "  building varchar(10) NOT NULL,\n" +
                        "  flat varchar(5) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;\n",
                "CREATE TABLE IF NOT EXISTS cars (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  idModel int(11) NOT NULL,\n" +
                        "  idTransmission int(11) NOT NULL,\n" +
                        "  idColor int(11) NOT NULL,\n" +
                        "  year int(11) NOT NULL,\n" +
                        "  fullPrice int(11) NOT NULL,\n" +
                        "  dayPrice int(11) NOT NULL,\n" +
                        "  comment varchar(255) DEFAULT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;",
                "CREATE TABLE IF NOT EXISTS car_manufacturers (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  manufacturer varchar(15) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;",
                "CREATE TABLE IF NOT EXISTS car_models (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  idManufacturer varchar(15) NOT NULL,\n" +
                        "  model varchar(15) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;",
                "CREATE TABLE IF NOT EXISTS car_transmissions (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  type varchar(10) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;",
                "CREATE TABLE IF NOT EXISTS cities (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  idCountry int(11) NOT NULL,\n" +
                        "  city varchar(15) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;",
                "CREATE TABLE IF NOT EXISTS colors (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  color varchar(25) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;",
                "CREATE TABLE IF NOT EXISTS countries (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  country varchar(25) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;\n",
                "CREATE TABLE IF NOT EXISTS dl_categories (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  category varchar(2) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;",
                "CREATE TABLE IF NOT EXISTS driver_licenses (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  serial varchar(10) NOT NULL,\n" +
                        "  issued date NOT NULL,\n" +
                        "  expire date NOT NULL,\n" +
                        "  idCategory int(11) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;",
                "CREATE TABLE IF NOT EXISTS rents (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  idCar int(11) NOT NULL,\n" +
                        "  idUser int(11) NOT NULL,\n" +
                        "  startDate date NOT NULL,\n" +
                        "  endDate date NOT NULL,\n" +
                        "  cost int(11) NOT NULL,\n" +
                        "  paid tinyint(1) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;",
                "CREATE TABLE IF NOT EXISTS roles (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  role varchar(20) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;",
                "CREATE TABLE IF NOT EXISTS sex (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  type varchar(35) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;",
                "CREATE TABLE IF NOT EXISTS streets (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  idCity int(11) NOT NULL,\n" +
                        "  street varchar(20) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;\n",
                "CREATE TABLE IF NOT EXISTS users (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  login varchar(20) NOT NULL,\n" +
                        "  password varchar(25) NOT NULL,\n" +
                        "  email varchar(255) NOT NULL,\n" +
                        "  idRole int(11) NOT NULL DEFAULT '2',\n" +
                        "  firstName varchar(20) NOT NULL,\n" +
                        "  lastName varchar(20) NOT NULL,\n" +
                        "  middleName varchar(20) DEFAULT NULL,\n" +
                        "  dateOfBirth date NOT NULL,\n" +
                        "  idSex tinyint(4) NOT NULL,\n" +
                        "  passport varchar(9) NOT NULL,\n" +
                        "  idAddress int(11) NOT NULL,\n" +
                        "  idDriverLicense varchar(10) DEFAULT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;",
        };
    }

    private static String[] getAllInsertSQLs() {
        return new String[] {
                "INSERT INTO addresses (id, idStreet, building, flat) VALUES\n" +
                        "(1, 1, '20', '12'),\n" +
                        "(2, 2, '103', '14'),\n" +
                        "(3, 3, '58', '121'),\n" +
                        "(4, 4, '19', '5'),\n" +
                        "(5, 5, '2/2', '10'),\n" +
                        "(6, 1, '20A', '15');\n",
                "INSERT INTO cars (id, idModel, idTransmission, idColor, year, fullPrice, dayPrice, comment) VALUES\n" +
                        "(1, 1, 1, 3, 2010, 7000, 35, NULL),\n" +
                        "(2, 1, 2, 2, 2009, 6500, 30, NULL),\n" +
                        "(3, 2, 2, 3, 2012, 10000, 50, NULL),\n" +
                        "(4, 3, 1, 2, 2000, 5000, 25, NULL),\n" +
                        "(5, 4, 1, 2, 2013, 6000, 30, NULL),\n" +
                        "(6, 2, 2, 3, 2005, 9000, 45, NULL),\n" +
                        "(7, 3, 2, 2, 2001, 5200, 25, NULL),\n" +
                        "(8, 2, 1, 1, 2015, 18000, 90, NULL);",
                "INSERT INTO car_manufacturers (id, manufacturer) VALUES\n" +
                        "(1, 'Suzuki'),\n" +
                        "(2, 'Toyota'),\n" +
                        "(3, 'Nissan'),\n" +
                        "(4, 'Ford');",
                "INSERT INTO car_models (id, idManufacturer, model) VALUES\n" +
                        "(1, '1', 'SX4'),\n" +
                        "(2, '2', 'RAV4'),\n" +
                        "(3, '3', 'Qashqai'),\n" +
                        "(4, '4', 'Focus');\n",
                "INSERT INTO car_transmissions (id, type) VALUES\n" +
                        "(1, 'Auto'),\n" +
                        "(2, 'Mechanic');",
                "INSERT INTO cities (id, idCountry, city) VALUES\n" +
                        "(1, 1, 'Минск'),\n" +
                        "(2, 1, 'Витебск'),\n" +
                        "(3, 2, 'Москва'),\n" +
                        "(4, 2, 'Санкт-Петербург');",
                "INSERT INTO colors (id, color) VALUES\n" +
                        "(1, 'красный'),\n" +
                        "(2, 'синий'),\n" +
                        "(3, 'белый'),\n" +
                        "(4, 'черный');",
                "INSERT INTO countries (id, country) VALUES\n" +
                        "(1, 'Belarus'),\n" +
                        "(2, 'Russia');",
                "INSERT INTO dl_categories (id, category) VALUES\n" +
                        "(1, 'A'),\n" +
                        "(2, 'Am'),\n" +
                        "(3, 'B'),\n" +
                        "(4, 'C'),\n" +
                        "(5, 'D'),\n" +
                        "(6, 'E');",
                "INSERT INTO driver_licenses (id, serial, issued, expire, idCategory) VALUES \n" +
                        "(1, 'AA123123', '2010-07-04', '2020-07-06', 3),\n" +
                        "(2, 'BB987987', '2008-01-16', '2018-01-15', 3),\n" +
                        "(3, 'CC123123', '2014-10-14', '2024-10-13', 3),\n" +
                        "(4, 'DD987987', '2011-05-10', '2021-05-09', 4),\n" +
                        "(5, 'EE987987', '2011-08-17', '2021-08-16', 3),\n" +
                        "(6, 'FF987987', '2013-09-20', '2023-09-19', 3);",
                "INSERT INTO rents (id, idCar, idUser, startDate, endDate, cost, paid) VALUES \n" +
                        "(1, 1, 1, '2016-04-04', '2016-04-08', 100, 1),\n" +
                        "(2, 1, 2, '2016-02-08', '2016-02-24', 220, 1),\n" +
                        "(3, 3, 3, '2016-06-01', '2016-07-01', 80, 1),\n" +
                        "(4, 1, 4, '2016-03-07', '2016-03-09', 90, 1),\n" +
                        "(5, 4, 5, '2016-10-02', '2016-10-04', 120, 1),\n" +
                        "(6, 3, 5, '2016-10-10', '2016-10-12', 150, 1);",
                "INSERT INTO roles (id, role) VALUES \n" +
                        "(1, 'Администратор'),\n" +
                        "(2, 'Пользователь');",
                "INSERT INTO sex (id, type) VALUES \n" +
                        "(1, 'Male'),\n" +
                        "(2, 'Female'),\n" +
                        "(3, 'Transgendered to Male'),\n" +
                        "(4, 'Transgendered to Female');",
                "INSERT INTO streets (id, idCity, street) VALUES \n" +
                        "(1, 2, 'ул. Ленина'),\n" +
                        "(2, 3, 'ул. Ленина'),\n" +
                        "(3, 3, 'ул. Строителей'),\n" +
                        "(4, 4, 'ул. Строителей'),\n" +
                        "(5, 4, 'ул. Садовая');",
                "INSERT INTO users (id, login, password, email, idRole, firstName, lastName, middleName, dateOfBirth, idSex, passport, idAddress, idDriverLicense) VALUES\n" +
                        "(1, 'ivan1971', 'ivan1971pass', 'ivan1971@tut.by', 2, 'Иванченко', 'Юрий', NULL, '1971-12-15', 1, 'AB123456', 1, 'AA123123'),\n" +
                        "(2, 'hannapavlova', 'pavlovahanna', 'hanna-flowe@yandex.ru', 2, 'Анна', 'Павлова', NULL, '1980-01-11', 2, 'AB9876543', 2, 'BB987987'),\n" +
                        "(3, 'root', 'pass', 'superment79@tut.by', 2, 'Сергей', 'Волков', NULL, '1979-03-10', 3, 'BM123456', 3, 'CC123123'),\n" +
                        "(4, 'rediska', 'olga1981', 'olga1981@mail.ru', 2, 'Ольга', 'Полтавская', NULL, '1981-01-11', 4, 'BM9876543', 4, 'DD987987'),\n" +
                        "(5, 'fiona', 'password', 'fiona-soup4ik@tut.by', 2, 'Фиона', 'Борщевская', NULL, '1962-04-04', 2, 'HB9876543', 5, 'EE987987'),\n" +
                        "(6, 'korol', 'korolyov', 'akorolyov@epam.com', 1, 'Андрей', 'Королев', NULL, '1981-02-15', 1, 'HB123456', 6, 'FF987987');",
        };
    }

}
