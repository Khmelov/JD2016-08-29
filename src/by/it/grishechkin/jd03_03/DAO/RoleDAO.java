package by.it.grishechkin.jd03_03.DAO;

import by.it.grishechkin.jd03_03.beans.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Yury on 31.10.2016.
 */
public class RoleDAO implements IDAO<Role> {
    @Override
    public int create(Role role) {
        int key = 0;
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"INSERT INTO role (Name)" +
                            " VALUES ('%s');",
                    role.getName()), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            key = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(key);
        return key;
    }

    @Override
    public void read(int id) {
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM role WHERE role.ID=" + id + ";" ));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role role) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"UPDATE role SET Name='%s' WHERE role.ID=" + role.getID() + ";",
                    role.getName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Role role) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"DELETE FROM role WHERE role.ID=" + role.getID() + ";"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAll() {
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM role;"));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
