package by.it.savelyeva.jd_03_02;

import by.it.savelyeva.jd_03_02.crud.Rent;
import by.it.savelyeva.jd_03_02.crud.RentCRUD;
import by.it.savelyeva.jd_03_02.crud.User;
import by.it.savelyeva.jd_03_02.crud.UserCRUD;

import java.sql.*;

/**
 * Created by nato on 10/27/16.
 */
public class Main {

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

    private static int runQueryAndPrint(String sql) {
        int count = 0;
        try (
            Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(
                            //resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t"
                    );
                }
                System.out.println();
                count++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println("\n\nTask C: Recreate DB (1) using beans, (2) using SQL queries. Make test coverage for CRUD.");
        fillUserTableCRUD(); // (1)
        recreateDB(); // (2)
        System.out.println("RentTest.java contains jUnit tests for Rent CRUD.");

        System.out.println("\n\nTask A: Find role id by given role name. Do CRUD for Users table.");
        searchIdRoleByName("Администратор");
        searchIdRoleByName("Модератор");
        searchIdRoleByName("Пользователь");
        usersDemoCRUD();
        rentsDemoCRUD();

        System.out.println("\n\nTask B: Display all users with their text roles. Display users count and roles count.");
        getStatisticsUsersRoles();
        //displayUsersDetailed(); // Optional
    }

    public static void searchIdRoleByName(String role) {
        int count = runQueryAndPrint("SELECT id FROM roles WHERE role='" + role + "'");
        if (count == 0) System.out.println("No entries found for role = " + role);
    }


    public static void getStatisticsUsersRoles() {
        String sql =  "SELECT " +
                            "users.id, " +
                            "CONCAT(users.first_name, ' ', users.last_name) AS user, " +
                            "roles.role FROM users INNER JOIN roles ON users.role_id=roles.id " +
                      "UNION " +
                            "SELECT " +
                                "'TOTAL', " +
                                "CONCAT('users: ', COUNT(u.id)) AS users_count, " +
                                "CONCAT('roles: ', (SELECT COUNT(*) FROM roles)) AS roles_count " +
                            "FROM users u";
        runQueryAndPrint(sql);
    }

