package by.it.laurynovich.jd03_03.dao;

import by.it.laurynovich.jd03_03.beans.Tickets;
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
public class TicketsDAO extends AbstractDAO implements InterfaceDAO<Tickets>{

    @Override
    public Tickets read(int idTickets) {
        List<Tickets> users = getAll("WHERE ID=" + idTickets + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Tickets tickets) {
        String sql = String.format(
                "insert INTO tickets (n_flight,user,price)" +
                        " values('%s','%d',%d);",
                tickets.getN_flight(),tickets.getUser(),tickets.getPrice());
        tickets.setIdTicket(executeUpdate(sql));
        return (tickets.getIdTicket() > 0);
    }

    @Override
    public boolean update(Tickets tickets) {
        String sql = String.format(
                "UPDATE `tickets` SET `n_flight` = '%s', `user` = '%d', `price` = '%d'",
                tickets.getN_flight(), tickets.getUser(),tickets.getPrice()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Tickets tickets) {
        String sql = String.format(
                "DELETE FROM `tickets` WHERE `tickets`.`idTickets` = %d;", tickets.getIdTicket()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Tickets> getAll(String WHERE) {
        List<Tickets> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Tickets ticket = new Tickets();
                ticket.setN_flight(rs.getNString("flight"));
                ticket.setPrice(rs.getInt("price"));
                ticket.setUser(rs.getInt("users"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return tickets;

    }
}
