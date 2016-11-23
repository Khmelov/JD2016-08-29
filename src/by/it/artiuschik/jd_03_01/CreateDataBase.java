package by.it.artiuschik.jd_03_01;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

class CreateDataBase {
    private static String getRole(int id) throws SQLException {
        String res = null;
        Connection connection = DriverManager.getConnection
                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM roles WHERE roles.ID=%d ;",id));
        if (resultSet.next())
            res = resultSet.getString("Role_name");
        return res;
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection
                    (CN.URL_DB_2, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("DROP DATABASE IF EXISTS %s","artiuschik"));
            statement.executeUpdate(String.format("CREATE DATABASE %s CHARACTER SET %s COLLATE %s","artiuschik","utf8","utf8_general_ci"));
            if (!connection.isClosed())
                System.out.println("БАЗА ДАННЫХ СОЗДАНА");
            connection = DriverManager.getConnection
                    (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            if (!connection.isClosed())
                System.out.println("СОЕДИНЕНИЕ С БАЗОЙ...");
            statement = connection.createStatement();
            statement.executeUpdate(String.format("DROP TABLE IF EXISTS %s; ","users"));
            //создание таблицы пользователей
            String createTableSQL =
                    String.format("CREATE TABLE %s (ID INT NULL AUTO_INCREMENT ,Name VARCHAR(100) NOT NULL ,Surname VARCHAR(100) NOT NULL ,Password VARCHAR(100) NOT NULL, Login VARCHAR(100) NOT NULL, Tests_amount INT NOT NULL , Balls INT NOT NULL , FK_ROLE INT NOT NULL , PRIMARY KEY (ID))","users");
            statement.executeUpdate(createTableSQL);
            //создание таблицы ролей
            createTableSQL =
                    String.format("CREATE TABLE %s (ID INT NULL AUTO_INCREMENT ,Role_name VARCHAR(100) NOT NULL , PRIMARY KEY (ID))","roles");
            statement.executeUpdate(createTableSQL);
            //создание таблицы тестов
            createTableSQL =
                    String.format("CREATE TABLE %s (ID INT NULL AUTO_INCREMENT , Name VARCHAR(100) NOT NULL , Subject VARCHAR(100) NOT NULL , Questions INT NOT NULL , PRIMARY KEY (ID))","tests");
            statement.executeUpdate(createTableSQL);
            //создание таблицы вопросов
            createTableSQL = String.format("CREATE TABLE %s (ID INT NULL AUTO_INCREMENT , Text VARCHAR(1000) NOT NULL , Subject VARCHAR(100) NOT NULL , Varianta VARCHAR(1000) NOT NULL , Variantb VARCHAR(1000) NOT NULL , Balls INT NOT NULL , Answer INT NOT NULL , FK_TEST INT NOT NULL, PRIMARY KEY (ID))","questions");
            statement.executeUpdate(createTableSQL);
            //заполнение  users
            statement.executeUpdate("INSERT INTO users (ID, Name, Surname, Password, Login, Tests_amount, Balls, FK_ROLE) VALUES (NULL, 'Иван', 'Иванов', '1232', 'ivaniv97', '3', '30', '1')");
            statement.executeUpdate("INSERT INTO users (ID, Name, Surname, Password, Login, Tests_amount, Balls, FK_ROLE) VALUES (NULL, 'Петр', 'Петров', '1245', 'petrp96', '3', '30', '2')");
            statement.executeUpdate("INSERT INTO users (ID, Name, Surname, Password, Login, Tests_amount, Balls, FK_ROLE) VALUES (NULL, 'Василий', 'Васильев', '6785', 'vasilvas98', '3', '30', '2')");
            //заполнение  roles
            statement.executeUpdate("INSERT INTO roles (ID, Role_name) VALUES (NULL, 'Студент')");
            statement.executeUpdate("INSERT INTO roles (ID, Role_name) VALUES (NULL, 'Тьютор')");
            //заполнение  tests
            statement.executeUpdate("INSERT INTO tests (ID, Name, Subject, Questions) VALUES (NULL, 'Законы Ньютона', 'Физика', '3')");
            statement.executeUpdate("INSERT INTO tests (ID, Name, Subject, Questions) VALUES (NULL, 'Механическое движение', 'Физика', '3')");
            //заполнение  questions
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Varianta, Variantb, Balls, Answer, FK_TEST) VALUES (NULL, 'Единица измерения силы в СИ —', 'Физика', 'Ньютон', 'Джоуль', '1', '1', '1')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Varianta, Variantb, Balls, Answer, FK_TEST) VALUES (NULL, 'Если на тело не действуют другие тела, то оно…', 'Физика', 'находится в покое или движется равномерно прямолинейно', 'движется с изменяющейся скоростью', '1', '1', '1')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Varianta, Variantb, Balls, Answer, FK_TEST) VALUES (NULL, 'Тело движется прямолинейно с постоянной скоростью. Какое утверждение о равнодействующей всех приложенных к нему сил правильно?', 'Физика', 'Равна нулю', 'Не равна нулю и постоянна по модулю и направлению', '1', '1', '1')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Varianta, Variantb, Balls, Answer, FK_TEST) VALUES (NULL, 'Механическим движением тела называют?', 'Физика', 'изменение положения тела в пространстве с течением времени', 'изменение положения тела на плоскости', '1', '1', '2')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Varianta, Variantb, Balls, Answer, FK_TEST) VALUES (NULL, 'Какую систему координат используют для точного указания положения материальной точки в пространстве?', 'Физика', 'прямоугольную', 'коническую', '1', '1', '2')");
            statement.executeUpdate("INSERT INTO questions (ID, Text, Subject, Varianta, Variantb, Balls, Answer, FK_TEST) VALUES (NULL, 'Вектор, проведенный из центра системы в любую точку, называется?', 'Физика', 'радиус-вектор', 'центральный вектор', '1', '1', '2')");
            //вывод users
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("Name") + ", " + resultSet.getString("Surname") + ", " + getRole(resultSet.getInt("FK_ROLE"));
                System.out.println(out);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