    public static void fillUserTableCRUD() {
        User[] users = new User[] {
                new User(1, "ivan1971", "ivan1971pass", "ivan1971@tut.by", 2,
                        "Юрий", "Иванченко", null, "1971-12-15", 1, "AB123456", 1, "AA123123"),

                new User(2, "hannapavlova", "pavlovahanna", "hanna-flowe@yandex.ru", 2,
                        "Анна", "Павлова", null, "1980-01-11", 2, "AB9876543", 2, "BB987987"),

                new User(3, "root", "pass", "superment1979@gmail.com", 2,
                        "Сергей", "Волков", null, "1979-03-10", 1, "BM123456", 3, "CC123123"),

                new User(4, "rediska", "olga1981", "olga1981@mail.ru", 2,
                        "Ольга", "Поплавская", null, "1981-01-11", 1, "BM9876543", 4, "DD987987"),

                new User(5, "fiona", "password", "fiona-soup4ik@gmail.com", 2,
                        "Фиона", "Борщевская", null, "1962-04-04", 1, "HB9876543", 5, "EE987987"),

                new User(6, "korol", "korolyov", "ivan1971@tut.byAndrei_Korolyov@epam.com", 1,
                        "Андрей", "Королев", null, "1981-02-15", 1, "HB123456", 6, "FF987987"),
        };

        try {
            for (User user: users) {
                UserCRUD userCRUD = new UserCRUD();
                userCRUD.create(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void usersDemoCRUD() {
        User user = new User(0, "javacoder", "javaforever", "java-coder@gmail.com", 1,
                            "Alexei", "Petrov", null, "1996-08-08", 1, "NM123456", 6, "AB123123");
        try {
            // create
            UserCRUD userCRUD = new UserCRUD();
            user = userCRUD.create(user);

            // read
            System.out.print(userCRUD.read(user.getId()));

            // update
            user.setLogin("loginUpdated");
            user = userCRUD.update(user);
            System.out.print(userCRUD.read(user.getId()));

            // delete
            if (userCRUD.delete(user))
                System.out.print("Deleted user w/ id = " + user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rentsDemoCRUD() {
        Rent rent = new Rent(6, 3, 5, "2016-10-21", "2016-10-25", 70, true);
        try {
            // create
            RentCRUD rentCRUD = new RentCRUD();
            rent = rentCRUD.create(rent);

            // read
            System.out.print(rentCRUD.read(rent.getId()));

            // update
            rent.setEndDate("2016-10-28");
            rent = rentCRUD.update(rent);
            System.out.print(rentCRUD.read(rent.getId()));

            // delete
            if (rentCRUD.delete(rent))
                System.out.print("Deleted rent AD w/ id = " + rent.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private static void displayUsersDetailed() {
        runQueryAndPrint("SELECT users.id, roles.role, users.first_name, users.last_name " +
                         "GROUP BY users.idRole;"
        );
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
                        "  street_id int(11) NOT NULL,\n" +
                        "  building varchar(10) NOT NULL,\n" +
                        "  flat varchar(5) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;\n",
                "CREATE TABLE IF NOT EXISTS cars (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  model_id int(11) NOT NULL,\n" +
                        "  transmission_id int(11) NOT NULL,\n" +
                        "  color_id int(11) NOT NULL,\n" +
                        "  year int(11) NOT NULL,\n" +
                        "  full_price int(11) NOT NULL,\n" +
                        "  day_price int(11) NOT NULL,\n" +
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
                        "  manufacturer_id varchar(15) NOT NULL,\n" +
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
                        "  country_id int(11) NOT NULL,\n" +
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
                        "  dl_issued date NOT NULL,\n" +
                        "  dl_expire date NOT NULL,\n" +
                        "  dl_category_id int(11) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;",
                "CREATE TABLE IF NOT EXISTS rents (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  car_id int(11) NOT NULL,\n" +
                        "  user_id int(11) NOT NULL,\n" +
                        "  start_date date NOT NULL,\n" +
                        "  end_date date NOT NULL,\n" +
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
                        "  city_id int(11) NOT NULL,\n" +
                        "  street varchar(20) NOT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;\n",
                "CREATE TABLE IF NOT EXISTS users (\n" +
                        "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  login varchar(20) NOT NULL,\n" +
                        "  password varchar(20) NOT NULL,\n" +
                        "  email varchar(255) NOT NULL,\n" +
                        "  role_id int(11) NOT NULL DEFAULT '2',\n" +
                        "  first_name varchar(20) NOT NULL,\n" +
                        "  last_name varchar(20) NOT NULL,\n" +
                        "  middle_name varchar(20) DEFAULT NULL,\n" +
                        "  date_of_birth date NOT NULL,\n" +
                        "  sex_id tinyint(4) NOT NULL,\n" +
                        "  passport varchar(9) NOT NULL,\n" +
                        "  address_id int(11) NOT NULL,\n" +
                        "  driver_license varchar(10) DEFAULT NULL,\n" +
                        "  PRIMARY KEY (id)\n" +
                        ") ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;",
        };
    }

    private static String[] getAllInsertSQLs() {
        return new String[] {
                "INSERT INTO addresses (id, street_id, building, flat) VALUES\n" +
                        "(1, 1, '20', '12'),\n" +
                        "(2, 2, '103', '14'),\n" +
                        "(3, 3, '58', '121'),\n" +
                        "(4, 4, '19', '5'),\n" +
                        "(5, 5, '2/2', '10'),\n" +
                        "(6, 1, '20A', '15');\n",
                "INSERT INTO cars (id, model_id, transmission_id, color_id, year, full_price, day_price, comment) VALUES\n" +
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
                "INSERT INTO car_models (id, manufacturer_id, model) VALUES\n" +
                        "(1, '1', 'SX4'),\n" +
                        "(2, '2', 'RAV4'),\n" +
                        "(3, '3', 'Qashqai'),\n" +
                        "(4, '4', 'Focus');\n",
                "INSERT INTO car_transmissions (id, type) VALUES\n" +
                        "(1, 'Auto'),\n" +
                        "(2, 'Mechanic');",
                "INSERT INTO cities (id, country_id, city) VALUES\n" +
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
                "INSERT INTO driver_licenses (id, serial, dl_issued, dl_expire, dl_category_id) VALUES\n" +
                        "(1, 'AA123123', '2010-07-04', '2020-07-06', 3),\n" +
                        "(2, 'BB987987', '2008-01-16', '2018-01-15', 3),\n" +
                        "(3, 'CC123123', '2014-10-14', '2024-10-13', 3),\n" +
                        "(4, 'DD987987', '2011-05-10', '2021-05-09', 4),\n" +
                        "(5, 'EE987987', '2011-08-17', '2021-08-16', 3),\n" +
                        "(6, 'FF987987', '2013-09-20', '2023-09-19', 3);",
                "INSERT INTO rents (id, car_id, user_id, start_date, end_date, cost, paid) VALUES\n" +
                        "(1, 1, 1, '2016-04-04', '2016-04-08', 100, 1),\n" +
                        "(2, 1, 2, '2016-02-08', '2016-02-24', 220, 1),\n" +
                        "(3, 3, 3, '2016-06-01', '2016-07-01', 80, 1),\n" +
                        "(4, 1, 4, '2016-03-07', '2016-03-09', 90, 1),\n" +
                        "(5, 4, 5, '2016-10-02', '2016-10-04', 120, 1),\n" +
                        "(6, 3, 5, '2016-10-10', '2016-10-12', 150, 1);",
                "INSERT INTO roles (id, role) VALUES\n" +
                        "(1, 'Администратор'),\n" +
                        "(2, 'Пользователь');",
                "INSERT INTO sex (id, type) VALUES\n" +
                        "(1, 'Male'),\n" +
                        "(2, 'Female'),\n" +
                        "(3, 'Transgendered to Male'),\n" +
                        "(4, 'Transgendered to Female');",
                "INSERT INTO streets (id, city_id, street) VALUES\n" +
                        "(1, 2, 'ул. Ленина'),\n" +
                        "(2, 3, 'ул. Ленина'),\n" +
                        "(3, 3, 'ул. Строителей'),\n" +
                        "(4, 4, 'ул. Строителей'),\n" +
                        "(5, 4, 'ул. Садовая');",
                "INSERT INTO users (id, login, password, email, role_id, first_name, last_name, middle_name, date_of_birth, sex_id, passport, address_id, driver_license) VALUES\n" +
                        "(1, 'ivan1971', 'ivan1971pass', 'ivan1971@tut.by', 2, 'Иванченко', 'Юрий', NULL, '1971-12-15', 1, 'AB123456', 1, 'AA123123'),\n" +
                        "(2, 'hannapavlova', 'pavlovahanna', 'hanna-flowe@yandex.ru', 2, 'Анна', 'Павлова', NULL, '1980-01-11', 2, 'AB9876543', 2, 'BB987987'),\n" +
                        "(3, 'root', 'pass', 'superment1979@gmail.com', 2, 'Сергей', 'Волков', NULL, '1979-03-10', 3, 'BM123456', 3, 'CC123123'),\n" +
                        "(4, 'rediska', 'olga1981', 'olga1981@mail.ru', 2, 'Ольга', 'Полтавская', NULL, '1981-01-11', 4, 'BM9876543', 4, 'DD987987'),\n" +
                        "(5, 'fiona', 'password', 'fiona-soup4ik@gmail.com', 2, 'Фиона', 'Борщевская', NULL, '1962-04-04', 2, 'HB9876543', 5, 'EE987987'),\n" +
                        "(6, 'korol', 'korolyov', 'Andrei_Korolyov@epam.com', 1, 'Андрей', 'Королев', NULL, '1981-02-15', 1, 'HB123456', 6, 'FF987987');",
        };
    }

}
