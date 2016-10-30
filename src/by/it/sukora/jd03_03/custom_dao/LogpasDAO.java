package by.it.sukora.jd03_03.custom_dao;

import by.it.sukora.jd03_03.beans.logpas;
import by.it.sukora.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class LogpasDAO extends AbstractDAO implements InterfaceDAO<logpas>{

    @Override
    public logpas read(int id) {
        List<logpas> logpases = getAll("WHERE id=" + id + " LIMIT 0,5");
        if (logpases.size() > 0) {
            return logpases.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(logpas logpas) {
        String sql = String.format(
                "insert INTO logpas(" +
                        "Login," +
                        "Password" +
                        " values('%s','%s');",
                logpas.getLogin(),
                logpas.getPassword()
        );
        logpas.setId(executeUpdate(sql));
        return (logpas.getId() > 0);
    }

    @Override
    public boolean update(logpas logpas) {
        String sql = String.format(
                "UPDATE `logpas` SET" +
                        " `Login` = '%s'," +
                        " `Password` = '%s'" +
                        " WHERE `logpas`.`id` = %d",
                logpas.getLogin(),
                logpas.getPassword(),
                logpas.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(logpas logpas) {
        String sql = String.format(
                "DELETE FROM `logpas` WHERE `logpas`.`ID` = %d;", logpas.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<logpas> getAll(String WHERE) {
        List<logpas> logpases = new ArrayList<>();
        String sql = "SELECT * FROM logpas " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                logpas logpas = new logpas();
                logpas.setId(rs.getInt("id"));
                logpas.setLogin(rs.getString("Login"));
                logpas.setPassword(rs.getString("Password"));
                logpases.add(logpas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logpases;
    }
}
