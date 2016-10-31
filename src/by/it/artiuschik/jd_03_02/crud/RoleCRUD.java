package by.it.artiuschik.jd_03_02.crud;

import by.it.artiuschik.jd_03_02.utils.ConnectionCreator;
import by.it.artiuschik.jd_03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class RoleCRUD {
    public Role create(Role role) throws SQLException {
        role.setID(0);
        //составление строки createUserSQL по данным Bean User
        String createUserSQL = String.format(
                "insert into roles(Role_name) values('%s');",
                role.getRole_name()
        );
        try (
                //соединение с базой
                Connection connection = ConnectionCreator.getConnection();
                //объект для обращения к базе
                Statement statement = connection.createStatement()
        ) {
            int addedUsers = statement.executeUpdate(createUserSQL);
            if (addedUsers == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet первую строку
                if (resultSet.next())
                    role.setID(resultSet.getInt(1));
            }
        }
        return role;
    }

    public Role read(int id) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = "SELECT * FROM roles where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role_name"));
            }
        }
        return roleResult;
    }

    public Role update(Role role) throws SQLException {
        Role roleResult = null;
        String updateUserSQL = String.format(
                "UPDATE roles SET Name = '%s' WHERE roles.ID = %d",
                role.getRole_name(), role.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                roleResult = role;
        }
        return roleResult;
    }

    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteRoleSQL) == 1);
        }
    }

}
