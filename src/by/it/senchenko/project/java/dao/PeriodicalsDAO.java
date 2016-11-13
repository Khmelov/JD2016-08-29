package by.it.senchenko.project.java.dao;

import by.it.senchenko.project.java.beans.Periodicals;
import by.it.senchenko.project.java.CN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PeriodicalsDAO extends AbstractClassDAO implements InterfaceForDAO<Periodicals> {
    @Override
    public Periodicals read(int id) {
        List<Periodicals> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);        } else
            return null;
    }

    @Override
    public boolean create(Periodicals periodicals) {
        String sql = String.format(Locale.ENGLISH,
                "insert INTO periodicals(Name, Autor, Date, FK_User)" +
                        "\n values('%s', '%s', '%s' ,'%d');",
                periodicals.getName(),
                periodicals.getAutor(),
                periodicals.getDate(),
                periodicals.getFK_User()
        );
        periodicals.setID(executeUpdate(sql));
        return (periodicals.getID() > 0);
    }

    @Override
    public boolean update(Periodicals periodicals) {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `periodicals` SET " +
                        "`Name`=%s " +
                        ",`Autor`='%s'" +
                        ",`Date`='%s'" +
                        ",`FK_User`=%d" +
                        " WHERE `periodicals`.`ID` = %d",
                periodicals.getName(),
                periodicals.getAutor(),
                periodicals.getDate(),
                periodicals.getFK_User(),
                periodicals.getID()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Periodicals periodicals) {
        String sql = String.format(
                "DELETE FROM `periodicals` WHERE `periodicals`.`ID`=%d;", periodicals.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Periodicals> getAll(String WHERE) {
        List<Periodicals> per = new ArrayList<>();
        String sql = "SELECT * FROM periodicals " + WHERE + " ;";
        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Periodicals periodicals = new Periodicals();
                periodicals.setID(resultSet.getInt("ID"));
                periodicals.setName(resultSet.getString("Name"));
                periodicals.setAutor(resultSet.getString("Autor"));
                periodicals.setDate(resultSet.getString("Date"));
                periodicals.setFK_User(resultSet.getInt("FK_User"));
                per.add(periodicals);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return per;
    }
}
