package by.it.laurynovich.jd03_03.dao;

import by.it.laurynovich.jd03_03.beans.Bags;
import by.it.laurynovich.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nadabratb on 11/9/2016.
 */
public class BagsDAO extends AbstractDAO implements InterfaceDAO<Bags>{


           @Override
    public Bags read(int id) {
        List<Bags> bags = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (bags.size() > 0) {
            return bags.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Bags bags) {

        String sql = String.format(
                "insert INTO bags(user,ticket,n_flight)" + " values('%d','%d','%d');",
                bags.getUser(),bags.getTicket(),bags.getN_flight());

        bags.setIdBag(executeUpdate(sql));

        bags.setUser(bags.getIdBag());
        return (bags.getIdBag() > 0);
    }

    @Override
    public boolean update(Bags bags) {
        String sql = String.format(
                "UPDATE `bags` SET `user` = '%d',`ticket` = '%d',`n_flight` = '%d'",
                bags.getUser(),bags.getTicket(), bags.getN_flight()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Bags bags) {
        String sql = String.format(
                "DELETE FROM `bags` WHERE `bags`.`idBags` = %d;", bags.getIdBag());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Bags> getAll(String WHERE) {
        List<Bags> bags = new ArrayList<>();
        String sql = "SELECT * FROM bags " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Bags bag = new Bags();
                bag.setUser(rs.getInt("user"));
                bag.setTicket(rs.getInt("ticket"));
                bag.setN_flight(rs.getInt("n_flight"));
                bags.add(bag);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return bags;
    }
}
