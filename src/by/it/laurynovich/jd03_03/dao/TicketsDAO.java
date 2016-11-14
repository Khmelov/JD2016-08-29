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
        List<Tickets> ticket = getAll("WHERE ID=" + idTickets + " LIMIT 0,1");
        if (ticket.size() > 0) {
            return ticket.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Tickets tickets) {
        String sql = String.format(
                "insert INTO tickets (idTicket,user,price,n_flight)" +
                        " values(%d,'%d','%d','%d');",
                tickets.getIdTicket(),tickets.getUser(),tickets.getPrice(),tickets.getN_flight());
        tickets.setIdTicket(executeUpdate(sql));
        return (tickets.getIdTicket() > 0);
    }

    @Override
    public boolean update(Tickets tickets) {
        String sql = String.format(
                "UPDATE `tickets` SET `n_flight` = '%d', `user` = '%d', `price` = '%d'",
                tickets.getN_flight(), tickets.getUser(),tickets.getPrice()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Tickets tickets) {
        String sql = String.format(
                "DELETE FROM `tickets` WHERE `tickets`.`idTicket` = %d;", tickets.getIdTicket()
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
                ticket.setIdTicket(rs.getInt("idTicket"));
                ticket.setN_flight(rs.getInt("n_flight"));
                ticket.setPrice(rs.getInt("price"));
                ticket.setUser(rs.getInt("user"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return tickets;

    }
}
