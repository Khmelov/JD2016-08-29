package by.it.senchenko.jd03_03.dao;

import by.it.senchenko.jd03_03.beans.Ad;
import by.it.senchenko.jd03_03.CN;

import java.sql.*;
import java.util.*;

public class AdDAO extends AbstractClassDAO implements InterfaceForDAO
        <Ad> {
    @Override
    public Ad read(int id) {
        List<Ad> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);        } else
            return null;
    }

    @Override
    public boolean create(Ad ad) {
        String sql = String.format(Locale.ENGLISH,
                "insert INTO ad(Name, Autor, Date, FK_User)" +
                        "\n values('%s', '%s', '%s' ,'%d');",
                ad.getName(),
                ad.getAutor(),
                ad.getDate(),
                ad.getFK_User()
        );
        ad.setID(executeUpdate(sql));
        return (ad.getID() > 0);
    }

    @Override
    public boolean update(Ad ad) {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ad` SET " +
                        "`Name`=%d " +
                        ",`Autor`='%s'" +
                        ",`Date`='%s'" +
                        ",`FK_User`=%d" +
                        " WHERE `ad`.`ID` = %d",
                ad.getName(),
                ad.getAutor(),
                ad.getDate(),
                ad.getFK_User(),
                ad.getID()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Ad ad) {
        String sql = String.format(
                "DELETE FROM `ad` WHERE `ad`.`ID`=%d;", ad.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Ad> getAll(String WHERE) {
        List<Ad> ads = new ArrayList<>();
        String sql = "SELECT * FROM ad " + WHERE + " ;";
        try (Connection connection = CN.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Ad ad = new Ad();
                ad.setID(resultSet.getInt("ID"));
                ad.setName(resultSet.getString("Name"));
                ad.setAutor(resultSet.getString("Autor"));
                ad.setDate(resultSet.getString("Date"));
                ad.setFK_User(resultSet.getInt("FK_Users"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
