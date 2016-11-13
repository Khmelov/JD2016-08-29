package by.it.grishechkin.project.java.DAO;

import by.it.grishechkin.project.java.beans.User;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yury on 30.10.2016.
 */
public class UserDAO implements IDAO<User> {

    @Override
    public int create(User user) {
        int key = 0;
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"INSERT INTO user (firstName, lastName, pasportNum, FK_Role, login, password)" +
                            " VALUES ('%s', '%s', '%s', '%d', '%s', '%s');",
                    user.getFirstName(), user.getLastName(), user.getPasportNum(), user.getFK_Role(), user.getLogin(), user.getPassword()), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            key = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    @Override
    public List<User> read(User user) {
        List<User> users = new ArrayList<>();
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM user WHERE user.Login='" + user.getLogin() + "';"));
            users = execute(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"UPDATE user SET firstName='%s', lastName='%s', pasportNum='%s', FK_Role='%d', login='%s', password='%s' WHERE user.ID=" + user.getID() + ";",
                    user.getFirstName(), user.getLastName(), user.getPasportNum(), user.getFK_Role(), user.getLogin(), user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"DELETE FROM user WHERE user.ID=" + user.getID() + ";"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM user;" ));
            users = execute(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private List<User> execute(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setID(resultSet.getInt("ID"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setPasportNum(resultSet.getString("pasportNum"));
                user.setFK_Role(resultSet.getInt("FK_Role"));
                user.setLogin(resultSet.getString("Login"));
                user.setPassword(resultSet.getString("Password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
